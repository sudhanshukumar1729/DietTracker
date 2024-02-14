package com.example.diettracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity6 extends AppCompatActivity {

    Button add, delete,left,right,show;
    EditText food, calorie;
    TextView idTv, t2,t3;
    Cursor mCursor;
    View.OnClickListener updateListener = (v)->{
        clear();
    };

    View.OnClickListener deleteListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String selectionClause = NamesProvider1.COLUMN_FIRSTNAME + "=? AND " + NamesProvider1.COLUMN_LASTNAME + "=?";
            String[] selectionArgs = {t2.getText().toString().trim(),t3.getText().toString().trim()};

            int rowsDeleted = getContentResolver().delete(NamesProvider1.CONTENT_URI,selectionClause,selectionArgs);
            clear();
        }
    };

    View.OnClickListener insertListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ContentValues contentValues = new ContentValues();

            contentValues.put(NamesProvider1.COLUMN_FIRSTNAME,food.getText().toString().trim());
            contentValues.put(NamesProvider1.COLUMN_LASTNAME,calorie.getText().toString().trim());


            getContentResolver().insert(NamesProvider1.CONTENT_URI,contentValues);

            clear();
        }
    };

    View.OnClickListener queryListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCursor = getContentResolver().query(NamesProvider1.CONTENT_URI, null, null, null, null);

            if (mCursor != null) {
                try {
                    if (mCursor.moveToFirst()) {
                        setViews();
                    }
                } finally {
                }
            }
        }
    };


    View.OnClickListener previousListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mCursor != null) {
                if (mCursor.moveToPrevious()) {
                    setViews();
                } else {
                    mCursor.moveToLast();
                    setViews();
                }
            }
        }
    };

    View.OnClickListener nextListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (mCursor != null) {
                if (mCursor.moveToNext()) {
                    setViews();
                } else {
                    mCursor.moveToFirst();
                    setViews();
                }
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        add = findViewById(R.id.add);
        delete = findViewById(R.id.delete);
        left = findViewById(R.id.left);
        right = findViewById(R.id.right);
        food = findViewById(R.id.food);
        calorie = findViewById(R.id.calorie);
        idTv = findViewById(R.id.t10);
        t2 = findViewById(R.id.t20);
        t3 = findViewById(R.id.t30);
        show = findViewById(R.id.show);


        add.setOnClickListener(insertListener);
        delete.setOnClickListener(deleteListener);
        left.setOnClickListener(previousListener);
        right.setOnClickListener(nextListener);
        show.setOnClickListener(queryListener);
    }

    private void setViews(){
        idTv.setText(mCursor.getString((0)));
        String text1 = mCursor.getString(1)+" ";
        t2.setText(text1);
        t3.setText(mCursor.getString(2));
    }

    private void clear(){
        food.setText("");
        calorie.setText("");
        idTv.setText("");
        t2.setText("");
        t3.setText("");

        mCursor = null;

    }
}