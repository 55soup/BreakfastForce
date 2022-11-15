package com.example.breakfastforce;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Fragment1DiaryActivity extends AppCompatActivity {
    ImageButton btn_back;
    Button photo1;
//    FloatingActionButton fab_btn;
    TextView dialog_id;
    final int GET_GALLERY_IMAGE = 200;
    TextView title, content;
    EditText edtContent;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1_diary);
        // SD 사용 허가 
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        // SD 코드
        
        // fragment1 에서 받아온 값
        Intent intent = getIntent();
        String c = intent.getStringExtra("날짜");
        String sdPath = intent.getStringExtra("경로");
        dialog_id = findViewById(R.id.dialog_id);
        dialog_id.setText(c);

        // OK 버튼
        FloatingActionButton fab_btn = (FloatingActionButton) findViewById(R.id.fab_btn);
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

            }
        });



        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // 뒤로 가기 버튼
            }
        });

//        photo1 = findViewById(R.id.photo1);
//        photo1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Intent.ACTION_PICK);
//                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
////                startActivityForResult(intent,GET_GALLERY_IMAGE);
//            }
//        });

    }

    //파일 읽기 함수 따로 정의
//    String readDiary(String fname) {
//        String diaryData = null;//일기 내용 저장하는 변수
//        try {
//            FileInputStream inFs = new FileInputStream(fname);//년_월_일.txt 파일 읽기
//            byte[] in = new byte[500];
//            inFs.read(in);
//            diaryData = (new String(in)).trim();//양끝에 공백제거함수 trim()
//            inFs.close();
//        } catch (Exception e) {
//        }
//        return diaryData;
//    }
}