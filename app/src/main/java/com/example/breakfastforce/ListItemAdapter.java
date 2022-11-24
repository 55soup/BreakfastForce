package com.example.breakfastforce;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListItemAdapter extends BaseAdapter {
    ArrayList<ListItem> items = new ArrayList<ListItem>();
    Context context;


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        ListItem listItem = items.get(position);

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);
        }

        TextView txtTitle = convertView.findViewById(R.id.title);
        TextView txtContent = convertView.findViewById(R.id.content);
        TextView txtDate = convertView.findViewById(R.id.date);
        CheckBox bookmark = convertView.findViewById(R.id.bookmark);

        txtTitle.setText(listItem.getTitle());
        txtContent.setText(listItem.getContent());
        txtDate.setText(listItem.getDate());

//        deleteItemCheckBox.setChecked(((ListView)parent).isItemChecked(position));
//        deleteItemCheckBox.setFocusable(false);
//        deleteItemCheckBox.setClickable(false);

        return convertView;
    }

    public void addItem(ListItem item){
        items.add(item);
    }

}
