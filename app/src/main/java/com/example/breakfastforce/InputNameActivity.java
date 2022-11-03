package com.example.breakfastforce;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class InputNameActivity extends AppCompatActivity {
    EditText edit_name;
    MyDBHelper myDBHelper;
    SQLiteDatabase sqlDB;
    ImageButton btn_next;
    TextView txtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_name);
        edit_name = findViewById(R.id.edit_name);
        btn_next = findViewById(R.id.btn_next);
        txtName = findViewById(R.id.txtName);
        myDBHelper = new MyDBHelper(this);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String name = edit_name.getText().toString().trim();
                    if(name.isEmpty())
                        Toast.makeText(getApplicationContext(), "반드시 이름을 입력하세요!", Toast.LENGTH_SHORT).show();
                    if(name.length() > 5)
                        Toast.makeText(getApplicationContext(), "5글자 이내로 입력하세요!", Toast.LENGTH_SHORT).show();
                    sqlDB = myDBHelper.getWritableDatabase();
                    String str = "insert into groupTBL(name) values('"+name+"');";
                    sqlDB.execSQL(str);
                    sqlDB.close();


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력에 실패했습니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}