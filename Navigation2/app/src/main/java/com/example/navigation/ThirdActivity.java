package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ThirdActivity extends AppCompatActivity {

    int position;
    String FILENAME = "path.txt";

    ArrayList<String> list = new ArrayList<>();

    EditText et1,et2, des, dep; // et1, et2 = 메인화면의 edittext값 // des, dep = 새로 입력할(수정) edittext값
    String str = "", end = ""; // 수정할 출발지와 목적지 문자열로 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        //액션바 타이틀 설정
        getSupportActionBar().setTitle("Revise Bookmark");

        Intent intent = getIntent();
        position = intent.getExtras().getInt("위치"); //인텐트로 데이터값 받아옴
        et1 = (EditText) findViewById(R.id.departure);
        et2 = (EditText) findViewById(R.id.destination);

        //파일 읽기
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);

            while (true) {
                String string = reader.readLine();
                if (string == null) {
                    break;
                }
            }
            fis.close();

    } catch (IOException e) {
            e.printStackTrace();
        }

        Button revise= findViewById(R.id.revise);
        revise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    dep = (EditText) findViewById(R.id.dep); //수정에 입력받을 출발지;departure
                    des = (EditText) findViewById(R.id.des); //수정에 입력받을 목적지;destination
                    str = dep.getText().toString();
                    end = des.getText().toString();
                    String findingpath = str + "→" + end; //수정한 출발지와 목적지 //코드의 간결화를 위해 edittext를 문자열로 받아주고 string을 이용하여 출발지 목적지 설정을 한다.

                    FileInputStream fis = openFileInput(FILENAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader reader = new BufferedReader(isr);

                    while (true) {
                        String string = reader.readLine();
                        if (string == null) {
                            break;
                        }
                    }
                    fis.close();

                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);   // 기존 파일값을 새로운 값으로 덮어씌운다.
                    fos.write(findingpath.getBytes());
                    fos.write("\n".getBytes());
                    fos.close();

                    BackToMain(); //메인화면으로 돌아가는 함수 호출

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

//메인 액티비티로 돌아가는 함수
    void BackToMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
















        /*

        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            while (true) {
                String string = reader.readLine();
                if (string == null) {
                    et1.setText(dep);
                    et2.setText(des);
                    break;
                }
            }

        Button revise = findViewById(R.id.revise);
        revise.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                try {
                    FileInputStream fis = openFileInput(FILENAME);
                    InputStreamReader isr = new InputStreamReader(fis);
                    BufferedReader reader = new BufferedReader(isr);
                    while (true) {
                        String string = reader.readLine();
                        if (string == null) {
                            break;
                        }
                        list.remove(string);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                    String str1 = et1.getText().toString();
                    String str2 = et2.getText().toString();
                    String str = str1 + "→" + str2;

                    try {

                        FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_PRIVATE);   // 기존 파일에 값을 추가하는 방식으로 파일 연결
                        fos.write(str.getBytes());    // get the value of destination
                        fos.write("\n".getBytes());
                        fos.close();

                        BackToMain();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
            void BackToMain() {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
}



/*
package com.example.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileOutputStream;
import java.io.IOException;


public class SecondActivity extends AppCompatActivity {
    Button addbtn;
    EditText et1;
    EditText et2;
    String str1;
    String str2;
    String FILENAME = "path.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setTitle("Add Bookmark");
        //액션바 설정, 타이틀

        et1 = (EditText) findViewById(R.id.departure);
        et2 = (EditText) findViewById(R.id.destination);



        addbtn = (Button) findViewById(R.id.addlist);
        addbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                    str1 = et1.getText().toString();
                    str2 = et2.getText().toString();
                    String str = str1 + str2;

                    FileOutputStream fos = openFileOutput(FILENAME, Context.MODE_APPEND);

                    fos.write(str.getBytes());
                    fos.close();

                    // setResult(RESULT_OK, intent);
                    startActivity(intent);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });}}



package com.example.navigation;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import android.widget.ListView;

import java.util.ArrayList;

public class ThirdActivity extends ListActivity {
    Intent intent;
    ArrayList<String> list;
    ArrayAdapter<String> adapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        list.add("한국기술교육대학교 → 서울역");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(adapter);

        Intent intent = getIntent();

       /*
        String str1 = intent.getExtras().getString("departure");
        String str2 = intent.getExtras().getString("destination");

    }
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            switch(resultCode){
                case Activity.RESULT_OK:
            if(requestCode == 1){
                if(resultCode == RESULT_OK){

                    Intent intent = getIntent();

                    String str1 = intent.getStringExtra("departure");
                    String str2 = intent.getStringExtra("destination");
                    list.add(str1 + "→" +str2);
                    adapter.notifyDataSetChanged();
                }
            }
            }
        }

}
           // list.add(data.getStringExtra("pathfinding").toString());

            /*
            Intent intent = new Intent(this.getIntent());
            String str = intent.getExtras().getString("pathfinding");
            list.add(str);
            adapter.notifyDataSetChanged();
            //super.onActivityResult(requestCode, resultCode, data);
        }
    }

/*
        list.add(str1 + str2);
        adapter.notifyDataSetChanged();
    }}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Intent intent = new Intent(this.getIntent());
        String str = intent.getExtras().getString("departure" + "→" + "destination");
        list.add(str);
        adapter.notifyDataSetChanged();
    }
}

        /*
        if (requestCode == INTENT_REQUEST_CODE && resultCode == Activity.RESULT_OK){
            String findingpath = data.getStringExtra("findingpath")
            TextView dep = findViewById(R.id.depname);
            TextView des = findViewById(R.id.desname);
            dep.setText(findingpath);
            des.setText(findingpath);
        }
}












        /*
        Button btn = (Button) findViewById(R.id.addlist);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

       View.OnClickListener listener = new View.OnClickListener() {
                                 @Override
                                 public void onClick(View v) {
                                     Intent intent = getIntent();


                                     EditText et1 = (EditText) findViewById(R.id.departure);
                                     EditText et2 = (EditText) findViewById(R.id.destination);
                                     String str1 = intent.getStringExtra("");
                                     String str2 = intent.getStringExtra("");

                                     list.add(et1.getText() + "→" + et2.getText());
                                     et1.setText("");
                                     et2.setText("");
                                     list = intent.getStringArrayListExtra("");
                                     //intent.putExtra("", et1.getText() + "→" + et2.getText());
                                     adapter.notifyDataSetChanged();
                                 }};
        btn.setOnClickListener(listener);
    setListAdapter(adapter);
    }
}

/*
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String str = str1 + "→" + str2;
                list.add(str);
                et1.setText("");
                et2.setText("");

                adapter.notifyDataSetChanged();
            }
        };

        btn.setOnClickListener(listener);
        setListAdapter(adapter);
    }

}

        /*
            @Override
            public View getView(int)
            public void onClick(View v) {
                String str1 = et1.getText().toString();
                String str2 = et2.getText().toString();
                String str = str1 + "→" + str2;

                list.add(str);
                //adapter.notifyDataSetChanged();
                System.out.println(str);
                 }
        });
    }
}

         */