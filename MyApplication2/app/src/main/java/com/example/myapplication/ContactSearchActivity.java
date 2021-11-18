package com.example.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactSearchActivity extends AppCompatActivity {

    EditText editName, editTel, editEmail;
    DBhelper helper;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout 지정 - contact_search.xml 파일을 이용
        setContentView(R.layout.contact_search);

        editName = findViewById(R.id.name);
        editTel = findViewById(R.id.tel);
        editEmail = findViewById(R.id.email);

        helper = new DBhelper(this);
        // DBHelper 객체를 이용하여 DB 생성
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }
    }

    public void search(View v){
        String name = editName.getText().toString();
        Cursor cursor;
        // EditText에 입력된 이름을 가지고 쿼리문을 만들어 실행
        cursor = db.rawQuery("SELECT name, tel, email FROM contacts WHERE name='" + name + "';", null);

        // 반환된 커서에 ResultSets의 행의 개수가 0개일 경우
        if(cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "해당 이름이 없습니다", Toast.LENGTH_SHORT).show();
            return;
        }
        // 반환된 커서를 가지고 전화번호 얻고 EditText에 표시
        while(cursor.moveToNext()) {
            String tel = cursor.getString(1);
            String email = cursor.getString(2);
            editTel.setText(tel);
            editEmail.setText(email);
        }
        cursor.close();

    }

    protected void onDestroy() {
        super.onDestroy();
        helper.close();

        startActivity(new Intent(this,MainActivity.class));
    }
}
