package com.example.breakfastforce;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.nio.charset.StandardCharsets;

public class Fragment1DiaryActivity extends AppCompatActivity {
    ImageButton btn_back;
    ImageView photo1;
    //    FloatingActionButton fab_btn;
    TextView dialog_id;
    TextView userName;
    final int GET_GALLERY_IMAGE = 200;
    EditText edtTitle, edtContent;

    String fileName;
    String sdPath;
    File myDir;

    String edT;
    String edC;

    String imgFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment1_diary);
        // SD 사용 허가 
        ActivityCompat.requestPermissions(this, new String[]
                {android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        userName = findViewById(R.id.userName);

        // SD 코드

        // fragment1 에서 받아온 값
        Intent intent = getIntent();
        String c = intent.getStringExtra("날짜");
        String sc = intent.getStringExtra("경로");
        dialog_id = findViewById(R.id.dialog_id);
        dialog_id.setText(c);

        sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        sdPath += "/myDiary/";
        myDir = new File(sdPath);
//        if (!myDir.isDirectory()) myDir.mkdir();

        edtTitle = findViewById(R.id.edtTitle);
        edtContent = findViewById(R.id.edtContent);

        String imgName = sdPath + sc + ".png";

        // OK 버튼
        FloatingActionButton fab_btn = (FloatingActionButton) findViewById(R.id.fab_btn);
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            @RequiresApi(api = Build.VERSION_CODES.N)
            public void onClick(View v) {

                // 폴더 생성
                myDir.mkdir();
                // 파일명 생성 (경로 + 해당 날짜)
                fileName = sdPath + sc + ".txt";

                try {
                    FileOutputStream out = new FileOutputStream(fileName);
                    edT = edtTitle.getText().toString() + "\n\n";
                    edC = edtContent.getText().toString();
                    out.write(edT.getBytes());
                    out.write(edC.getBytes());
                    out.close();
//                    Toast.makeText(getApplicationContext(), fileName + " 에 저장됨", Toast.LENGTH_SHORT).show();
                    finish();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        //==========================userName설정===========================
        try {
            FileInputStream inFs = getApplicationContext().openFileInput("user.txt");
            byte[] txt = new byte[30];
            inFs.read(txt);
            String user = new String(txt);
            userName.setText(user);
            inFs.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //==========================userName설정===========================


        btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // 뒤로 가기 버튼
            }
        });

        // =======================이미지 불러오기================================ //

        photo1 = findViewById(R.id.photo1);

        try {
            Bitmap bm = BitmapFactory.decodeFile(imgFile);

            photo1.setImageBitmap(bm); // 내부 저장소에 저장된 이미지를 이미지뷰에 셋
            Toast.makeText(getApplicationContext(), imgFile + "파일 로드 성공", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "파일 로드 실패", Toast.LENGTH_SHORT).show();
        }

        // 이미지뷰 누르면 선택 실행, 갤러리 오픈픈
        photo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, 101);
                launcher.launch(intent);
            }
        });
    }


        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == RESULT_OK) {
                            Intent intent = result.getData();
                            Uri uri = intent.getData();
////                            Glide.with(Fragment1DiaryActivity.this).load(uri).into(photo1);
                            ContentResolver resolver = getContentResolver();
                            try {
                                InputStream instream = resolver.openInputStream(uri);
                                Bitmap imgBitmap = BitmapFactory.decodeStream(instream);
                                photo1.setImageBitmap(imgBitmap);    // 선택한 이미지 이미지뷰에 셋
                                instream.close();   // 스트림 닫아주기
                                saveBitmapToJpeg(imgBitmap);    // 내부 저장소에 저장
                                Intent in = new Intent(getApplication(), Fragment1.class);
                                in.putExtra("img", imgBitmap);
                                startActivity(in);

                            } catch (Exception e) {
                            }
                        }
                    }
                });

        public void saveBitmapToJpeg(Bitmap bitmap) {   // 선택한 이미지 내부 저장소에 저장
            File tempFile = new File(sdPath);    // 파일 경로와 이름 넣기
            try {
                tempFile.createNewFile();   // 자동으로 빈 파일을 생성하기
                FileOutputStream out = new FileOutputStream(tempFile);  // 파일을 쓸 수 있는 스트림을 준비하기
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);   // compress 함수를 사용해 스트림에 비트맵을 저장하기
                out.close();    // 스트림 닫아주기
            } catch (Exception e) {
            }
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