package com.example.hp.digitalquran.Fragments;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.example.hp.digitalquran.Database.MyAdapter;
import com.example.hp.digitalquran.Database.SurahNameDatabase;
import com.example.hp.digitalquran.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SurahFragment extends Fragment {
    ListView itemList;
    SQLiteDatabase cursor;
    MyAdapter listAdapter;
    ArrayList<String> surah_names_array;
    SQLiteDatabase sqLiteDatabase;
    public SurahFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView=inflater.inflate(R.layout.fragment_surah, container, false);
        // Inflate the layout for this fragment
        itemList = (ListView) myView.findViewById(R.id.listView);
        surah_names_array = new ArrayList<String>();

        SurahNameDatabase db = new SurahNameDatabase(getContext());
        sqLiteDatabase = db.getReadableDatabase();

        return myView;

    }

}
