package com.example.diettracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.URL;

public class Activity5 extends AppCompatActivity {

    EditText weightEditText, heightEditText, ageEditText;
    Spinner genderSpinner, activitySpinner;
    Button calculateButton,back;
    TextView resultTextView;
    private static final int PERMISSION_STORAGE_CODE = 1000;
    PDFView caloriechart;
    Button b1;
    String weburl1 = "https://www.txliver.com/wp-content/uploads/2015/08/1800-Calorie-Meal-Plans.pdf";
    String weburl2 = "https://fitbodybootcamp.com/wp-content/uploads/1900-Paleo-Meal-Plan.pdf";
    String weburl3 = "https://caloriecontrol.org/wp-content/uploads/2000-Calories-a-Day-The-Healthy-Way.pdf";
    String weburl4 = "https://fitbodybootcamp.com/wp-content/uploads/2100-Paleo-Meal-Plan.pdf";
    String weburl5 = "https://maxxlifegym.com/wp-content/mealplans/Maxx90/2200%20Meal%20Plan.pdf";

    String weburl = weburl1;

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_5);
        back = findViewById(R.id.back);

        // Find views by their IDs

        caloriechart = findViewById(R.id.pdf_chart1);
        b1 = findViewById(R.id.download);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(Activity5.this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                    ActivityCompat.requestPermissions(Activity5.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_STORAGE_CODE);
                } else {
                    startDownload();
                }
            }
        });


        weightEditText = findViewById(R.id.weight);
        heightEditText = findViewById(R.id.height);
        ageEditText = findViewById(R.id.age);
        genderSpinner = findViewById(R.id.gender);
        activitySpinner = findViewById(R.id.activity);
        calculateButton = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.result_textview);


        String[] genders = {"Male", "Female"};
        ArrayAdapter<String> genderAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, genders);
        genderAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(genderAdapter);


        String[] activityLevels = {"No Activity", "Lightly Active", "Moderately Active", "Very Active", "Extra Active"};
        ArrayAdapter<String> activityAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, activityLevels);
        activityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        activitySpinner.setAdapter(activityAdapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateTotalCalories();
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity5.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculateTotalCalories() {
        // Calculate BMR based on the provided formula
        double weight = Double.parseDouble(weightEditText.getText().toString());
        double height = Double.parseDouble(heightEditText.getText().toString());
        int age = Integer.parseInt(ageEditText.getText().toString());

        double bmr;
        if (genderSpinner.getSelectedItem().toString().equalsIgnoreCase("male")) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        // Calculate total daily calorie needs based on activity level
        double activityFactor;
        switch (activitySpinner.getSelectedItemPosition()) {
            case 0:
                activityFactor = 1.2; // Sedentary
                break;
            case 1:
                activityFactor = 1.375; // Lightly active
                break;
            case 2:
                activityFactor = 1.55; // Moderately active
                break;
            case 3:
                activityFactor = 1.725; // Very active
                break;
            case 4:
                activityFactor = 1.9; // Extra active
                break;
            default:
                activityFactor = 1.2; // Default to sedentary
        }

        double totalCalories = bmr * activityFactor;


        if (totalCalories >= 2200) {
            weburl = weburl5;
        } else if (totalCalories >= 2100) {
            weburl = weburl4;
        } else if (totalCalories >= 2000) {
            weburl = weburl3;
        } else if (totalCalories >= 1900) {
            weburl = weburl2;
        } else {
            weburl = weburl1;
        }

        new Activity5.downloadpdf().execute(weburl);



        resultTextView.setText(String.format("Daily Calories Need: %.2f", totalCalories));
    }



    class downloadpdf extends AsyncTask<String,Void,InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode()==200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            } catch (IOException e) {
                return null;
            }
            return inputStream;
        }


        @Override
        protected void onPostExecute(InputStream inputStream) {
            caloriechart.fromStream(inputStream).load();
        }
    }

    private void startDownload(){
        String url = weburl;
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription("Donloading Chart...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,""+System.currentTimeMillis());
        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                    startDownload();
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_LONG).show();
                }
            }
        }

    }
}
