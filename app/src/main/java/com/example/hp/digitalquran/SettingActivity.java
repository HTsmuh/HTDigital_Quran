package com.example.hp.digitalquran;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {
    Spinner textSize;
    Button setting_button;
    String size;
    int Finalsize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        textSize = (Spinner) findViewById(R.id.text_size);
        setting_button = (Button) findViewById(R.id.setting_btn);

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = textSize.getSelectedItem().toString().trim();
                Toast.makeText(SettingActivity.this, "Setting Changed to " + size, Toast.LENGTH_SHORT).show();
            }
        });
    }
        public void TextSize(){
                if(size.equals("Small")){
                    Finalsize=15;
                }else if(size.equals("Normal")){
                    Finalsize=20;
                }else if(size.equals("large")){
                    Finalsize=25;
                }else if(size.equals("Very Large")){
                    Finalsize=30;
                }
        }
}
