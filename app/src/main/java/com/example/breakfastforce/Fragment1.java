package com.example.breakfastforce;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import java.util.Calendar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Fragment1 extends Fragment {
    FloatingActionButton fab_btn;
    Button date11;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    @RequiresApi(api = Build.VERSION_CODES.M)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment1, container, false);
        fab_btn = v.findViewById(R.id.fab_btn);
        fab_btn = (FloatingActionButton) v.findViewById(R.id.fab_btn);
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), Fragment1DiaryActivity.class);
                startActivity(intent);
            }
        });

//        Calendar c = Calendar.getInstance();
//        int mYear = c.get(Calendar.YEAR);
//        int mMonth = c.get(Calendar.MONTH);
//        int mDay = c.get(Calendar.DAY_OF_MONTH);
//
//        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//                Intent intent = new Intent(getActivity().getApplication(), Fragment1DiaryActivity.class);
//                startActivity(intent);
//                date11.setText(dayOfMonth+"/" + (month+1) + "/" + year);
//            }
//        }, mYear, mMonth, mDay);
//
//        fab_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (fab_btn.isClickable()) {
//                    datePickerDialog.show();
//                }
//            }
//        });


        return v;

    }
}