package com.example.activitypractice;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){
        //
        Intent intent = new Intent(this, MemoTextActivity.class);
        startActivity(intent);

        public boolean onCreateOptionsMenu(Menu menu){
            getMenuInflater().inflate(R.menu.main_menu, menu);
            return super.onCreateOptionsMenu(menu);

            public boolean onOptionsItemSelected(MenuItem item){
            protected void Oncreate
            }
        }
    }
}