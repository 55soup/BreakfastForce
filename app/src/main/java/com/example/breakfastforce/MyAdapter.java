package com.example.breakfastforce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<ListItem> list;
    ArrayList<ListItem> checkedList = new ArrayList<>();

    public MyAdapter(Context c, ArrayList<ListItem> list) {
        this.c = c;
        this.list = list;
    }

    // 뷰 홀더는 인이니셜라이즈드
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_bookmarks, null);
        MyHolder holder = new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(list.get(position).getTitle());
        holder.content.setText(list.get(position).getContent());
        holder.date.setText(list.get(position).getDate());

        holder.setItemClickListener(new itemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                CheckBox chk = (CheckBox) v;

                // chk if ths checked or not
                if (chk.isChecked()) {
                    checkedList.add(list.get(pos));
                } else if(!chk.isChecked()) {
                    checkedList.remove(list.get(pos));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
