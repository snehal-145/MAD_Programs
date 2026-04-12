package com.example.calculator;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.t1);
        num2 = findViewById(R.id.t2);
        btnAdd = findViewById(R.id.b1);
        btnSub = findViewById(R.id.b2);
        btnMul = findViewById(R.id.b3);
        btnDiv = findViewById(R.id.b4);
        txtResult = findViewById(R.id.t3);

        // Add
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("+");
            }
        });

        // Subtract
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("-");
            }
        });

        // Multiply
        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("*");
            }
        });

        // Divide
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate("/");
            }
        });
    }

    private void calculate(String operator) {
        String n1 = num1.getText().toString();
        String n2 = num2.getText().toString();

        if (n1.isEmpty() || n2.isEmpty()) {
            txtResult.setText("Result: Enter both numbers");
            return;
        }

        int number1 = Integer.parseInt(n1);
        int number2 = Integer.parseInt(n2);
        int result = 0;

        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                if (number2 == 0) {
                    txtResult.setText("Result: Cannot divide by zero");
                    return;
                }
                result = number1 / number2; // integer division only
                break;
        }

        txtResult.setText("Result: " + result);
    }
}