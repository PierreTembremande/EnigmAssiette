package com.example.enigmassiette.data;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class FakeData {

        public static void insertFakeData(SQLiteDatabase db){
            if(db == null){
                return;
            }
            //create a list of fake guests
            List<ContentValues> list = new ArrayList<ContentValues>();

            ContentValues cv = new ContentValues();
            cv.put(ContactBdd.bddStat.COLUMN_NAME, "John");
            cv.put(ContactBdd.bddStat.COLUMN_NOTE_DECO,2);
            cv.put(ContactBdd.bddStat.COLUMN_NOTE_NOURRITURE,9);
            cv.put(ContactBdd.bddStat.COLUMN_NOTE_SERVICE,9);
            cv.put(ContactBdd.bddStat.COLUMN_Desc,"Bruh");
            list.add(cv);

            cv = new ContentValues();
            cv.put(ContactBdd.bddStat.COLUMN_NAME, "Doe");
            cv.put(ContactBdd.bddStat.COLUMN_NOTE_DECO,9);
            cv.put(ContactBdd.bddStat.COLUMN_NOTE_NOURRITURE,8);
            cv.put(ContactBdd.bddStat.COLUMN_NOTE_SERVICE,2);
            cv.put(ContactBdd.bddStat.COLUMN_Desc,"Os court");
            list.add(cv);

            try
            {
                db.beginTransaction();
                db.delete (ContactBdd.bddStat.TABLE_NAME,null,null);
                for(ContentValues c:list){
                    db.insert(ContactBdd.bddStat.TABLE_NAME, null, c);
                }
                db.setTransactionSuccessful();
            }
            catch (SQLException e) {
                //too bad :(
            }
            finally
            {
                db.endTransaction();
            }

        }
}
