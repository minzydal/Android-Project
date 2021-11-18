package com.example.myapplication;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ContactAddActivity extends AppCompatActivity {

    EditText editName, editTel, editEmail;
    SQLiteDatabase db;
    DBhelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_add);

        editName = findViewById(R.id.name);
        editTel = findViewById(R.id.tel);
        editEmail = findViewById(R.id.email);

        // SQLiteOpenHelper 클래스의 subclass인 DBHelper 클래스 객체 생성
        helper = new DBhelper(this);
        // DBHelper 객체를 이용하여 DB 생성
        try {
            db = helper.getWritableDatabase();
        } catch (SQLiteException e) {
            db = helper.getReadableDatabase();
        }
    }

    public void insert(View v){
        String name = editName.getText().toString();
        String tel = editTel.getText().toString();
        String email = editEmail.getText().toString();

        db.execSQL("INSERT INTO contacts VALUES(null, '" + name + "', '" + tel + "', '" + email + "');");

        Toast.makeText(getApplicationContext(),"추가완료",Toast.LENGTH_SHORT).show();

        editName.setText("");
        editTel.setText("");
        editEmail.setText("");
    }

    protected void onDestroy() {
        super.onDestroy();
        helper.close();

        startActivity(new Intent(this, MainActivity.class));
    }
}