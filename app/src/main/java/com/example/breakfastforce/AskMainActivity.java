package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioGroup;

public class AskMainActivity extends AppCompatActivity {
    RadioGroup rgBreakfast;
    ImageButton btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_main);
        rgBreakfast = findViewById(R.id.rgBreakfast);
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskMainActivity.this, AskSubActivity.class);
                startActivity(intent);
//                overridePendingTransition(R.anim.anim_slide_in_left, R.anim.anim_slide_out_right); //애니메이션 리소스
            }
        });
    }
}