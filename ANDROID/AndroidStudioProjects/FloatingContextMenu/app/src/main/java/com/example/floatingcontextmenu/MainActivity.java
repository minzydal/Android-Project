package com.example.floatingcontextmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        menu.setHeaderTitle("Context Menu");
        menu.add(0, 1, 0, "배경색: RED");
        menu.add(0, 2, 0, "배경색: GREEN");
        menu.add(0, 3, 0, "배경색: BLUE");
    }
        setContentView(R.layout.activity_main);
}

