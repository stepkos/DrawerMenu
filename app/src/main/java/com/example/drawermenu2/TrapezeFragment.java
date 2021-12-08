package com.example.drawermenu2;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TrapezeFragment extends Fragment {

    final static String TAG = "Trapeze";
    View view;
    Button calculateButton;
    EditText rangeA;
    EditText rangeB;
    EditText precision;
    TextView result;

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.trapeze_fragment, container, false);

        rangeA = view.findViewById(R.id.editTextA);
        rangeB = view.findViewById(R.id.editTextB);
        precision = view.findViewById(R.id.precision);
        calculateButton = (Button) view.findViewById(R.id.calculate);
        result = view.findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(rangeA.getText()) || !isNumeric(rangeA.getText().toString())) {
                    rangeA.setError("Field is required and filed must be numeric!");
                }
                else if(TextUtils.isEmpty(rangeB.getText()) || !isNumeric(rangeB.getText().toString())) {
                    rangeB.setError("Field is required and filed must be numeric!");
                }
                else if(TextUtils.isEmpty(precision.getText()) || !isNumeric(precision.getText().toString())) {
                    precision.setError("Field is required and filed must be numeric!");
                }
                else {
                    double a = Double.parseDouble(String.valueOf(rangeA.getText()));
                    double b = Double.parseDouble(String.valueOf(rangeB.getText()));
                    double p = Double.parseDouble(String.valueOf(precision.getText()));
                    Toast.makeText(getActivity(), "TrapezeFragment"+" a="+a+" b="+b+" prcision="+p, Toast.LENGTH_LONG).show();
                    Log.v(TAG,"TrapezeFragment"+" a="+a+" b="+b+" prcision="+p);
                    double r = integrate(a,b,p);
                    result.setText(String.valueOf(r));
                }
            }
        });

        return view;

    }

    public static double f(double x) {
        return Math.exp(- x * x / 2) / Math.sqrt(2 * Math.PI);
    }

    public static double integrate(double a, double b, double N) {
        double h = (b - a) / (N - 1);

        // 1/3 terms
        double sum = 1.0 / 3.0 * (f(a) + f(b));

        // 4/3 terms
        for (int i = 1; i < N - 1; i += 2) {
            double x = a + h * i;
            sum += 4.0 / 3.0 * f(x);
        }

        // 2/3 terms
        for (int i = 2; i < N - 1; i += 2) {
            double x = a + h * i;
            sum += 2.0 / 3.0 * f(x);
        }

        return sum * h;
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}
