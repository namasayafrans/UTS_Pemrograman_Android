package com.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView showCount;

    private int count = 1;

    private long fibNMinus1 = 1;

    private long fibNMinus2 = 0;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showCount = findViewById(R.id.show_count);
    }

    public void showToast(View view) {
        Toast.makeText(this, "Bilangan Fibonanci ",
                Toast.LENGTH_SHORT).show();
    }

    public void countUp(View view) {
        if (count == 0){
            showCount.setText("0");
        } else if (count == 1) {
            showCount.setText("1");
        } else {
            long fibCurrent = fibNMinus1 + fibNMinus2;
            fibNMinus2 = fibNMinus1;
            fibNMinus1 = fibCurrent;
            showCount.setText(String.valueOf(fibCurrent));
        }
        count++;
    }


    public void back1(View view) {
        count = 1;
        fibNMinus1 = 1;
        fibNMinus2 = 0;

        showCount.setText(getString(R.string.count_initial_value));
    }
}