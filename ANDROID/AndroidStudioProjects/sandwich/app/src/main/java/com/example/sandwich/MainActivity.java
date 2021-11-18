package com.example.sandwich;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView total;
    int sand;
    int top;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.price);
        sand = 0;
        top = 0;
        result = 0;
    }

    public void onClick(View view)  {
        switch (view.getId()) {
            case R.id.ham:
                sand = 5000;
                break;
            case R.id.tuna:
                sand = 4000;
                break;
            case R.id.chicken:
                sand = 4500;
                break;
            case R.id.bacon:
                if(((CheckBox)view).isChecked())
                    top += 1000;         //multiple choice
                else
                    top -= 1000;
                break;
            case R.id.cheese:
                if(((CheckBox)view).isChecked())
                    top += 500;         //multiple choice
                else
                    top -= 500;
                break;
            case R.id.avocado:
                if(((CheckBox)view).isChecked())
                    top += 1500;         //multiple choice
                else
                    top -= 1500;
                break;
        }

        result = sand + top;
        total.setText(Integer.toString(result));
    }
}
