package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button sumact;
    private Button restact;
    private Button multact;
    private Button divact;
    private Button aleact;
    private TextView textintro;
    private TextView txtsum;
    private TextView txtres;
    private TextView txtmult;
    private TextView txtdiv;
    private TextView txtaleat;

    TTSManager ttsManager=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        ttsManager=new TTSManager();
        ttsManager.init(this);

        textintro=findViewById(R.id.maintxt);
        sumact=findViewById(R.id.bsuma);
        restact=findViewById(R.id.bresta);
        multact=findViewById(R.id.bmulti);


        sumact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=textintro.getText().toString();
                text=text+"Has hecho click en el botón que te llevará a los ejercicios de operación suma.En estos ejercicios el sistema te realizará preguntas al azar con números de un dígito ,por favor selecciona si prefieres el modulo con reconocimiento de voz o con entrada de texto";
                ttsManager.initQueue(text);
                startActivity(new Intent(MainActivity.this,sumar.class));
            }

        });

        restact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=textintro.getText().toString();

                text=text+"Has hecho click en el botón que te llevará a los ejercicios de la operación resta.En estos ejercicios el sistema te realizará preguntas al azar con números de un dígito ,por favor selecciona si prefieres el modulo con reconocimiento de voz o con entrada de texto.";
                ttsManager.initQueue(text);
                startActivity(new Intent(MainActivity.this,restar.class));
            }

        });

        multact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text=textintro.getText().toString();
                text=text+"Has hecho click en el botón que te llevará a los ejercicios de la operación multiplicación.En estos ejercicios el sistema te realizará preguntas al azar con números de un dígito ,por favor selecciona si prefieres el modulo con reconocimiento de voz o con entrada de texto";
                ttsManager.initQueue(text);
                startActivity(new Intent(MainActivity.this,multiplicar.class));
            }

        });






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ttsManager.shutDown();
    }
}