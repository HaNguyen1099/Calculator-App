package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView inputText, outputText;
    String input, output, newOutput;
    MaterialButton btnC, btnAC;
    MaterialButton btnMu, btnDu, btnDiv, btnMulti, btnSub, btnPlus, btnEqual, btnDot;
    MaterialButton btnZero, btnOne, btnTwo, btnThree, btnFour, btnFive, btnSix, btnSeven, btnEight, btnNine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        outputText = findViewById(R.id.op_text);
        inputText = findViewById(R.id.ip_text);

        assignId(btnC, R.id.btn_c);
        assignId(btnAC, R.id.btn_ac);
        assignId(btnMu, R.id.btn_mu);
        assignId(btnDu, R.id.btn_du);
        assignId(btnDiv, R.id.btn_div);
        assignId(btnMulti, R.id.btn_multi);
        assignId(btnSub, R.id.btn_sub);
        assignId(btnPlus, R.id.btn_plus);
        assignId(btnEqual, R.id.btn_equal);
        assignId(btnDot, R.id.btn_dot);
        assignId(btnZero, R.id.btn_zero);
        assignId(btnOne, R.id.btn_one);
        assignId(btnTwo, R.id.btn_two);
        assignId(btnThree, R.id.btn_three);
        assignId(btnFour, R.id.btn_four);
        assignId(btnFive, R.id.btn_five);
        assignId(btnSix, R.id.btn_six);
        assignId(btnSeven, R.id.btn_seven);
        assignId(btnEight, R.id.btn_eight);
        assignId(btnNine, R.id.btn_nine);
    }

    void assignId(MaterialButton btn, int id) {
        btn = findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String data = button.getText().toString();
        switch (data) {
            case "C":
                input = input.substring(0, input.length() - 1);
                break;
            case "AC":
                input = null;
                output = null;
                newOutput = null;
                outputText.setText("");
                break;
            case "^":
                solve();
                input += "^";
                break;
            case "%":
                solve();
                input += "%";
                break;
            case "*":
                solve();
                input += "*";
                break;
            case "=":
                solve();
                break;
            default:
                if (input == null) {
                    input = "";
                }
                if (data.equals("+") || data.equals("-") || data.equals("/")) {
                    solve();
                }
                input += data;
        }
        inputText.setText(input);
    }

    private void solve() {
        if (input.split("\\+").length == 2) {
            String numbers[] = input.split("\\+");
            try {
                double d = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\-").length == 2) {
            String numbers[] = input.split("\\-");
            try {
                double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\*").length == 2) {
            String numbers[] = input.split("\\*");
            try {
                double d = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\/").length == 2) {
            String numbers[] = input.split("\\/");
            try {
                double d = Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\^").length == 2) {
            String numbers[] = input.split("\\^");
            try {
                double d = Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }

        if (input.split("\\%").length == 2) {
            String numbers[] = input.split("\\%");
            try {
                double d = Double.parseDouble(numbers[0]) % Double.parseDouble(numbers[1]);
                output = Double.toString(d);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = d + "";
            } catch (Exception e) {
                outputText.setError(e.getMessage().toString());
            }
        }
    }

    private String cutDecimal(String number) {
        String n[] = number.split("\\.");
        if (n.length > 1) {
            if (n[1].equals("0")) {
                number = n[0];
            }
        }
        return number;
    }
}