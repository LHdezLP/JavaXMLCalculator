package com.example.calculatorjavaxml;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputLayout inputLayout1, inputLayout2;
    private EditText editTextNumber1, editTextNumber2, editTextResult;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputLayout1 = findViewById(R.id.inputLayoutNumber1);
        inputLayout2 = findViewById(R.id.inputLayoutNumber2);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextResult = findViewById(R.id.editTextResult);
        calculateButton = findViewById(R.id.buttonCalculate);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateSum();
            }
        });
    }

    private void calculateSum() {
        String input1 = editTextNumber1.getText().toString().trim();
        String input2 = editTextNumber2.getText().toString().trim();


        inputLayout1.setError(null);
        inputLayout2.setError(null);

        if (input1.isEmpty() || input2.isEmpty()) {
            if (input1.isEmpty()) {
                inputLayout1.setError("Introduce el primer sumando");
            }
            if (input2.isEmpty()) {
                inputLayout2.setError("Introduce el segundo sumando");
            }
            return;
        }

        try {
            double number1 = Double.parseDouble(input1);
            double number2 = Double.parseDouble(input2);
            double sum = number1 + number2;
            editTextResult.setText(String.valueOf(sum));
        } catch (NumberFormatException e) {
            inputLayout1.setError("Introduce un número válido");
            inputLayout2.setError("Introduce un número válido");
        }
    }
}