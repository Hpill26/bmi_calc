package com.example.bmicalc;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    double Bmi = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcBMI = (Button) findViewById(R.id.calcBMI);
        Button getAdvice = (Button) findViewById(R.id.getAdvice);

        final RadioButton american = (RadioButton) findViewById(R.id.american);
        final RadioButton met = (RadioButton) findViewById(R.id.metric);

        final TextView bmiResult = (TextView) findViewById(R.id.bmiResult);
        boolean lbsClicked = false;
        boolean metclicked = false;

        //connect calculate button to calculate bmi
        //connect get advice button to getAdvice
        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               double weight = 0;
               double height = 0;

                EditText weightText = findViewById(R.id.editText);
                EditText heightText = findViewById(R.id.editText2);

                String temp = weightText.getText().toString();
                String temp2 = heightText.getText().toString();
               // System.out.println("temp" + temp);
                if(temp.isEmpty() || temp2.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Button Clicked before entering Data!", Toast.LENGTH_SHORT).show();
                   // System.out.println("Temp is empty");
                }
                else
                {
                    weight = Double.parseDouble(temp);
                    height = Double.parseDouble(temp2);
                }
                double numerator = 0;
                double denominator = height * height;
                if(lbs.isChecked())
                {
                    numerator = weight * 703;
                    Bmi = numerator/denominator;
                    // System.out.printf("BMI: %.2f",Bmi);

                    String setBmi = String.format("BMI: %.2f", Bmi);
                    System.out.println(setBmi);
                    bmiResult.setText(setBmi);
                }
                else if(met.isChecked())
                {
                    numerator = weight;
                    Bmi = numerator/denominator;
                    // System.out.printf("BMI: %.2f",Bmi);

                    String setBmi = String.format("BMI: %.2f", Bmi);
                    System.out.println(setBmi);
                    bmiResult.setText(setBmi);
                }
                else if(!(lbs.isChecked())  && !(met.isChecked()))
                {
                    Toast.makeText(getApplicationContext(),"Select units before calculating!!!", Toast.LENGTH_SHORT).show();
                }
                //calculating the Bmi here

//                Bmi = numerator/denominator;
//               // System.out.printf("BMI: %.2f",Bmi);
//
//                String setBmi = String.format("BMI: %.2f", Bmi);
//                System.out.println(setBmi);
//                bmiResult.setText(setBmi);
            }
        });


        final RadioButton american = (RadioButton) findViewById(R.id.american);
        final RadioButton met = (RadioButton) findViewById(R.id.metric);

        final TextView bmiResult = (TextView) findViewById(R.id.bmiResult);
        boolean lbsClicked = false;
        boolean metclicked = false;

        american.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightText.setHint("Enter weight in Pounds");
                heightText.setHint("Enter height in Inches");
            }
        });

        met.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                weightText.setHint("Enter weight in Kilograms");
                heightText.setHint("Enter height in Meters");
            }
        });
    }
}