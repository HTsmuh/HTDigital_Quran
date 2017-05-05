package com.example.hp.digitalquran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.hp.digitalquran.Database.DbBackend;
import com.example.hp.digitalquran.Database.MyAdapter;

import java.util.Arrays;

public class Home extends AppCompatActivity {
    ListView itemList;
    MyAdapter listAdapter;
    int[] typeimage={R.drawable.makki,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.madni,R.drawable.makki,R.drawable.makki,R.drawable.makki,R.drawable.makki};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        itemList = (ListView)findViewById(R.id.listView);
        DbBackend dbBackend = new DbBackend(Home.this);
        String[] surah_Number = dbBackend.surah_No();
        String[] surah_arabic_names = dbBackend.surah_names();
        String[] surah_roman_names = dbBackend.surah_roman();
        listAdapter = new MyAdapter(this,surah_Number,surah_arabic_names,surah_roman_names,typeimage);

        itemList.setAdapter(listAdapter);
    }
}
