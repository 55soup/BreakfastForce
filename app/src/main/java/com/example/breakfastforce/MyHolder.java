package com.example.breakfastforce;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    TextView title, content, date;
    CheckBox bookmark;

    itemClickListener itemClickListener;

    public MyHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.title);
        content = (TextView) itemView.findViewById(R.id.content);
        date = (TextView) itemView.findViewById(R.id.date);
        bookmark = (CheckBox) itemView.findViewById(R.id.bookmark);

        bookmark.setOnClickListener(this);

    }

    public void setItemClickListener(itemClickListener ic) {
        this.itemClickListener = ic;
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClick(v, getLayoutPosition());
    }
}
