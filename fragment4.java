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


public class fragment4 extends Fragment {

    public interface OnSubmitClickListener {
        void onCreate(Bundle savedInstanceState1);

        void onSubmitClicked4(int calorie);
    }

    private fragment4.OnSubmitClickListener callback;
    private EditText RiceQuantity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            callback = (fragment4.OnSubmitClickListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnSubmitClickListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment4, container, false);

        RiceQuantity = view.findViewById(R.id.RiceQuantity);
        Button btn = view.findViewById(R.id.btnGoBack);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                calculateAndSubmit4();
            }
        });

        return view;
    }

    private void calculateAndSubmit4() {
        String quantityString = RiceQuantity.getText().toString();

        if (!quantityString.isEmpty()) {
            float quantity = Float.parseFloat(quantityString);
            int calorie = (int) (quantity * 353.7/100);

            callback.onSubmitClicked4(calorie);
        }

        if (getFragmentManager() != null) {
            getFragmentManager().popBackStack();
        }
    }
}