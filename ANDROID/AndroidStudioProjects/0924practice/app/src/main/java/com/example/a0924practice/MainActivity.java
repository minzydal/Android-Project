package com.example.a0924practice;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText n1;
    EditText n2;
    TextView  res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 = findViewById(R.id.num1);
        n2 = findViewById(R.id.num2);
        res = findViewById(R.id.result);

    }
    public void onClick(View view){


        //EditText 입력된 값을 읽어서 변수 저장한다.
        //어떤 연산인지 구별해서 입력된 값에 대해서 해당 연산 수행, 결과 저장
        //결과를 화면 상의 TextView 표시

        //clear 버튼을 눌렀을 때
        //EditText, 결과를 표시하는 TextView 값을 초기화 - 빈 문자열 ""로 세팅
        //setText() 메소드

        float num1 = 0;
        float num2 = 0;
        float result = 0;

        if(view.getId() == R.id.clear)  {

           n1.setText("");
           n2.setText("");
           res.setText(".");

        } else {
            // 사칙연산 버튼 중 하나

            if(n1.getText().toString().equals("") ||
                n2.getText().toString().equals("")) {
                Toast.makeText(getApplicationContext(), "숫자 2개를 입력하세요",
                        Toast.LENGTH_SHORT). show();
                return;
            }

            // EditText에 입력된 값을 읽어서 num1, num2변수에 assign
            num1 = Float.parseFloat(n1.getText().toString());
            num2 = Float.parseFloat(n2.getText().toString());

            // 사칙연산 중에 해당되는 연산을 수행, 결과를 result 변수에 assign
            switch (view.getId()) {
                case R.id.add:
                    result = num1 + num2;
                    break;
                case R.id.sub:
                    result = num1 - num2;
                    break;
                case R.id.mul:
                    result = num1 * num2;
                    break;
                case R.id.div:
                    result = num1 / num2;
                    break;

            }
            //result 변수 값을 화면 상의 TextView에 설정
            res.setText(Float.toString(result));
        }

    }
}
