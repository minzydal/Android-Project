package com.example.oneul;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DBmain extends AppCompatActivity {

    public class MainActivity extends AppCompatActivity {

        EditText contents; //일기 내용
        ListView listView;

        DBHelper dbHelper;
        SQLiteDatabase db = null;
        Cursor cursor;
        ArrayAdapter adapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            dbHelper = new DBHelper(this, 4);
            db = dbHelper.getWritableDatabase();    // 읽기/쓰기 모드로 데이터베이스를 오픈
        }


        public void listUpdate(View v) {
            cursor = db.rawQuery("SELECT * FROM tableName", null);
            startManagingCursor(cursor);    //엑티비티의 생명주기와 커서의 생명주기를 같게 한다.

            adapter = new ArrayAdapter(this,
                    android.R.layout.simple_list_item_1);

            while (cursor.moveToNext()) {
                adapter.add(cursor.getString(0));
            }
        }


        public void insert(View v) {
            String diary = contents.getText().toString();
            db.execSQL("INSERT INTO tableName VALUES " + diary);

            Toast.makeText(getApplicationContext(), "추가 성공", Toast.LENGTH_SHORT).show();

            contents.setText("");
        }

        public void delete(View v) {
            String diary = contents.getText().toString();
            db.execSQL("DELETE FROM tableName WHERE name =" + diary);
        }

    }

}
