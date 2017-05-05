package com.example.hp.digitalquran.Database;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;

public class DbBackend extends DbObject {
    public DbBackend(Context context) {
        super(context);
    }

    public String[] surah_names() {
        String query = "Select * from Surah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> surah_names_array = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String surah_name = cursor.getString(cursor.getColumnIndexOrThrow("names"));
                surah_names_array.add(surah_name);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] surah_arabic_names = new String[surah_names_array.size()];
        surah_arabic_names = surah_names_array.toArray(surah_arabic_names);
        return surah_arabic_names;
    }
    public String[] surah_roman() {
        String query = "Select * from Surah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> surah_roman_array = new ArrayList<String>();
        if (cursor.moveToFirst()) {
            do {
                String roman = cursor.getString(cursor.getColumnIndexOrThrow("roman"));
                surah_roman_array.add(roman);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] surah_roman = new String[surah_roman_array.size()];
        surah_roman = surah_roman_array.toArray(surah_roman);
        return surah_roman;
    }
    public String[] surah_No() {
        String query = "Select * from Surah_Names";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        ArrayList<String> surah_roman_array = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String no = cursor.getString(cursor.getColumnIndexOrThrow("_id"));
                surah_roman_array.add(no);
            } while (cursor.moveToNext());
        }
        cursor.close();
        String[] surah_number = new String[surah_roman_array.size()];
        surah_number = surah_roman_array.toArray(surah_number);
        return surah_number;
    }
    public SurahObject getSurahById(int surahId){

        SurahObject surahObject = null;
        String query = "select * from Surah_Names where _id = " + surahId;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String surah_name = cursor.getString(cursor.getColumnIndexOrThrow("names"));
                int type = cursor.getInt(cursor.getColumnIndexOrThrow("boltype"));
                String roman = cursor.getString(cursor.getColumnIndexOrThrow("roman"));
                surahObject = new SurahObject(surah_name, type,roman);
            }while(cursor.moveToNext());
        }
        cursor.close();
        return surahObject;
    }
}
