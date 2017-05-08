package com.example.hp.digitalquran.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.digitalquran.Adapter.ParaNameAdapter;
import com.example.hp.digitalquran.Database.DbBackend;
import com.example.hp.digitalquran.ParaText;
import com.example.hp.digitalquran.SurahText;
import com.example.hp.digitalquran.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ParaFragment extends Fragment {
    ListView itemList;
    ParaNameAdapter listAdapter;

    public ParaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView=inflater.inflate(R.layout.fragment_para, container, false);

        itemList = (ListView)myView.findViewById(R.id.listView);
        DbBackend dbFragment=new DbBackend(getContext());

        String[] para_numbers = dbFragment.para_No();
        String[] para_names = dbFragment.para_arabic();
        String[] para_roman_names = dbFragment.para_roman();

        listAdapter = new ParaNameAdapter(getContext(),para_numbers,para_names,para_roman_names);

        itemList.setAdapter(listAdapter);
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ParaText.class);
                int index=position+1;
                intent.putExtra("Para_Number", index);
                startActivity(intent);
            }
        });

        return myView;

    }

}
