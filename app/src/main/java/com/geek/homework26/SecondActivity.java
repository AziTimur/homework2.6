package com.geek.homework26;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView panel;
    private String operation = "";
    private boolean isOperation = false;
    private String intermediateNumber = "";
    private double firstNumber, secondNumber, result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);

        panel = findViewById(R.id.calc_title_tv);


    }



    public void onClick_buttonTyping(View view) {
        if (isOperation) {
            panel.setText("");
            result = 0;
            operation = null;
            firstNumber = 0;
            secondNumber = 0;
            intermediateNumber = "";
            isOperation = false;
        }


        switch (view.getId()) {


            case R.id.zero_btn:
                if (!intermediateNumber.startsWith("0") || intermediateNumber.contains(".")) {
                    intermediateNumber += "0";
                }
                break;

            case R.id.one_btn:
                intermediateNumber += "1";
                break;

            case R.id.two_btn:
                intermediateNumber += "2";
                break;

            case R.id.three_btn:
                intermediateNumber += "3";
                break;

            case R.id.four_btn:
                intermediateNumber += "4";
                break;

            case R.id.five_btn:
                intermediateNumber += "5";
                break;

            case R.id.six_btn:
                intermediateNumber += "6";
                break;

            case R.id.seven_btn:
                intermediateNumber += "7";
                break;

            case R.id.eight_btn:
                intermediateNumber += "8";
                break;

            case R.id.nine_btn:
                intermediateNumber += "9";
                break;

            case R.id.dot_btn:
                if (!intermediateNumber.contains(".")) {
                    intermediateNumber += ".";
                }
                break;

            case R.id.clear_btn:
                intermediateNumber = "";
                break;
        }
        panel.setText(intermediateNumber);
    }

    public void socr(String znak) {
        firstNumber = Double.parseDouble(intermediateNumber);
        operation = znak;
        intermediateNumber = "";
        panel.setText(znak);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    public void Logic_onClick_buttonTyping(View view) {
        try {

            switch (view.getId()) {
                case R.id.plus_btn:
                    socr("+");
                    break;

                case R.id.minus_btn:
                    socr("-");
                    break;
                case R.id.umnoj_btn:
                    socr("*");
                    break;

                case R.id.delenie_btn:

                    socr("/");
                    break;
                case R.id.equal_btn:
                    secondNumber = Double.parseDouble(intermediateNumber);
                    switch (operation) {
                        case "+":
                            result = firstNumber + secondNumber;
                            break;
                        case "-":
                            result = firstNumber - secondNumber;
                            break;
                        case "*":
                            result = firstNumber * secondNumber;
                            break;

                        case "/":
                            if (firstNumber == 0 || secondNumber == 0) {
                                intermediateNumber = "Ошибка";
                                panel.setText(intermediateNumber);
                            } else {
                                result = firstNumber / secondNumber;
                            }
                            break;
                    }

                    if (!intermediateNumber.equals("Ошибка")) {
                        panel.setText(result + "");
                    }
                    isOperation = true;
                    break;
            }
        } catch (Exception ignored) {
        }
    }
}