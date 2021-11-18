package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private ListView m_ListView;
    private ArrayAdapter<String> m_Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    String[] values = {"하스스톤", "몬스터 헌터"}

    m_Adaptor = new ArrayAdapter <String>(this, android.R.layout.simple_list_item1, values);
    m_ListView = findViewById(R.id.list);
    m_ListView.setAdapter(m_Adapter);
    m_ListView.setOnItemClickListener(onClickListItem)
    }
}
