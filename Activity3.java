package com.example.diettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        b1 = findViewById(R.id.actvity2);
        b2 = findViewById(R.id.goback);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.edit2);
        e3 = findViewById(R.id.edit3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double p1 = Double.parseDouble(e1.getText().toString());
                double p2 = Double.parseDouble(e2.getText().toString());

                double k1 = (p1/(p2*p2));
                e3.setText(String.format("%.2f", k1));
                Toast.makeText(Activity3.this, String.format("%.2f", k1) + "M", Toast.LENGTH_SHORT).show();


                Intent broadcastIntent = new Intent(Activity3.this, BMIReceiver.class);
                broadcastIntent.setAction("com.example.diettracker.BMI_NOTIFICATION");
                broadcastIntent.putExtra("BMI", k1);
                sendBroadcast(broadcastIntent);


            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity3.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}