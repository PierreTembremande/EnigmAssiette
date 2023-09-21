package com.example.enigmassiette;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enigmassiette.data.Bdd;
import com.example.enigmassiette.data.ContactBdd;
import com.example.enigmassiette.data.FakeData;

public class InitBdd extends AppCompatActivity {

    private static SQLiteDatabase mDb;
    public static void startBdd(Context context){
        Bdd dbHelper = new Bdd(context);
        mDb = dbHelper.getWritableDatabase();
        FakeData.insertFakeData(mDb);
    }

    public  static Cursor getAllGuests() {
        return mDb.query(
                ContactBdd.bddStat.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ContactBdd.bddStat.COLUMN_Time
        );

    }

    public static long addNewGuest(String nom, int dec, int nour, int ser, String desc) {
        ContentValues cv = new ContentValues();
        cv.put(ContactBdd.bddStat.COLUMN_NAME, nom);
        cv.put(ContactBdd.bddStat.COLUMN_NOTE_DECO, dec);
        cv.put(ContactBdd.bddStat.COLUMN_NOTE_NOURRITURE, nour);
        cv.put(ContactBdd.bddStat.COLUMN_NOTE_SERVICE, ser);
        cv.put(ContactBdd.bddStat.COLUMN_Desc, desc);
        return mDb.insert(ContactBdd.bddStat.TABLE_NAME, null, cv);
    }
}
