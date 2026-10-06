package com.example.fourbasicopt;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private final FourBasicOpt fourOpt = new FourBasicOpt();

    private EditText editX;
    private EditText editY;
    private TextView textExpression;
    private TextView textResult;

    private interface Operation {
        double apply(double x, double y);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editX = findViewById(R.id.editX);
        editY = findViewById(R.id.editY);
        textExpression = findViewById(R.id.textExpression);
        textResult = findViewById(R.id.textResult);

        findViewById(R.id.btnAdd).setOnClickListener(v -> calculate("+", fourOpt::add));
        findViewById(R.id.btnSubtract).setOnClickListener(v -> calculate("−", fourOpt::subtract));
        findViewById(R.id.btnMultiply).setOnClickListener(v -> calculate("×", fourOpt::multiply));
        findViewById(R.id.btnDivide).setOnClickListener(v -> calculate("÷", fourOpt::divide));
    }

    private void calculate(String symbol, Operation operation) {
        hideKeyboard();
        Double x = parse(editX);
        Double y = parse(editY);
        if (x == null || y == null) {
            textExpression.setText("");
            textResult.setText("숫자를 입력하세요");
            return;
        }
        double result = operation.apply(x, y);
        textExpression.setText(format(x) + " " + symbol + " " + format(y) + " =");
        textResult.setText(format(result));
    }

    private void hideKeyboard() {
        View focused = getCurrentFocus();
        if (focused != null) {
            getSystemService(InputMethodManager.class)
                    .hideSoftInputFromWindow(focused.getWindowToken(), 0);
            focused.clearFocus();
        }
    }

    private static Double parse(EditText edit) {
        try {
            return Double.parseDouble(edit.getText().toString().trim());
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static String format(double value) {
        if (value == Math.rint(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
