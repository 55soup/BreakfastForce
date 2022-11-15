package com.example.breakfastforce;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class Fragment1 extends Fragment {
    FloatingActionButton fab_btn;

    ListView listview;
    ListItemAdapter adapter;
    final ArrayList<String> arrayList = new ArrayList<String>();
    TextView userName;
    Calendar myCalendar = Calendar.getInstance();
    Button clickBtn;
    outputUsername u1 =  new outputUsername(getContext());

    DatePickerDialog.OnDateSetListener myDatePicker = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String c = year + "년 " + (month + 1) + "월 " + dayOfMonth + "일";

            Intent intent = new Intent(getActivity().getApplication(), Fragment1DiaryActivity.class);
            intent.putExtra("날짜", c);
            startActivity(intent);
        }
    };

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment1, container, false);
        fab_btn = (FloatingActionButton) v.findViewById(R.id.fab_btn);
        listview = (ListView) v.findViewById(R.id.listview);
        userName = (TextView) v.findViewById(R.id.userName);
        adapter = new ListItemAdapter();
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