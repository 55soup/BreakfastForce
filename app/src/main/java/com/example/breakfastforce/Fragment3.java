package com.example.breakfastforce;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Time;


public class Fragment3 extends Fragment {
    TimePicker timepicker;
    Button alarm;
    TextView time_txt;
    int nHour, nMin;
    public Fragment3() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment3, container, false);
        timepicker =(TimePicker) v.findViewById(R.id.timepicker);
        time_txt = (TextView)v.findViewById(R.id.time_txt);
        alarm = (Button)v.findViewById(R.id.alarm);

        timepicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
                minute += 30; // 30분 뒤에 아침식사
                if(minute > 60){
                    ++hour;
                    minute -= 60;
                }
                if(hour > 12){
                    hour -= 12;
                    time_txt.setText("아침을 오후 "+hour+"시"+minute+"분 에\n 먹는 것이 좋아요!");
                }else{
                    time_txt.setText("아침을 오전 "+hour+"시"+minute+"분 에\n 먹는 것이 좋아요!");
                }

            }
        });
        nHour = timepicker.getCurrentHour();
//        nMin = timepicker.getCurrentMinute();
//        alarm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), nHour + nMin, Toast.LENGTH_SHORT).show();
//            }
//        });
        return v; // 반드시 추가
//        return inflater.inflate(R.layout.activity_fragment3, container, false);

    }


}
