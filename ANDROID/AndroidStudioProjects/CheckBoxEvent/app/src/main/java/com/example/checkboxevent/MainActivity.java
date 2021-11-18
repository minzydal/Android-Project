package com.example.checkboxevent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_main );
        RatingBarratingBar= findViewById(R.id. ratingbar );
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast. makeText (getApplicationContext(), "New Rating: " + rating, Toast. LENGTH_SHORT ).show();
            }
        }
        );
    }

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {

            case R.id. radio_red :
                if(checked)
                    Toast. makeText (getApplicationContext(), ((RadioButton) view).getText(), Toast. LENGTH_SHORT ).show();
                break;
                case R.id. radio_blue :
                    if(checked)
                        Toast. makeText (getApplicationContext(), ((RadioButton) view).getText(), Toast. LENGTH_SHORT ).show();
                    break;
        }
    }

    /*
    public void onCheckboxClicked(View view) { // 둘 중 하나에서 이벤트 발생
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id. checkbox_meat :
                if(checked)
                    Toast. makeText (getApplicationContext(), "Meat checked", Toast. LENGTH_SHORT ).show();
                else
                    Toast. makeText (getApplicationContext(), "Meat not checked", Toast. LENGTH_SHORT ).show();
                break;

                case R.id. checkbox_cheese :
                    if(checked)
                        Toast. makeText (getApplicationContext(), "Cheese checked", Toast. LENGTH_SHORT ).show();
                    else
                        Toast. makeText (getApplicationContext(), "Cheese not checked", Toast. LENGTH_SHORT ).show();
                    break;
        }
    }
*/

    }

