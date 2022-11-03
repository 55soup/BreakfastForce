package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputNameActivity extends AppCompatActivity {
    EditText edit_name;
    ImageButton btn_next;
    TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);
        edit_name = findViewById(R.id.edit_name);
        btn_next = findViewById(R.id.btn_next);
        txtName = findViewById(R.id.txtName);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    // 내장메모리 파일 처리
                    FileOutputStream outFs = openFileOutput("user.txt", Context.MODE_PRIVATE);
                    String name = edit_name.getText().toString().trim();

                    if(name.length() > 5)
                        Toast.makeText(getApplicationContext(), "5글자 이내로 입력하세요!", Toast.LENGTH_SHORT).show();
                    else  if(name.isEmpty())
                        Toast.makeText(getApplicationContext(), "반드시 이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    else{
                        outFs.write(name.getBytes(StandardCharsets.UTF_8));
                        outFs.close();
                        Toast.makeText(getApplicationContext(), name + "님 안녕하세요!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InputNameActivity.this, AskMainActivity.class);
                        startActivity(intent);
                    }
                }catch (IOException e){
                    Toast.makeText(getApplicationContext(), "입력에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}