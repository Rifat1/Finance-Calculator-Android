package com.example.finance_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.finance_calculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText editTextStartingValue, editTextEndingValue, editTextNumberOfYears;
    private Button buttonCalculate;
    private TextView textViewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextStartingValue = findViewById(R.id.editTextStartingValue);
        editTextEndingValue = findViewById(R.id.editTextEndingValue);
        editTextNumberOfYears = findViewById(R.id.editTextNumberOfYears);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Get user inputs
                double startingValue = Double.parseDouble(editTextStartingValue.getText().toString());
                double endingValue = Double.parseDouble(editTextEndingValue.getText().toString());
                int numberOfYears = Integer.parseInt(editTextNumberOfYears.getText().toString());

                // Calculate the annual compound growth rate (CAGR)
                double annualCompoundGrowthRate = calculateAnnualCompoundGrowthRate(startingValue, endingValue, numberOfYears);

                // Display the result
                textViewResult.setText("Annual Compound Growth Rate: " + String.format("%.2f%%", annualCompoundGrowthRate));
            }
        });
    }
    public double calculateAnnualCompoundGrowthRate(double startingValue, double endingValue, int numberOfYears) {
        // Calculate the annual compound growth rate (CAGR)
        double rate = Math.pow((endingValue / startingValue), 1.0 / numberOfYears) - 1;
        return rate * 100; // Convert to percentage
    }

}