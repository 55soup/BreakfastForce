package com.example.breakfastforce;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Fragment1 extends AppCompatActivity {

    TextView userName;
    FloatingActionButton fab_btn;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1);

        fab_btn = findViewById(R.id.fab_btn);
        userName = findViewById(R.id.userName);

        DatePickerDialog dlg = new DatePickerDialog(Fragment1.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                userName.setText("뿡");
            }
        })

        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.show();
            }
        });
    }
}