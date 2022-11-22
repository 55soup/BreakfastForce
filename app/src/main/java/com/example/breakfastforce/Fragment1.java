package com.example.breakfastforce;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.Nullable;
import org.w3c.dom.Text;


public class Fragment1 extends Fragment {
    FloatingActionButton fab_btn;

    TextView userName;
    Calendar myCalendar = Calendar.getInstance();
//    outputUsername u1 =  new outputUsername(getContext());

    // 리사이클러뷰
    private RecyclerView recyclerView;
    private CardViewAdaper adaper;
    private ArrayList<ItemData> list = new ArrayList<>();

    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String c = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";
            String sdPath = year + "_" + (month + 1) + "_" + dayOfMonth;

            Intent intent = new Intent(getActivity().getApplication(), Fragment1DiaryActivity.class);
            intent.putExtra("날짜", c);
            intent.putExtra("경로", sdPath);
            startActivity(intent);
        }
    };

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    @Nullable
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = (ViewGroup)inflater.inflate(R.layout.activity_fragment1, container, false);

        // 리사이클러뷰
        recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        list = ItemData.createContactsList(5);
        recyclerView.setHasFixedSize(true);
        adaper = new CardViewAdaper(getActivity(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adaper);

        // ---------------------------------- 날짜.txt 파일 리스트 불러오기 ----------------------------
        // ---------------------------------- txt 파일 불러와서 카드뷰에 하나씩 넣기 ----------------------


        fab_btn = (FloatingActionButton) v.findViewById(R.id.fab_btn);
        userName = (TextView) v.findViewById(R.id.userName);

        // ---------------------------------- userName 설정 ----------------------------------
        try{
            FileInputStream inFs = getContext().openFileInput("user.txt");
            byte[] txt = new byte[30];
            inFs.read(txt);
            String user = new String(txt);
            userName.setText(user);
            inFs.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        // ---------------------------------- userName 설정 ----------------------------------
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), myDatePicker, myCalendar.get(Calendar.YEAR), myCalendar.get(Calendar.MONTH), myCalendar.get(Calendar.DAY_OF_MONTH)).show();

            }
        });


        return v;

    }
}