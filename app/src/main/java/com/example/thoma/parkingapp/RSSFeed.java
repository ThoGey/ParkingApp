package com.example.thoma.parkingapp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by thoma on 11/16/2015.
 */
public class RSSFeed {

    private ArrayList<RSSItem> items;

    public RSSFeed() {
        items = new ArrayList<RSSItem>();
    }


    public int addItem(RSSItem item) {
        items.add(item);
        return items.size();
    }

    public RSSItem getItem(int index) {
        return items.get(index);
    }

    public ArrayList<RSSItem> getAllItems() {
        return items;
    }
}
