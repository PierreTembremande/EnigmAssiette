package com.example.enigmassiette;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    Button ajout;
    Button all;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.ajout = (Button) findViewById(R.id.buttonAjout);
        this.all = (Button) findViewById(R.id.buttonALL);

        all.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(Main.this, All.class);
                startActivity(intent);

            }
        });

        ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main.this, Ajout.class);
                startActivity(intent);
            }
        });

    }

}
