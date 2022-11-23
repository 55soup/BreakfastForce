package com.example.breakfastforce;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardViewAdaper extends RecyclerView.Adapter<CardViewAdaper.Holder> {

    private Context context;
    private List<ItemData> list = new ArrayList<>();

    public CardViewAdaper(Context context, List<ItemData> list) {
        this.context = context;
        this.list = list;
    }

    // ViewHolder 생성
    // row layout을 화면에 뿌려주고 holder에 연결
    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cardview_diary, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

//    ViewHolder에 data 삽입 ListView의 getView와 동일
    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // 각 위치에 문자열 세팅
        int itemposition = position;
        holder.date.setText(list.get(itemposition).date_data);
        holder.title.setText(list.get(itemposition).title_data);
        holder.content.setText(list.get(itemposition).content_data);
    }

    @Override
    // 몇개의 데이터를 리스트로 뿌려줘야하는지 반드시 정의해줘야한다
    public int getItemCount() {
        return list.size(); // RecyclerView의 size return
    }

    // ViewHolder는 하나의 View를 보존하는 역할을 한다
    public class Holder extends RecyclerView.ViewHolder{
        public TextView date;
        public TextView title;
        public TextView content;

        public Holder(View view){
            super(view);
            date = (TextView) view.findViewById(R.id.date);
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
        }
    }

}
