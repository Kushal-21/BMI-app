package com.example.bmiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtResult;
        EditText edtWeight,edtHeightFt,edtHeightIn;
        Button btnCla;
        LinearLayout liMain;

        liMain = findViewById(R.id.liMain);
        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCla = findViewById(R.id.btnCla);
        txtResult = findViewById(R.id.txtResult);
        btnCla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int wt = Integer.parseInt(edtWeight.getText().toString());
               int ft = Integer.parseInt(edtHeightFt.getText().toString());
               int in = Integer.parseInt(edtHeightIn.getText().toString());
               int totalIn = ft*12 + in;
               double totalCm = totalIn*2.53;
               double totalM = totalCm/100;
               double bmi = wt/(totalM*totalM);

               if (bmi>25){
                   txtResult.setText("You are overweight");
                   liMain.setBackgroundColor(getResources().getColor(R.color.colorO));
               }
               else if (bmi<18){
                   txtResult.setText("you are underweight");
                   liMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
               }
               else {
                  txtResult.setText("you are healthy");
                   liMain.setBackgroundColor(getResources().getColor(R.color.colorH));
               }
            }
        });


    }
}