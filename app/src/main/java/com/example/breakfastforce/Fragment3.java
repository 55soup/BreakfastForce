package com.example.breakfastforce;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.core.view.KeyEventDispatcher;
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
import java.util.List;


public class Fragment3 extends Fragment {
    TimePicker timepicker;
    Button alarm;
    TextView time_txt;
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

        alarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = getPackageManager().getLaunchIntentForPackage("com.sec.android.app.clockpackage");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch(Exception e){
                    String url = "market://details?id=" + "com.sec.android.app.clockpackage";
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                }
//                 시계앱으로 연결
//                ComponentName cn = new ComponentName("com.sec.android.app.clockpackage", "com.sec.android.app.clockpackage.clockPackage");
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_LAUNCHER);
//                intent.setComponent(cn);
//                startActivity(intent);
            }

            private PackageManager getPackageManager() {
                return null;
            }

        });
        return v; // 반드시 추가
//        return inflater.inflate(R.layout.activity_fragment3, container, false);

    }



}
