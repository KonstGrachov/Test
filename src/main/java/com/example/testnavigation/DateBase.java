package com.example.testnavigation;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DateBase extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="testtablse";
    public static final int DATABASE_VERSION=1;
    public static final String TABLE_NAME="massive";
    public static final String KEY_ID="_id";
    public static final String KEY_NAME="name";
    public static final String KEY_NUMBER="number";
    public DateBase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table if not exists "+TABLE_NAME+"( " +KEY_ID+" integer primary key, "+KEY_NAME+" text, "+KEY_NUMBER+" number"+" )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
