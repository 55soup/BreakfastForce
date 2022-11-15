package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;

import java.io.File;

public class StandbyscreenActivity extends AppCompatActivity {

    String filePath = "/data/data/com.example.breakfastforce/files/user.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standbyscreen);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                if(new File(filePath).exists()){
                    // user.txt 파일이 존재하면 자가진단 페이지로
                    Intent intent = new Intent (getApplicationContext(), AskMainActivity.class);
                    startActivity(intent); //인트로 실행 후 바로 InputNameActivity로 넘어감.
                    finish();
                }else{
                    // user.txt 파일이 존재x 이름입력 페이지로
                    Intent intent = new Intent (getApplicationContext(), InputNameActivity.class);
                    startActivity(intent); //인트로 실행 후 바로 InputNameActivity로 넘어감.
                    finish();
                }
            }
        },4500); //4.5초 후 메인 실행
    }
}