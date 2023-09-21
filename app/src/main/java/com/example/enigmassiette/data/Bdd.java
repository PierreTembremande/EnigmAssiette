package com.example.enigmassiette.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import  com.example.enigmassiette.data.ContactBdd.*;


public class Bdd extends SQLiteOpenHelper {


        private static final String DATABASE_NAME = "NoteRestau.db";
        private static final int DATABASE_VERSION = 2;

        // Constructor
        public Bdd(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + bddStat.TABLE_NAME + " (" +
                    bddStat._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    bddStat.COLUMN_NAME+ " TEXT NOT NULL, " +
                    bddStat.COLUMN_Time+ " TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                    bddStat.COLUMN_NOTE_DECO+ " INTEGER NOT NULL, "+
                    bddStat.COLUMN_NOTE_NOURRITURE+ " INTEGER NOT NULL," +
                    bddStat.COLUMN_NOTE_SERVICE+ " INTEGER NOT NULL," +
                    bddStat.COLUMN_Desc + " TEXT NOT NULL " +
                    ");";

            sqLiteDatabase.execSQL(SQL_CREATE_WAITLIST_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + bddStat.TABLE_NAME);
            onCreate(sqLiteDatabase);
        }
}
