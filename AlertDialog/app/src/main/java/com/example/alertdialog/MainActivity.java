package com.example.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id. button );
        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                DialogFragment myFragment = new ButtonDialogFragment();
                myFragment.show(getFragmentManager(), "FinishDialog");
                @Override protected Dialog onCreateDialog ( int id){
                }
                    switch (id) {
                        case DIALOG_YES_NO_MESSAGE:
                            AlertDialog.Builder builder = new AlertDialog.Builder(this);
                            builder.setTitle("종료확인대화상자")
                                    .setMessage("애플리케이션을종료하시겠습니까?")
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                        }
                                    }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                            AlertDialog alert = builder.create();
                            return alert;
                    }
                    return null;
            }
            }
        }