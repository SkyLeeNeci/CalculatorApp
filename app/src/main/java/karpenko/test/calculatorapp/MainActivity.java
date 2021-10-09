package karpenko.test.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] numbers = new int[]{
                R.id.zero,R.id.one,R.id.two,
                R.id.three,R.id.four,R.id.fife,
                R.id.six,R.id.seven,R.id.eight,
                R.id.nine
        };
        int[] actionBtns = new int[]{
                R.id.multiplication,
                R.id.div,
                R.id.plus,
                R.id.minus,
                R.id.equals
        };

        textView = findViewById(R.id.text);

        calculator = new Calculator();

        View.OnClickListener numberBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.numPressed(v.getId());
                textView.setText(calculator.getText());
            }

        };

        View.OnClickListener actionBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculator.onActionPressed(v.getId());
                textView.setText(calculator.getText());
            }
        };

        for (int i = 0; i < numbers.length; i++){
            findViewById(numbers[i]).setOnClickListener(numberBtnClickListener);
        }

        for (int i = 0; i < actionBtns.length; i++){
            findViewById(actionBtns[i]).setOnClickListener(actionBtnClickListener);
        }

    }
}