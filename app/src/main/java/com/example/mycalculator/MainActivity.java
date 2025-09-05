package com.example.mycalculator;

import static java.lang.Double.parseDouble;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.mycalculator.R;

public class MainActivity extends AppCompatActivity {
    private EditText number1EditText, number2EditText;
    private TextView resultTextView;
    private Button addButton, subtractButton, multiplyButton, divideButton;

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
        setupUIComponents();
        setupButtonListeners();

    }

    private void setupUIComponents(){
        number1EditText = findViewById(R.id.number1_edit_text);
        number2EditText = findViewById(R.id.number2_edit_text);
        resultTextView = findViewById(R.id.result_text_view);
        addButton = findViewById(R.id.add_button);
        multiplyButton = findViewById(R.id.multiply_button);
        subtractButton = findViewById(R.id.subtract_button);
        divideButton = findViewById(R.id.divide_button);
    }
    private void setupButtonListeners(){
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate('+');
            }

        });

        subtractButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate('-');
            }

        });
        multiplyButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate('*');
            }

        });
        divideButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate('/');
            }

        });


    }
    private void calculate(char operation){

        double num1 = parseDouble(number1EditText.getText().toString());
        double num2 = parseDouble(number2EditText.getText().toString());
        double result = 0;

        switch(operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;

            case '*':
                result = num1*num2;
                break;

            case '/':
                if(num2 != 0) {

                    result = num1/num2;
                    break;
                } else {

                    resultTextView.setText("Error: Cannot divide by zero!");
                    return;

                }
        }

        resultTextView.setText("The result is: " + result);
        setupButtonListeners();
    }




}
