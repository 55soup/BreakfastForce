package com.example.breakfastforce;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class Fragment4 extends Fragment {
    FloatingActionButton fab_btn;
    ListView listview;
    ListItemAdapter adapter;
    ImageFilterButton btn_breakfast;
    FloatingActionButton float_btn;
    TextView userName;
    final ArrayList<String> arrayList = new ArrayList<String>();
    outputUsername u1 = new outputUsername(getContext()); //getUserName() 메서드를 위한 class

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
        userName = (TextView) v.findViewById(R.id.userName);
        adapter = new ListItemAdapter();
        // ---------------------------------- userName 설정 ----------------------------------
        try{
            FileInputStream inFs = getContext().openFileInput("user.txt");
            byte[] txt = new byte[30];
            inFs.read(txt);
            String user = new String(txt);
            userName.setText(user+"님을 위한\n아침먹는 습관 기르기에 관련된 글이에요!");
            inFs.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        // ---------------------------------- userName 설정 ----------------------------------
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