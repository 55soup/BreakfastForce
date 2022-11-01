package com.example.breakfastforce;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


public class Fragment4 extends Fragment {
    FloatingActionButton fab_btn;
    ListView listview;
    ListItemAdapter adapter;
    ImageFilterButton btn_breakfast;
    FloatingActionButton float_btn;
    final ArrayList<String> arrayList = new ArrayList<String>();

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment4, container, false);
        listview = (ListView) v.findViewById(R.id.listview);
        btn_breakfast = (ImageFilterButton) v.findViewById(R.id.btn_breakfast);
        fab_btn = (FloatingActionButton) v.findViewById(R.id.fab_btn);
        adapter = new ListItemAdapter();
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), BookmarksActivity.class);
                startActivity(intent);
            }
        });
        // btn_breakfast눌렀을 때 글 나오기

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
        listview.setAdapter(adapter);
        ////////////////////////////////////////////////////////
        //// 리스트뷰를 클릭했을 시

        return v;

    }
}