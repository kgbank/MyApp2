package com.example.user.myapp2.group;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by USER on 2016-06-18.
 */
public class GroupDBHelper extends SQLiteOpenHelper {
    public GroupDBHelper(Context context) {
//        public GroupDBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "hanbitDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "DROP TABLE IF EXISTS girl_group;");
        db.execSQL( "CREATE TABLE girl_group( _id INTEGER PRIMARY KEY, name TEXT, num INTERGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( "DROP TABLE IF EXISTS girl_group;");
//        db.execSQL( "TRUNCATE TABLE girl_group;");
        this.onCreate(db);

    }
}
