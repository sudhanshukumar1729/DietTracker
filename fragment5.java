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


public class fragment5 extends Fragment {

    public interface OnSubmitClickListener {
        void onCreate(Bundle savedInstanceState1);

        void onSubmitClicked5(int calorie);
    }

    private OnSubmitClickListener callback;
    private EditText WheatQuantity;

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
        View view = inflater.inflate(R.layout.fragment_fragment5, container, false);

        WheatQuantity = view.findViewById(R.id.WheatQuantity);
        Button btn = view.findViewById(R.id.btnGoBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                calculateAndSubmit5();
            }
        });

        return view;
    }

    private void calculateAndSubmit5() {
        String quantityString = WheatQuantity.getText().toString();

        if (!quantityString.isEmpty()) {
            float quantity = Float.parseFloat(quantityString);
            int calorie = (int) (quantity * 320/100);

            callback.onSubmitClicked5(calorie);
        }

        if (getFragmentManager() != null) {
            getFragmentManager().popBackStack();
        }
    }
}