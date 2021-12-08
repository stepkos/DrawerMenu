package com.example.drawermenu2;

import android.os.Bundle;
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

public class RectangleFragment extends Fragment {

    final static String TAG = "Rectangle";
    View view;
    Button calculateButton;
    EditText rangeA;
    EditText rangeB;
    EditText precision;
    TextView result;

    @Nullable
    @Override
    public View onCreateView(@NonNull  LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.rectangle_fragment, container, false);

        rangeA = view.findViewById(R.id.editTextA);
        rangeB = view.findViewById(R.id.editTextB);
        precision = view.findViewById(R.id.precision);
        calculateButton = (Button) view.findViewById(R.id.calculate);
        result = view.findViewById(R.id.result);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = Double.parseDouble(String.valueOf(rangeA.getText()));
                double b = Double.parseDouble(String.valueOf(rangeB.getText()));
                double p = Double.parseDouble(String.valueOf(precision.getText()));
                Toast.makeText(getActivity(), "RectangleFragment"+" a="+a+" b="+b+" prcision="+p, Toast.LENGTH_LONG).show();
                Log.v(TAG,"RectangleFragment"+" a="+a+" b="+b+" prcision="+p);
                double r = methodRectangle(a,b,p);
                result.setText(String.valueOf(r));
            }
        });

        return view;

    }

    double methodRectangle(double a, double b, double n){
        double h=(b-a)/n;
        double s;
        double pole=0;
        Log.v(TAG,"--------------------- dlugosc odcinka=" + h +"");
        for(int i=0;i<n;i++){
            s=a+h*i+h/2;
            pole+=Math.abs(f(s));
        }
        Log.v(TAG,"--------------------- sin(0,pi)=" + h*pole +"");
        return h*pole;
    }

    double f(double x) {
        return Math.sin(x);
    }
}
