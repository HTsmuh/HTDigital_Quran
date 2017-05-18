package com.example.hp.digitalquran.Menu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.hp.digitalquran.R;

public class SettingActivity extends AppCompatActivity {
    Spinner textSize;
    Spinner displayMode;
    Spinner textScript;
    Button setting_button;
    String size;
    String mode;
    String script;
    int Finalsize;
    String Finalmode;
    String Finalscript;
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        textSize = (Spinner) findViewById(R.id.text_size);
        displayMode= (Spinner) findViewById(R.id.display_mode);
        textScript= (Spinner) findViewById(R.id.text_script);
        setting_button = (Button) findViewById(R.id.setting_btn);
        layout= (LinearLayout) findViewById(R.id.settingLayout);

        size = textSize.getSelectedItem().toString().trim();
        mode = displayMode.getSelectedItem().toString().trim();
        script = textScript.getSelectedItem().toString().trim();

        setting_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (size.equals("Small")) {
                        Finalsize = 15;
                    } else if (size.equals("Normal")) {
                        Finalsize = 20;
                    } else if (size.equals("Large")) {
                        Finalsize = 25;
                    } else if (size.equals("Extra Large")) {
                        Finalsize = 30;
                    } else if (mode.equals("Day Mode")) {
                        layout.setBackgroundColor(Color.BLACK);
                    } else if (mode.equals("Night Mode")) {
                        Finalmode = "@color/colorPrimaryDark";
                    } else if (script.equals("Me Quran")) {
                        Finalscript = "me_quran";
                    } else if (script.equals("PDMS Saleem")) {
                        Finalscript = "pdms";
                    }
            }
        });
    }
}