package com.example.breakfastforce;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;


public class Fragment4 extends Fragment {
    FloatingActionButton fab_btn;

    StringBuffer sb= null;
    MyAdapter adapter;

    ImageFilterButton btn_breakfast;
    FloatingActionButton float_btn;
    TextView userName;
    outputUsername u1 = new outputUsername(getContext()); //getUserName() 메서드를 위한 class

    private ArrayList<String> arrayList = new ArrayList<String>();

    public Fragment4() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment4, container, false);
        btn_breakfast = (ImageFilterButton) v.findViewById(R.id.btn_breakfast);
        adapter = new MyAdapter(getActivity(), getListItem());
        fab_btn = (FloatingActionButton) v.findViewById(R.id.fab_btn);
        userName = (TextView) v.findViewById(R.id.userName);

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
                sb = new StringBuffer();

                for(ListItem l : adapter.checkedList) {
                    sb.append(l.getTitle());
//                    sb.append(l.getContent());
//                    sb.append(l.getDate());
                }
                
                if(adapter.checkedList.size() > 0) {
                    Toast.makeText(getActivity(), sb.toString(), Toast.LENGTH_SHORT).show();
                }
                // 선택 안 했을 때 그냥 아무 일도 안 일어나도록

                Intent intent = new Intent(getActivity().getApplication(), BookmarksActivity.class);
                startActivity(intent);
            }
        });

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.my_recycler);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setItemAnimator(new DefaultItemAnimator());

        rv.setAdapter(adapter);

//        // https://asong-study-record.tistory.com/52
//        // http://lueseypid.tistory.com/14
//        // https://asong-study-record.tistory.com/52
//        // https://blog.naver.com/PostView.naver?blogId=hwa2ting3612&logNo=221218523364&redirect=Dlog&widgetTypeCall=true&directAccess=false
//
//
//        /////////////////////////////////////////////////////////listview 관리
//        adapter.addItem(new ListItem("아침을 먹어야 하는 이유", "2020년 부터 매일 아침을 먹기로\n" +
//                "마음 먹었다. 그 뒤로 꾸준히 가리지않고\n" +
//                "일정한 시간 밥을 먹었다.", "2022.10.19"));
//        adapter.addItem(new ListItem("가족과 함께 즐거운 아침", "2020년 부터 매일 아침을 먹기로\n" +
//                "마음 먹었다. 그 뒤로 꾸준히 가리지않고\n" +
//                "일정한 시간 밥을 먹었다.", "2022.10.22"));
//        adapter.addItem(new ListItem("내가 자주 하는 아침 루틴", "아침에 일어나서 요가를 많이 한다.\n" +
//                "잠으로 찌뿌둥해진 몸도 많이 풀리고\n" +
//                "정신도 맑아지는 것 같다.\n", "2022.11.19"));
//        adapter.addItem(new ListItem("상쾌한 아침을 보내는 방법!", "일어나자마자 창문을 연다.\n" +
//                "아침 공기를 맡으며 머리를 맑게해준다.\n" +
//                "새소리도 들으면서~ ㅎㅎ.\n", "2022.12.1"));
//
//        listview.setAdapter(adapter);
//        ////////////////////////////////////////////////////////
//        //// 리스트뷰를 클릭했을 시

        return v;

    }

    private ArrayList<ListItem> getListItem() {
        ArrayList<ListItem> list = new ArrayList<>();
        ListItem l = new ListItem("아침을 먹어야 하는 이유", "2020년 부터 매일 아침을 먹기로\n" +
                "마음 먹었다. 그 뒤로 꾸준히 가리지않고\n" +
                "일정한 시간 밥을 먹었다.", "2022.10.19");
        list.add(l);

        l = new ListItem("가족과 함께 즐거운 아침", "2020년 부터 매일 아침을 먹기로\n" +
                "마음 먹었다. 그 뒤로 꾸준히 가리지않고\n" +
                "일정한 시간 밥을 먹었다.", "2022.10.22");
        list.add(l);

        l = new ListItem("내가 자주 하는 아침 루틴", "아침에 일어나서 요가를 많이 한다.\n" +
                "잠으로 찌뿌둥해진 몸도 많이 풀리고\n" +
                "정신도 맑아지는 것 같다.\n", "2022.11.19");
        list.add(l);

        l = new ListItem("상쾌한 아침을 보내는 방법!", "일어나자마자 창문을 연다.\n" +
                "아침 공기를 맡으며 머리를 맑게해준다.\n" +
                "새소리도 들으면서~ ㅎㅎ.\n", "2022.12.1");
        list.add(l);

        return list;
    }
}