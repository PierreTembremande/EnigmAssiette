package com.example.enigmassiette;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.enigmassiette.data.ContactBdd;

public class Ajout extends AppCompatActivity {
    private EditText nom;
    private EditText deco;
    private EditText nourriture;
    private EditText service;
    private EditText description  ;

    int recupDeco;
    int recupNour;

    int recupSer;

    Button aj;
    Button retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        this.aj = (Button) findViewById(R.id.button);
        this.retour=(Button) findViewById(R.id.buttonRetour) ;
        nom = (EditText) this.findViewById(R.id.EditNom);
        deco = (EditText) this.findViewById(R.id.EditDeco);
        nourriture = (EditText) this.findViewById(R.id.EditNourriture);
        service = (EditText) this.findViewById(R.id.EditService);
        description = (EditText) this.findViewById(R.id.EditService);

        aj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                    recupDeco = Integer.parseInt(deco.getText().toString());
                    recupNour = Integer.parseInt(nourriture.getText().toString());
                    recupSer = Integer.parseInt( service.getText().toString());
                }catch(Error e){};
                InitBdd.addNewGuest(nom.getText().toString(),recupDeco,recupNour,recupSer,description.getText().toString());

                nom.getText().clear();
                deco.getText().clear();
                nourriture.getText().clear();
                service.getText().clear();
                description.getText().clear();
            }
        });

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Ajout.this, Main.class);
                startActivity(intent);
            }
        });

    }


}
