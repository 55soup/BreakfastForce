package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

public class BookmarksActivity extends AppCompatActivity {
    ImageButton btn_back;
    ListView bookmarkList;
    ListItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmarks);
        btn_back = findViewById(R.id.btn_back);
        bookmarkList = findViewById(R.id.bookmarkList);
        adapter = new ListItemAdapter();

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // 뒤로 가기 버튼
            }
        });

        /////////////////////////////////////////////////////////listview 관리

        ////////////////////////////////////////////////////////
    }
}