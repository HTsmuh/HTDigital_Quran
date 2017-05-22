package com.example.hp.digitalquran;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.hp.digitalquran.Adapter.TranslationAdapter;
import com.example.hp.digitalquran.Database.DbBackend;
import java.util.Arrays;

public class SurahText extends AppCompatActivity {
    TextView quranText;
    ImageView bismillah;
    ImageView bismillah2;
    Typeface tf;
    ViewGroup header;
    int num;
    int index;
    Button translation;
    ListView SurahTextList;
    boolean isTranslate=false;
    TranslationAdapter listAdapter;
    ScrollView SurahTextScroll;
    DbBackend db;
    String[] text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        db=new DbBackend(SurahText.this);
        if (db.getMode().equals("DayMoodFullScreen")) {
            setTheme(R.style.DayMoodFullScreen);
        }else {
            setTheme(R.style.NightMoodFullScreen);
        }
        setContentView(R.layout.activity_surah_text);

        translation= (Button) findViewById(R.id.translate);
        SurahTextList= (ListView) findViewById(R.id.surahtextlist);

        LayoutInflater inflater = getLayoutInflater();
        header = (ViewGroup)inflater.inflate(R.layout.translation_header, SurahTextList , false);
        SurahTextList .addHeaderView(header, null, false);
        SurahTextScroll= (ScrollView) findViewById(R.id.surahtextscroll);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_surah_text);
        Resources res = getResources();
        Drawable portrait = res.getDrawable(R.drawable.portrait);
        Drawable landscape = res.getDrawable(R.drawable.landscape);

        WindowManager window = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        num = display.getRotation();
        if (num == 0){
            relativeLayout.setBackgroundDrawable(portrait);
        }else if (num == 1 || num == 3){
            relativeLayout.setBackgroundDrawable(landscape);
        }else{
            relativeLayout.setBackgroundDrawable(portrait);
        }
        quranText= (TextView) findViewById(R.id.surah_text);
        if (db.getSize().equals("Small")){
            quranText.setTextSize(15);
        }else if (db.getSize().equals("Normal")){
            quranText.setTextSize(20);
        }else if (db.getSize().equals("Large")){
            quranText.setTextSize(25);
        }else if (db.getSize().equals("Extra Large")){
            quranText.setTextSize(30);
        }
        tf = Typeface.createFromAsset(getAssets(), "fonts/"+db.getScript()+".ttf");
        quranText.setTypeface(tf);
        bismillah= (ImageView) findViewById(R.id.bismillahimage);
        bismillah2= (ImageView) findViewById(R.id.bismillah2);
        if (db.getMode().equals("DayMoodFullScreen")) {
            bismillah.setImageResource(R.drawable.bismillah_daymod);
            bismillah2.setImageResource(R.drawable.bismillah_daymod);
        }else {
            bismillah.setImageResource(R.drawable.bismillah_nightmod);
            bismillah2.setImageResource(R.drawable.bismillah_nightmod);
        }
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        index = bundle.getInt("Surah_Number");
        db=new DbBackend(SurahText.this);
        if (index==9){
            bismillah.setVisibility(View.INVISIBLE);
        }
        if (db.getScript().equals("pdms")) {
            text = db.Surah_Text_pdms(index);
        }else {
            text = db.Surah_Text_me_quran(index);
        }
        String finalize = Arrays.toString(text).replaceAll(",","");
        String finalize1 = finalize.replaceAll("\\[","");
        String finalize2 = finalize1.replaceAll("\\]","");

        String[] arabic_text = db.Surah_Ayat_Text(index);
        String[] translation_text = db.Surah_Translation_Text(index);
        listAdapter = new TranslationAdapter(this,translation_text,arabic_text);
        quranText.setText(finalize2);
        translation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isTranslate){
                    translation.setText("HIDE TRANSLATION");
                    isTranslate=true;
                    quranText.setVisibility(View.INVISIBLE);
                    SurahTextScroll.setVisibility(View.INVISIBLE);
                    SurahTextList.setVisibility(View.VISIBLE);
                    SurahTextList.setAdapter(listAdapter);
                    if (index==9){
                        header.findViewById(R.id.bismillah2).setVisibility(View.INVISIBLE);
                    }
                }else{
                    translation.setText("SHOW TRANSLATION");
                    isTranslate=false;
                    quranText.setVisibility(View.VISIBLE);
                    SurahTextScroll.setVisibility(View.VISIBLE);
                    SurahTextList.setVisibility(View.INVISIBLE);
                }
            }


        });
    }



}