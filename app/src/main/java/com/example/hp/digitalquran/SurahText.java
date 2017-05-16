package com.example.hp.digitalquran;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
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
import com.example.hp.digitalquran.Menu.MenuObject;
import com.example.hp.digitalquran.Menu.SettingActivity;

import java.util.Arrays;

public class SurahText extends AppCompatActivity {
    TextView quranText;
    ImageView bismillah;
    Typeface tf;
    Button translation;
    ListView SurahTextList;
    boolean isTranslate=false;
    TranslationAdapter listAdapter;
    ScrollView SurahTextScroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_text);
        translation= (Button) findViewById(R.id.translate);
        SurahTextList= (ListView) findViewById(R.id.surahtextlist);
        SurahTextScroll= (ScrollView) findViewById(R.id.surahtextscroll);
        RelativeLayout relativeLayout = (RelativeLayout)findViewById(R.id.activity_surah_text);
        Resources res = getResources();
        Drawable portrait = res.getDrawable(R.drawable.portrait);
        Drawable landscape = res.getDrawable(R.drawable.landscape);

        WindowManager window = (WindowManager)getSystemService(WINDOW_SERVICE);
        Display display = window.getDefaultDisplay();
        int num = display.getRotation();
        if (num == 0){
            relativeLayout.setBackgroundDrawable(portrait);
        }else if (num == 1 || num == 3){
            relativeLayout.setBackgroundDrawable(landscape);
        }else{
            relativeLayout.setBackgroundDrawable(portrait);
        }
        quranText= (TextView) findViewById(R.id.quran_text);
        tf = Typeface.createFromAsset(getAssets(), "fonts/pdms.ttf");
        quranText.setTypeface(tf);

        bismillah= (ImageView) findViewById(R.id.bismillah);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int index = bundle.getInt("Surah_Number");
        DbBackend db=new DbBackend(SurahText.this);
        if (index==9){
            bismillah.setVisibility(View.INVISIBLE);
        }

        final MenuObject menuObject=new MenuObject();

        String[] text = db.Surah_Text(index);
        String finalize = Arrays.toString(text).replaceAll(",","");
        String finalize1 = finalize.replaceAll("\\[","");
        String finalize2 = finalize1.replaceAll("\\]","");

        String[] arabic_text = db.Ayat_Text(index);
        String[] translation_text = db.Translation_Text(index);
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