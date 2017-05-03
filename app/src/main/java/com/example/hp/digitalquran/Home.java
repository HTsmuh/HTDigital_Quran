package com.example.hp.digitalquran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class Home extends AppCompatActivity {
    ListView itemList;
    MyAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        itemList = (ListView)findViewById(R.id.listView);
        DbBackend dbBackend = new DbBackend(Home.this);
        String[] surah_arabic_names = dbBackend.surah_names();
        String[] surah_types = dbBackend.surah_types();
        String[] surah_roman_names = dbBackend.surah_roman();
        listAdapter = new MyAdapter(this,surah_arabic_names,surah_roman_names);

        itemList.setAdapter(listAdapter);
    }
}
