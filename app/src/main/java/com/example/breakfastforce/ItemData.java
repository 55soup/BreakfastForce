package com.example.breakfastforce;

import java.util.ArrayList;

public class ItemData {
    public String title_data;
    public String content_data;
    public String date_data;

    public ItemData(String date_data, String title_data, String content_data) {
        this.date_data = date_data;
        this.title_data = title_data;
        this.content_data = content_data;
    }


    public static ArrayList<ItemData> createContactsList(String date_data, String title_data, String content_data) {
        ArrayList<ItemData> contacs = new ArrayList<ItemData>();
        contacs.add(new ItemData(date_data ,title_data ,content_data));

        return contacs;
    }
}
