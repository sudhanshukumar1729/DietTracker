package com.example.diettracker;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class fragment7 extends Fragment {

    public interface OnSubmitClickListener {
        void onCreate(Bundle savedInstanceState1);

        void onSubmitClicked7(int calorie);
    }

    private OnSubmitClickListener callback;
    private EditText Quantity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            callback = (OnSubmitClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnSubmitClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment7, container, false);

        Quantity = view.findViewById(R.id.Quantity);
        Button btn = view.findViewById(R.id.btnGoBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                calculateAndSubmit7();
            }
        });

        return view;
    }

    private void calculateAndSubmit7() {
        String quantityString = Quantity.getText().toString();

        if (!quantityString.isEmpty()) {
            float quantity = Float.parseFloat(quantityString);
            int calorie = (int) (quantity * 150/100);

            callback.onSubmitClicked7(calorie);
        }

        if (getFragmentManager() != null) {
            getFragmentManager().popBackStack();
        }
    }
}