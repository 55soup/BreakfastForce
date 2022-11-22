package com.example.breakfastforce;

import java.util.ArrayList;

public class ItemData {
    public String title_data;
    public String content_data;

    public ItemData(String title_data, String content_data) {
        this.title_data = title_data;
        this.content_data = content_data;
    }


    public static ArrayList<ItemData> createContactsList(int numContacts) {
        ArrayList<ItemData> contacs = new ArrayList<ItemData>();

        for(int i = 0; i <= numContacts; i++) {
            contacs.add(new ItemData("오늘의 맘마!!!!", "흑흑... 너무 맛잇어... 근데 내일 아침은 귀찮으니까 안 먹어야징~~~ 이라고 했다간 개발자한테 후두리맞겟지?ㅎㅎ"));
        }

        return contacs;
    }
}
