package com.example.airplane;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView total; //총액
    TextView people; //티켓을 구매할 사람 수
    int ticket; //퍼스트, 비즈니스, 이코노미 클래스 티켓
    int meal;   //한식, 양식, 중식 기내식
    int seat;   //복도, 창가 자리
    int num;    //사람 수 +,- 선택할 변수
    int result; //결과값
    ImageView img;  //이미지뷰 변수 생성


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        total = findViewById(R.id.price);   //xml에서 price 객체를 불러온다
        people = findViewById(R.id.nop);    //nop(;number of people)객체를 불러온다
        ticket = 0;
        meal = 0;
        seat = 0;
        result = 0;
        //변수 default value initialization
        num=1;  //사람 수 default value = 1
        img = findViewById(R.id.imageView); //xml에서 imageView 객체를 불러온다

    }

        public void onClick(View view)  {
        switch (view.getId()) {

              //퍼스트, 비즈니스, 이코노미석 선택
            case R.id.first:
                ticket = 3000000;
                img.setImageResource(R.drawable.first); //first객체 선택 시 drawble에 있는 first이미지를 imageView에 띄운다
                break;
            case R.id.business:
                ticket = 2000000;
                img.setImageResource(R.drawable.business); //business객체 선택 시 drawble에 있는 business이미지를 imageView에 띄운다
                break;
            case R.id.economy:
                ticket = 1000000;
                img.setImageResource(R.drawable.economy); //economy객체 선택 시 drawble에 있는 economy이미지를 imageView에 띄운다
                break;

                //창가, 통로 선택
            case R.id.aisle:
                seat = 20000;
                break;
            case R.id.window:
                seat = 0;
                break;

                //사람 수 선택
                case R.id.Add:
                    if(num>0)   //num이 0보다 클 때, add버튼을 통해 num의 숫자를 1씩 더할 수 있다
                    num+=1;
                    break;
                case R.id.Sub:
                    if(num>1)    //num이 1보다 클 때, sub버튼을 통해 num의 숫자를 1씩 뺄 수 있음. 즉, 음수가 될 수 없다
                    num-=1;
                    break;


                //기내식 선택
            case R.id.korean:
            case R.id.western:
            case R.id.chinese:  //기내식의 가격은 모두 동일하므로 한꺼번에 묶어줘서 처리한다
                if(((CheckBox)view).isChecked())
                    meal += 15000;         //multiple choice
                else
                    meal -= 15000;
        }


        result = (ticket + meal + seat) * num;  //위에서 생성한 결과값 변수에 (티켓 + 기내식 + 좌석) x 사람 수 식을 넣어준다
        people.setText(Integer.toString(num));  //people에 num값을 문자열로 변환하여 저장
        total.setText(Integer.toString(result)); //total에 result값을 문자열로 변환하여 저장
    }
}
