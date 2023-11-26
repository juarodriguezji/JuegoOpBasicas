package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class sumacontexto extends AppCompatActivity {
int suma;
int sumb ;
int resul;
TextView dsuma;
TextView dsumb;
int sumuser;
Button check;
EditText respuestasuma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumacontexto);
        dsuma=(TextView)findViewById(R.id.sumandoa);
        dsumb=(TextView) findViewById(R.id.sumandob);
        check=(Button)findViewById(R.id.verisuma);
        respuestasuma=(EditText)findViewById(R.id.sumuser) ;
        Random random   = new Random();
        suma=random.nextInt(10);
        sumb=random.nextInt(10);
        dsuma.setText(String.valueOf(suma));
        dsumb.setText(String.valueOf(sumb));
        resul=suma+sumb;
        String ressuma=respuestasuma.getText().toString();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta();
            }
        });
    }
    private void comprobarRespuesta() {
        String ressuma = respuestasuma.getText().toString();

        if (!ressuma.isEmpty()) {
            int respuestaUsuario = Integer.parseInt(ressuma);

            if (respuestaUsuario == resul) {
                Toast.makeText(sumacontexto.this, "¡Correcto!", Toast.LENGTH_SHORT).show();
                generarNuevaSuma();
                respuestasuma.setText("");
            } else {
                Toast.makeText(sumacontexto.this, "Incorrecto. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(sumacontexto.this, "Por favor, ingresa una respuesta.", Toast.LENGTH_SHORT).show();
        }
    }
    private void generarNuevaSuma() {
        Random random = new Random();

        // Generar dos números aleatorios de 0 a 9
        suma=random.nextInt(10);
        sumb=random.nextInt(10);
        dsuma.setText(String.valueOf(suma));
        dsumb.setText(String.valueOf(sumb));

        // Calcular la respuesta correcta
        resul = suma + sumb;


    }
}