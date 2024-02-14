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

public class fragment1 extends Fragment {

    public interface OnSubmitClickListener {
        void onCreate(Bundle savedInstanceState1);

        void onSubmitClicked1(int calorie);
    }

    private OnSubmitClickListener callback;
    private EditText AppleQuantity;

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
        View view = inflater.inflate(R.layout.fragment_fragment1, container, false);

        AppleQuantity = view.findViewById(R.id.AppleQuantity);
        Button btn = view.findViewById(R.id.btnGoBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                calculateAndSubmit1();
            }
        });

        return view;
    }

    private void calculateAndSubmit1() {
        String quantityString = AppleQuantity.getText().toString();

        if (!quantityString.isEmpty()) {
            float quantity = Float.parseFloat(quantityString);
            int calorie = (int) (quantity * 95);

            callback.onSubmitClicked1(calorie);
        }

        if (getFragmentManager() != null) {
            getFragmentManager().popBackStack();
        }
    }
}
