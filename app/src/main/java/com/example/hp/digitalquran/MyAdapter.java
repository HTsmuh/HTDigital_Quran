package com.example.hp.digitalquran;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by HP on 5/3/2017.
 */

public class MyAdapter extends ArrayAdapter<String> {
    public Context context;
    public String[] surah_arabic_array;
    public String[] surah_type_array;

    public MyAdapter(Context context,String[] surah_arabic,String[] surah_types) {
        super(context,R.layout.single_row_activity,R.id.text1,surah_arabic);
        this.context=context;
        this.surah_arabic_array=surah_arabic;
        this.surah_type_array=surah_types;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.single_row_activity,parent,false);
        TextView name= (TextView) row.findViewById(R.id.text1);
        TextView type= (TextView) row.findViewById(R.id.text2);
        ImageView imagetype= (ImageView) row.findViewById(R.id.image1);
        name.setText(surah_arabic_array[position]);
        type.setText(surah_type_array[position]);
        imagetype.setImageResource(R.drawable.makki);
            return row;
    }
}
