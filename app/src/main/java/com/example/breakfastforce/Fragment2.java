package com.example.breakfastforce;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


class fragment2Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton test = (ImageButton) findViewById(R.id.test);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SubActivity.class);
                startActivity(intent);
            }
        });
    }
}

public class Fragment2 extends Fragment {
//    ImageButton btn_sandwich;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment



//        View v = inflater.inflate(R.layout.activity_fragment2, container, false);
//        btn_sandwich = (ImageButton) v.findViewById(R.id.btn_sandwich);
//        btn_sandwich.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "샌드위치 클릭", Toast.LENGTH_SHORT).show();
//                Intent in = new Intent();
//                startActivity(in);
//            }
//        });

        return inflater.inflate(R.layout.activity_fragment2, container, false);
    }

}

class SubActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2_detail);
    }
}