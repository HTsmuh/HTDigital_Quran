package com.example.hp.digitalquran.Fragments;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hp.digitalquran.R;

public class SingleRow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_row);

        TextView myTextView = (TextView) findViewById(R.id.text1);
        Typeface typeface= Typeface.createFromAsset(getAssets(), "fonts/pdms.ttf");
        myTextView.setTypeface(typeface);
    }
}
