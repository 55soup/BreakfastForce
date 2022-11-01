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
        adapter.addItem(new ListItem("아침을 먹어야하는 이유", "2020년 부터 매일 아침을 먹기로\n" +
                "마음 먹었다. 그 뒤로 꾸준히 가리지않고\n" +
                "일정한 시간 밥을 먹었다.", "2022.10.19"));
        adapter.addItem(new ListItem("가족과 함께 즐거운 아침", "2020년 부터 매일 아침을 먹기로\n" +
                "마음 먹었다. 그 뒤로 꾸준히 가리지않고\n" +
                "일정한 시간 밥을 먹었다.", "2022.10.19"));
        adapter.addItem(new ListItem("내가 자주 하는 아침 루틴", "아침에 일어나서 요가를 많이 한다.\n" +
                "잠으로 찌뿌둥해진 몸도 많이 풀리고\n" +
                "정신도 맑아지는 것 같다.\n", "2022.10.19"));
        bookmarkList.setAdapter(adapter);
        ////////////////////////////////////////////////////////
    }
}