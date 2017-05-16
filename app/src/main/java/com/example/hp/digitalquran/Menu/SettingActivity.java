package com.example.hp.digitalquran.Menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.digitalquran.R;

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
        MenuObject menuObject=new MenuObject();
        menuObject.setFontSize(Finalsize);
        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                size = textSize.getSelectedItem().toString().trim();
                if(size.equals("Small")){
                    Finalsize=15;
                }else if(size.equals("Normal")){
                    Finalsize=20;
                }else if(size.equals("large")){
                    Finalsize=25;
                }else if(size.equals("Very Large")){
                    Finalsize=30;
                }else{
                    Finalsize=18;
                    Toast.makeText(SettingActivity.this, "Please Select Text Size", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
