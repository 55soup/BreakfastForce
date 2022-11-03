package com.example.breakfastforce;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context, "DiaryDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String diarySql = "CREATE TABLE DiaryTBL(_id integer primary key autoincrement, " + "diaryDate char(30), content varchar(600));";
        sqLiteDatabase.execSQL(diarySql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists DiaryTBL;"); //테이브르 삭제
        onCreate(sqLiteDatabase); //테이블 생성
    }
}
