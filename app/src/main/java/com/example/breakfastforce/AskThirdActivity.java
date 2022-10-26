package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AskThirdActivity extends AppCompatActivity {
    ImageButton btn_back, btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_third);
        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskThirdActivity.this, AskSubActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_to_right, R.anim.anim_slide_center);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskThirdActivity.this, Fragment1.class);
                startActivity(intent); // activity -> fragment 이동 구현해야함
                overridePendingTransition(R.anim.anim_slide_to_left, R.anim.anim_slide_center);
            }
        });

    }
}