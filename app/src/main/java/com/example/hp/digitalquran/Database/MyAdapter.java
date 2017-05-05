package com.example.hp.digitalquran.Database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.hp.digitalquran.R;

/**
 * Created by HP on 5/3/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {
    public Context context;
    public String[] surah_no_array;
    public String[] surah_arabic_array;
    public String[] surah_roman_array;
    public int[] surah_type_images;

    public MyAdapter(Context context, String[] surah_no, String[] surah_arabic, String[] surah_roman,int[] surah_type) {
        super(context, R.layout.single_row_activity,R.id.text1,surah_arabic);
        this.context=context;
        this.surah_no_array=surah_no;
        this.surah_arabic_array=surah_arabic;
        this.surah_roman_array=surah_roman;
        this.surah_type_images=surah_type;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row_activity,parent,false);
        TextView arabic= (TextView) row.findViewById(R.id.text1);
        TextView roman= (TextView) row.findViewById(R.id.text2);
        TextView number= (TextView) row.findViewById(R.id.text3);
        ImageView imagetype= (ImageView) row.findViewById(R.id.image1);
        arabic.setText(surah_arabic_array[position]);
        roman.setText(surah_roman_array[position]);
        number.setText(surah_no_array[position]);
        imagetype.setImageResource(surah_type_images[position]);
        return row;
    }
}