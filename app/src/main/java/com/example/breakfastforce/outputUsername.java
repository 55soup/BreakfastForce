package com.example.breakfastforce;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class outputUsername {
    Context context;
    public outputUsername(Context ct) {
        //context를 가져오는 생성자 메서드
        context = ct;
    }

    public String getUserName(){
        try{
            FileInputStream inFs = context.openFileInput("user.txt");
            byte[] txt = new byte[30];
            inFs.read(txt);
            String user = new String(txt);
            inFs.close();
            return user;
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return "";
    }
}
