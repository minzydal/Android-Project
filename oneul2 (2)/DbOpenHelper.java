package com.example.oneul2;

/**
 * Created by DowonYoon on 2017-06-21.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DbOpenHelper extends SQLiteOpenHelper implements BaseColumns {
    public static final String TABLENAME = "oneul";
    private static final int DBver = 1;

    public DbOpenHelper(Context context){
        super(context, TABLENAME, null, DBver);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String CONTENTS = "contents";
        final String EMOTION = "emotion";
        final String DATE = "date";
        String query = "create table if not exists "+TABLENAME+"("
                +_ID+" integer primary key autoincrement, "
                +CONTENTS+" text not null , "
                +EMOTION+" inteager not null , "
                +DATE+" text not null );";

        db.execSQL(query);
//        "INSERT INTO "+TABLENAME+" VALUES ("+"'"+ CONTENTS +"'"+", " + "'" + EMOTION + "'" + ", " + "'" + DATE + "';"
    }

    public void queryToDb(SQLiteDatabase db, String query){
        db.execSQL(query);
    }

    public String insertToQuery(String contents, int emotion, String date){
        String query = "INSERT INTO "+TABLENAME+" VALUES (NULL,"+"'"+ contents +"'"+", " + "'" + emotion + "'" + ", " + "'" + date + "');";
        return query;
    }

    public void deleteAll(SQLiteDatabase db){
        db.execSQL("delete from "+ TABLENAME);
    }

    public ArrayList<Emotion> recentlyRecords(SQLiteDatabase db, String query){
        ArrayList<Emotion> result = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);
        Emotion e = new Emotion();

        while(c.moveToNext()){
            int id;
            String contents;
            int emotion;
            String date;

            id = c.getInt(0);
            contents = c.getString(1);
            emotion = c.getInt(2);
            date = c.getString(3);

            e = new Emotion(id, contents, emotion, date);
            result.add(e);
        }
        //id / contents / emotion / date
        Collections.sort(result);

        return result;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
    }
}