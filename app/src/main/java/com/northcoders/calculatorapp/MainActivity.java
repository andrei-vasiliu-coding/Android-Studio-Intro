package com.northcoders.calculatorapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView headline;
    EditText firstNumber;
    EditText secondNumber;
    Button button;
    Button clearButton;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.i(this.getLocalClassName(), "It's me, Mario!");

        headline = findViewById(R.id.textView);
        firstNumber = findViewById(R.id.editTextNumber);
        secondNumber = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.button);
        clearButton = findViewById(R.id.clearbutton);
        result = findViewById(R.id.result);

        button.setOnClickListener(click -> tapButton());
        clearButton.setOnClickListener(click -> clearFields());

    }

    public void tapButton() {
        //Although we don't have to use a try-catch since they can only accept numbers.
        try {
            String firstNumString = firstNumber.getText().toString();
            String secondNumString = secondNumber.getText().toString();

            if (!firstNumString.isEmpty() && !secondNumString.isEmpty()) {
                int firstNum = Integer.parseInt(firstNumString);
                int secondNum = Integer.parseInt(secondNumString);
                int sum = firstNum + secondNum;
                result.setText(String.valueOf(sum));
            } else {
                result.setText("Please enter both numbers.");
            }
        } catch (NumberFormatException e) {
            result.setText("Invalid input.");
        }
    }

    public void clearFields() {
        firstNumber.setText("");
        secondNumber.setText("");
        result.setText("");
    }
}