package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AskSubActivity extends AppCompatActivity {
    ImageButton btn_back, btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_sub);
        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(AskSubActivity.this, AskMainActivity.class);
//                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_to_right, R.anim.anim_slide_center);
                onBackPressed();
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AskSubActivity.this, AskThirdActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.anim_slide_to_left, R.anim.anim_slide_center);
            }
        });

    }
}