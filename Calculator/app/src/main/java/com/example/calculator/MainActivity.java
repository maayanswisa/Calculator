package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    double firstNum;
    String operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button num0 = findViewById(R.id.btn0);
        Button num1 = findViewById(R.id.btn1);
        Button num2 = findViewById(R.id.btn2);
        Button num3 = findViewById(R.id.btn3);
        Button num4 = findViewById(R.id.btn4);
        Button num5 = findViewById(R.id.btn5);
        Button num6 = findViewById(R.id.btn6);
        Button num7 = findViewById(R.id.btn7);
        Button num8 = findViewById(R.id.btn8);
        Button num9 = findViewById(R.id.btn9);

        Button on = findViewById(R.id.btnOn);
        Button off = findViewById(R.id.btnOff);
        Button ac = findViewById(R.id.btnAC);
        Button del = findViewById(R.id.btnDelete);
        Button div = findViewById(R.id.btnDivide);
        Button times = findViewById(R.id.btnMult);
        Button min = findViewById(R.id.btnMinus);
        Button equal = findViewById(R.id.btnEquels);
        Button plus = findViewById(R.id.btnPlus);
        Button point = findViewById(R.id.btnPoint);

        TextView screen = findViewById(R.id.screen);

        ac.setOnClickListener(view->{
            firstNum=0;
            screen.setText("0");
        });

        off.setOnClickListener(view -> screen.setVisibility(View.GONE));

        on.setOnClickListener(view -> {
            screen.setVisibility(View.VISIBLE);
            screen.setText("0");
        });

        ArrayList<Button> nums = new ArrayList<>();
        nums.add(num0);
        nums.add(num1);
        nums.add(num2);
        nums.add(num3);
        nums.add(num4);
        nums.add(num5);
        nums.add(num6);
        nums.add(num7);
        nums.add(num8);
        nums.add(num9);

        for (Button b : nums) {
            b.setOnClickListener(view -> {
                if (!screen.getText().toString().equals("0")) {
                    screen.setText(screen.getText().toString() + b.getText().toString());
                } else {
                    screen.setText(b.getText().toString());
                }
            });
        }


        ArrayList<Button> opers = new ArrayList<>();
        opers.add(div);
        opers.add(times);
        opers.add(min);
        opers.add(plus);
        for (Button b : opers) {
            b.setOnClickListener(view -> {
                firstNum = Double.parseDouble(screen.getText().toString());
                operation = b.getText().toString();
                screen.setText("0");
            });
        }

        del.setOnClickListener(view -> {
            String num = screen.getText().toString();
            if (num.length() > 1) {
                screen.setText(num.substring(0, num.length() - 1));
            } else if (num.length() == 1 && !num.equals("0")) {
                screen.setText("0");
            }
        });

        point.setOnClickListener(view -> {
            if(!screen.getText().toString().contains(".")){
                screen.setText(screen.getText().toString() + ".");
            }
        });

        equal.setOnClickListener(view->{
            double secondNum = Double.parseDouble(screen.getText().toString());
            double result;
            switch (operation) {
                case "/":
                    result = firstNum / secondNum;
                    break;
                case "*":
                    result = firstNum * secondNum;
                    break;
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
                default:
                    result = firstNum + secondNum;
            }
            screen.setText(String.valueOf(result));
            firstNum=result;
        });


    }

}
