package com.example.diettracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button b1, b2,b3,b4,b5,b6;
    ImageButton sb,sb1;
    public int bmi = 0;
    Switch switcher;
    boolean nightMODE;
    TextView t1,t2;

    private boolean isUserInteracted = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sb = findViewById(R.id.switch_mode);
        sb1 = findViewById(R.id.night);
        t1 = findViewById(R.id.priyanshu);
        t2 = findViewById(R.id.sudhanshu);
        sb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateModeTask(AppCompatDelegate.MODE_NIGHT_NO).execute();

            }
        });

        sb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new UpdateModeTask(AppCompatDelegate.MODE_NIGHT_YES).execute();

            }
        });

        b1 = findViewById(R.id.CalorieChart);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this,Activity1.class);
                startActivity(intent1);
            }
        });


        b2 = findViewById(R.id.CalorieTrack);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MainActivity.this,Activity2.class);
                startActivity(intent2);
            }
        });


        b3 = findViewById(R.id.BMI);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MainActivity.this,Activity3.class);
                startActivity(intent3);
            }
        });


        b4 = findViewById(R.id.BodyFat);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this,Activity4.class);
                intent4.putExtra("bmi",bmi);
                startActivity(intent4);
            }
        });


        b5 = findViewById(R.id.CheatMeal);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5 = new Intent(MainActivity.this,Activity5.class);
                startActivity(intent5);
            }
        });


        b6 = findViewById(R.id.Custom);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent6 = new Intent(MainActivity.this,Activity6.class);
                startActivity(intent6);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/priyanshu-niranjan-osdbms/");
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.linkedin.com/in/sudhanshu-kumar-a43963200/");
            }
        });

    }

    private void gotoUrl(String s){
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }


    private class UpdateModeTask extends AsyncTask<Void, Void, Void> {

        private final int mode;

        UpdateModeTask(int mode) {
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            // Perform background tasks if needed
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            // Update UI on the main thread
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AppCompatDelegate.setDefaultNightMode(mode);
                }
            });        }
    }

}