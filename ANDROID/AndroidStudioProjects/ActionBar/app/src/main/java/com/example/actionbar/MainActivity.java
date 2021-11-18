package com.example.actionbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu;this adds ite ms to the action bar if it is present.
        getMenuInflater().inflate(R.menu. action_bar , menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                Log.v("ActionBar", "refresh button");
                Toast.makeText(getApplicationContext(), "refresh", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Log.v("ActionBar", "search button");
                Toast.makeText(getApplicationContext(), "search", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                Log.v("ActionBar", "setting button");
                Toast.makeText(getApplicationContext(), "settings", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    }
