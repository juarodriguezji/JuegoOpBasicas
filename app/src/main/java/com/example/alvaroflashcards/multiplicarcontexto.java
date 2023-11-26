package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class multiplicarcontexto extends AppCompatActivity {
    int multa;
    int multb ;
    int resul;
    TextView dmula;
    TextView dmulb;
    int multuser;
    Button check;
    EditText respuestamul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicarcontexto);
        dmula=(TextView) findViewById(R.id.mula);
        dmulb=(TextView) findViewById(R.id.mulb);
        check=(Button) findViewById(R.id.multival);
        respuestamul=(EditText) findViewById(R.id.poruser);
        Random random   = new Random();
        multa=random.nextInt(10);
        multb=random.nextInt(10);
        dmula.setText(String.valueOf(multa));
        dmulb.setText(String.valueOf(multb));
        resul=multa*multb;
        String ressuma=respuestamul.getText().toString();
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta();
            }
        });
    }
    private void comprobarRespuesta() {
        String ressuma = respuestamul.getText().toString();

        if (!ressuma.isEmpty()) {
            int respuestaUsuario = Integer.parseInt(ressuma);

            if (respuestaUsuario == resul) {
                Toast.makeText(multiplicarcontexto.this, "¡Correcto!", Toast.LENGTH_SHORT).show();
                generarNuevaSuma();
                respuestamul.setText("");
            } else {
                Toast.makeText(multiplicarcontexto.this, "Incorrecto. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(multiplicarcontexto.this, "Por favor, ingresa una respuesta.", Toast.LENGTH_SHORT).show();
        }
    }
    private void generarNuevaSuma() {
        Random random   = new Random();
        multa=random.nextInt(10);
        multb=random.nextInt(10);
        dmula.setText(String.valueOf(multa));
        dmulb.setText(String.valueOf(multb));
        resul=multa*multb;


    }
}