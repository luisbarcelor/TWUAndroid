package com.twu_android.tools;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.twu_android.R;
import com.twu_android.workers.Worker;

public class CalculatorActivity extends AppCompatActivity {
    private Button showOP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Button button = findViewById(R.id.calculator_button);
        button.setOnClickListener((view) -> {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

            EditText num1 = findViewById(R.id.num1);
            EditText num2 = findViewById(R.id.num2);
            TextView result = findViewById(R.id.result);
            RadioButton sumarButton = findViewById(R.id.sumarButton);
            RadioButton restarButton = findViewById(R.id.restarButton);
            RadioButton multiplicarButton = findViewById(R.id.multiplicarButton);
            RadioButton dividirButton = findViewById(R.id.dividirButton);

            try {
                double num1Value = Double.parseDouble(num1.getText().toString());
                double num2Value = Double.parseDouble(num2.getText().toString());
                double resultValue;

                if (sumarButton.isChecked()) {
                    resultValue = Worker.sumar(num1Value, num2Value);
                    result.setText(String.valueOf(resultValue));
                } else if (restarButton.isChecked()) {
                    resultValue = Worker.restar(num1Value, num2Value);
                    result.setText(String.valueOf(resultValue));
                } else if (multiplicarButton.isChecked()) {
                    resultValue = Worker.multiplicar(num1Value, num2Value);
                    result.setText(String.valueOf(resultValue));
                } else if (dividirButton.isChecked()) {
                    resultValue = Worker.dividir(num1Value, num2Value);
                    result.setText(String.valueOf(resultValue));
                } else {
                    result.setText(R.string.calculator_title);
                }
            } catch (Exception e) {
                result.setText(R.string.calculator_error);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
    }
}