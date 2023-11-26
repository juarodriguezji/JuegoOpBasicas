package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class sumar extends AppCompatActivity {
    Button sumtxt;//Boton que lleva a sumar con texto
    Button sumvoic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar);
        sumtxt=(Button) findViewById(R.id.sumtxt);
        sumvoic=(Button)findViewById(R.id.sumvoic);
        sumtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sumar.this,sumacontexto.class));
            }

        });
        sumvoic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sumar.this,sumavoice.class));
            }
        });
    }


    }
