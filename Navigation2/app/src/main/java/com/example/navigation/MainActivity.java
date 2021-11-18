package com.example.navigation;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

//메인화면 실행
public class MainActivity extends AppCompatActivity {

    ArrayList<String> list = new ArrayList<>();

    String FILENAME = "path.txt"; //데이터를 받아올 텍스트파일 생성

    ListView lv;    // 메인 액티비티 리스트뷰
    ArrayAdapter<String> adapter;     // 리스트 어댑터
    EditText et1, et2; //layout에 있는 edittext값 받을 변수
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //파일 읽어오기
        try {
            FileInputStream fis = openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);
            while (true) {
                String str = reader.readLine();
                if (str == null) {
                    break;  //문자열이 비어있다면 break시키고
                }
                list.add(str); //아니면 리스트 추가
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();    //예외적으로 메소드가 내부 결과를 출력
        }

        //변수 속성 선언
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        lv = findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(onClickListItem);
        et1 = findViewById(R.id.departure);
        et2 = findViewById(R.id.destination);

        registerForContextMenu(lv); //컨텍스트메뉴 등록

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);
        return super.onCreateOptionsMenu(menu); //액션바화면 띄우기
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add) {
            Intent intent = new Intent(this, SecondActivity.class);
            startActivity(intent); //액션바에 있는 아이콘(추가버튼)을 누르면 SecondActicity로 화면 전환
        }
        return super.onOptionsItemSelected(item);
    }

    //onActivityresult로 다른 액티비티 데이터 받아오기
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case Activity.RESULT_OK:
                if (requestCode == 1) {
                    if (resultCode == RESULT_OK) {

                        Intent intent = getIntent();

                        String str1 = intent.getStringExtra("departure");
                        String str2 = intent.getStringExtra("destination");
                        adapter.add(str1 + str2);
                    }
                }
        }
    }

    //구글맵 실행코드
    private AdapterView.OnItemClickListener onClickListItem = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //파일 읽어오기
            try {
                FileInputStream fis = openFileInput(FILENAME);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader reader = new BufferedReader(isr);

                while (true) {
                    String string = reader.readLine(); //한줄씩 읽기
                    if (string == null) {
                        break;
                    }
                    list.add(string); //입력한 문자열 추가
                }
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String[] A = adapter.getItem(position).split("→"); // A[0] = 출발지 , A[1] = 도착지
            intent = new Intent(intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/dir/" + A[0] + "/" + A[1]));
            startActivity(intent);
        }
    };

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.contextmenu, menu);
        menu.setHeaderTitle("메뉴");
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // 컨텍스트 메뉴 이벤트
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index = info.position;

        switch (item.getItemId()) {
            case R.id.context_modify:   // 수정 선택시 수정을 위한 액티비티 실행
                Intent intent = new Intent(this, ThirdActivity.class);
                intent.putExtra("위치", index);
                startActivity(intent);
                return true;

            case R.id.context_delete:   // 삭제 선택시 삭제를 위한 함수 실행
                delete(index); // 삭제 함수 호출
                break;
        }
        return true;
    }
                //삭제 선택시 실행할 함수 코드
                   public void delete(int position) {
                       try {
                           FileInputStream fis = openFileInput(FILENAME);
                           InputStreamReader isr = new InputStreamReader(fis);
                           BufferedReader reader = new BufferedReader(isr);
                           while (true) {
                               String string = reader.readLine(); //문자열 한줄씩 읽기
                               if (string == null) {
                                   break;
                               }
                           }
                           fis.close();
                       }catch(IOException e){

                  e.printStackTrace();
                       }
                       String item = adapter.getItem(position);
                       adapter.remove(item); //아이템 리스트 하나씩 지움
                   }
        }
