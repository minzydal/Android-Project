package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.FileOutputStream;
import java.io.IOException;


public class SecondActivity extends AppCompatActivity {

    String FILENAME = "path.txt"; //텍스트파일 선언
    ListView lv;    // 메인 액티비티 리스트
    EditText et1, et2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = findViewById(R.id.listView1); //리스트뷰속성

        getSupportActionBar().setTitle("Add Bookmark");
        //액션바 설정, 타이틀

        et1 = findViewById(R.id.departure);
        et2 = findViewById(R.id.destination);

        //추가버튼을 눌렀을 때 실행코드
        Button addbtn = findViewById(R.id.addlist);
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //코드의 간결화를 위해 문자열로 변수 재선언.
                String str1 = et1.getText().toString();
                String str2 = et2.getText().toString();
                String str = str1 + "→" + str2;
                    try {
                        Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);   // 기존 파일에 값을 추가하는 방식으로 파일 연결
                        fos.write(str.getBytes());    // 출발지와 목적지값의 문자열을 받는다
                        fos.write("\n".getBytes());
                        fos.close();

                        startActivity(intent);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                Intent intent = new Intent();
                intent.putExtra("INPUT_TEXT", str);

                setResult(RESULT_OK, intent);
                finish();
                }
        });}}