package com.example.diettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    RadioGroup rgroup;
    RadioButton rbutton;
    TextView t;
    Button b,b1;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);

        rgroup = findViewById(R.id.gender);
        t = findViewById(R.id.fat);
        e1 = findViewById(R.id.edit1);
        e2 = findViewById(R.id.editage);
        b1 = findViewById(R.id.back3);
        b = findViewById(R.id.bodyfat);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double f = Double.parseDouble(e1.getText().toString());
                double a = Double.parseDouble(e1.getText().toString());
                int radioId = rgroup.getCheckedRadioButtonId();
                rbutton = findViewById(radioId);
                String s = (String) rbutton.getText();
                if ("male".equals(s))
                {
                    double bf = (1.20*f)+(0.23*a)-16.2;
                    t.setText(String.format("Body fat: %.2f", bf));
                    Toast.makeText(Activity4.this, String.format("%.2f", bf) + "M", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    double bf = (1.20*f)+(0.23*a)-5.4;
                    t.setText(String.format("Body fat: %.2f", bf));
                    Toast.makeText(Activity4.this, String.format("%.2f", bf) + "M", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity4.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    public void checkButton(View v)
    {
        int radioId = rgroup.getCheckedRadioButtonId();
        rbutton = findViewById(radioId);
        String s = (String) rbutton.getText();
    }
}