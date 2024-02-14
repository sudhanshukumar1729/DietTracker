package com.example.diettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class animationscreen extends AppCompatActivity {

    TextView t1;
    LottieAnimationView l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animationscreen);

        t1 = findViewById(R.id.appname);
        l1 = findViewById(R.id.animation1);

        l1.animate().alpha(0).setDuration(2700).setStartDelay(1000);
        t1.animate().translationY(-700).setDuration(2700).setStartDelay(2800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        },5000);
    }
}