package com.example.diettracker;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity2 extends AppCompatActivity implements fragment1.OnSubmitClickListener, fragment2.OnSubmitClickListener, fragment3.OnSubmitClickListener, fragment4.OnSubmitClickListener, fragment5.OnSubmitClickListener,fragment6.OnSubmitClickListener,fragment7.OnSubmitClickListener,fragment8.OnSubmitClickListener,fragment9.OnSubmitClickListener,fragment10.OnSubmitClickListener,fragment11.OnSubmitClickListener,fragment12.OnSubmitClickListener,fragment13.OnSubmitClickListener,fragment14.OnSubmitClickListener,fragment15.OnSubmitClickListener,fragment16.OnSubmitClickListener,fragment17.OnSubmitClickListener,fragment18.OnSubmitClickListener,fragment19.OnSubmitClickListener,fragment20.OnSubmitClickListener,fragment21.OnSubmitClickListener,fragment22.OnSubmitClickListener{

    Spinner spinner;
    public int ans = 0;
    TextView calorie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        calorie = findViewById(R.id.calorie);
        spinner = findViewById(R.id.spinner);
        List<String> list = new ArrayList<>();
        list.add(0, "DIET");
        list.add(1, "Apple");
        list.add(2, "Milk");
        list.add(3, "SoyaBean");
        list.add(4, "Rice");
        list.add(5, "Egg");
        list.add(6, "Chicken");
        list.add(7, "Fish");
        list.add(8, "Peanuts");
        list.add(9, "Banana");
        list.add(10, "Potato");
        list.add(11, "dal");
        list.add(12, "Rajma");
        list.add(13, "Cabbage");
        list.add(14, "BitterGourd");
        list.add(15, "SweetPotato");
        list.add(16, "Avocado");
        list.add(17, "CustardApple");
        list.add(18, "Paneer");
        list.add(19, "Khoa");
        list.add(20, "Goat");
        list.add(21, "CoconutWater");



        ArrayAdapter<String> dataAdapter;
        dataAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, list);
        spinner.setAdapter(dataAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long l) {
                if (parent.getItemAtPosition(i).equals("Choose category")) {

                } else {
                    String item = parent.getItemAtPosition(i).toString();
                    Toast.makeText(parent.getContext(), "selected" + item, Toast.LENGTH_LONG).show();

                    if (parent.getItemAtPosition(i).equals("Apple")) {
                        com.example.diettracker.fragment1 first_fragment = new com.example.diettracker.fragment1();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, first_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Milk")) {
                        com.example.diettracker.fragment2 second_fragment = new com.example.diettracker.fragment2();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, second_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("SoyaBean")) {
                        com.example.diettracker.fragment3 third_fragment = new com.example.diettracker.fragment3();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, third_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Rice")) {
                        com.example.diettracker.fragment4 fourth_fragment = new com.example.diettracker.fragment4();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, fourth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Wheat")) {
                        com.example.diettracker.fragment5 fifth_fragment = new com.example.diettracker.fragment5();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, fifth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Egg")) {
                        com.example.diettracker.fragment6 sixth_fragment = new com.example.diettracker.fragment6();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, sixth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Chicken")) {
                        com.example.diettracker.fragment7 seventh_fragment = new com.example.diettracker.fragment7();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, seventh_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Fish")) {
                        com.example.diettracker.fragment8 eight_fragment = new com.example.diettracker.fragment8();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, eight_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Peanuts")) {
                        com.example.diettracker.fragment9 ninth_fragment = new com.example.diettracker.fragment9();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, ninth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Banana")) {
                        com.example.diettracker.fragment10 tenth_fragment = new com.example.diettracker.fragment10();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, tenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Potato")) {
                        com.example.diettracker.fragment11 eleventh_fragment = new com.example.diettracker.fragment11();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, eleventh_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("dal")) {
                        com.example.diettracker.fragment12 twelth_fragment = new com.example.diettracker.fragment12();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, twelth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Rajma")) {
                        com.example.diettracker.fragment13 thirteenth_fragment = new com.example.diettracker.fragment13();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, thirteenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Cabbage")) {
                        com.example.diettracker.fragment14 fourteenth_fragment = new com.example.diettracker.fragment14();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, fourteenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("BitterGourd")) {
                        com.example.diettracker.fragment15 fifteenth_fragment = new com.example.diettracker.fragment15();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, fifteenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("SweetPotato")) {
                        com.example.diettracker.fragment16 sixteenth_fragment = new com.example.diettracker.fragment16();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, sixteenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Avocado")) {
                        com.example.diettracker.fragment17 seventeenth_fragment = new com.example.diettracker.fragment17();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, seventeenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("CustardApple")) {
                        com.example.diettracker.fragment18 eighteenth_fragment = new com.example.diettracker.fragment18();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, eighteenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Paneer")) {
                        com.example.diettracker.fragment19 nineteenth_fragment = new com.example.diettracker.fragment19();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, nineteenth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("Khoa")) {
                        com.example.diettracker.fragment20 twentyth_fragment = new com.example.diettracker.fragment20();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, twentyth_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }if (parent.getItemAtPosition(i).equals("Goat")) {
                        com.example.diettracker.fragment21 twentyfirst_fragment = new com.example.diettracker.fragment21();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, twentyfirst_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                    if (parent.getItemAtPosition(i).equals("CoconutWater")) {
                        com.example.diettracker.fragment22 twentysecond_fragment = new com.example.diettracker.fragment22();
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainactivity, twentysecond_fragment);
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }



                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    public void onSubmitClicked1(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked2(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked3(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked4(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked5(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked6(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked7(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked8(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked9(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked10(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }

    public void onSubmitClicked11(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked12(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked13(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked14(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked15(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked16(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked17(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked18(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked19(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }
    public void onSubmitClicked20(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }public void onSubmitClicked21(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }public void onSubmitClicked22(int calorieValue) {
        ans = ans+calorieValue;
        calorie.setText("KCalorie: " + ans);
    }





}