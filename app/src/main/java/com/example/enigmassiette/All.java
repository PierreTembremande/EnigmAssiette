package com.example.enigmassiette;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enigmassiette.data.Bdd;
import com.example.enigmassiette.data.ContactBdd;
import com.example.enigmassiette.data.FakeData;
import com.example.enigmassiette.InitBdd.*;

public class All extends AppCompatActivity{


    private TextView nom;
    private TextView deco;
    private TextView nourriture;
    private TextView service;
    private TextView description;

    String n ="";
    String d ="";
    String m ="";
    String s ="";
    String c ="";

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);

        nom = (TextView) this.findViewById(R.id.Nom);
        deco = (TextView) this.findViewById(R.id.Deco);
        nourriture = (TextView) this.findViewById(R.id.Nourrriture);
        service = (TextView) this.findViewById(R.id.Service);
        description = (TextView) this.findViewById(R.id.Description);



        Cursor cursor = InitBdd.getAllGuests();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            n = n + cursor.getString(cursor.getColumnIndex(ContactBdd.bddStat.COLUMN_NAME))+"\n";
            Log.e()
            nom.setText(n);
            d = d + cursor.getString(cursor.getColumnIndex(ContactBdd.bddStat.COLUMN_NOTE_DECO))+"\n";
            deco.setText(d);
            m = m + cursor.getString(cursor.getColumnIndex(ContactBdd.bddStat.COLUMN_NOTE_NOURRITURE))+"\n";
            nourriture.setText(m);
            s=s+cursor.getString(cursor.getColumnIndex(ContactBdd.bddStat.COLUMN_NOTE_SERVICE))+"\n";
            service.setText(s);
            c=c+cursor.getString(cursor.getColumnIndex(ContactBdd.bddStat.COLUMN_Desc))+"\n";
            description.setText(c);
        }

    }


}
