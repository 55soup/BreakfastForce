package com.example.breakfastforce;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.utils.widget.ImageFilterButton;
import androidx.fragment.app.Fragment;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class Fragment1 extends Fragment {
    FloatingActionButton fab_btn;

    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.activity_fragment1, container, false);
        fab_btn = v.findViewById(R.id.fab_btn);
        fab_btn = (FloatingActionButton) v.findViewById(R.id.fab_btn);
        fab_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplication(), BookmarksActivity.class);
                startActivity(intent);
            }
        });

        return v;

    }
}