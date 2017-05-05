package com.example.hp.digitalquran.Database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class SurahNameDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAMES = "QURAN_db";
    private static final int DATABASE_VERSION = 1;

    public SurahNameDatabase(Context context) {
        super(context, DATABASE_NAMES, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

}
