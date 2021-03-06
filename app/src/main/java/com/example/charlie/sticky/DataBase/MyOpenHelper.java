package com.example.charlie.sticky.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Charlie on 2019/1/10.
 */

/*
 * 重写了SQLiteOpenHelper类，用来建立数据库和表
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        super(context, "mydate", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table mybook(" +
                "ids integer PRIMARY KEY autoincrement," +
                "title text," +
                "content text," +
                "times text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

}

