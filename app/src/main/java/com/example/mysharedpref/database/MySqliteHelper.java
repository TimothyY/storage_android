package com.example.mysharedpref.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqliteHelper extends SQLiteOpenHelper {

    static String DB_NAME = "cobasqlite";
    static int DB_VERSION = 1;

    public MySqliteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    String TABLE_MS_SONG = "msSong";
    String FIELD_MS_SONG_TITLE = "title";
    String FIELD_MS_SONG_ARTIST = "artist";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qCreateMsSong =
                "CREATE TABLE IF NOT EXISTS '"+ TABLE_MS_SONG +"' (\n" +
                        "\t'"+FIELD_MS_SONG_TITLE+"'\tTEXT,\n" +
                        "\t'"+FIELD_MS_SONG_ARTIST+"'\tTEXT\n" +
                        ");";
        db.execSQL(qCreateMsSong);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
