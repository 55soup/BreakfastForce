package com.example.breakfastforce;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


class fragment2Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

public class Fragment2 extends Fragment {
    MainActivity activity;
    ImageButton btn_sandwich;
    TextView userName;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) getActivity();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment2, container, false);
        btn_sandwich = (ImageButton) v.findViewById(R.id.btn_sandwich);
        userName = (TextView) v.findViewById(R.id.userName);
        // ---------------------------------- userName 설정 ----------------------------------
        try{
            FileInputStream inFs = getContext().openFileInput("user.txt");
            byte[] txt = new byte[30];
            inFs.read(txt);
            String user = new String(txt);
            userName.setText(user + "님은\n이런 아침 어떠세요?");
            inFs.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        // ---------------------------------- userName 설정 ----------------------------------
        btn_sandwich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), RecipePageActivity.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION); // 애니메이션 생략
                startActivity(intent);
            }
        });

        return v; //반드시 추가!

    }
}