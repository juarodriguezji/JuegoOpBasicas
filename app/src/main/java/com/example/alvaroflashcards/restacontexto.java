package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class restacontexto extends AppCompatActivity {
    int resa;
    int resb ;
    int resul;
    TextView dresa;
    TextView dresb;
    int comodin;
    int sumuser;
    Button check;
    EditText respuestaresta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restacontexto);
        dresa=(TextView)findViewById(R.id.minuendo);
        dresb=(TextView) findViewById(R.id.sustraendo);
        check=(Button)findViewById(R.id.VALIDAR);
        respuestaresta=(EditText)findViewById(R.id.restauser) ;
        Random random   = new Random();
        resa=random.nextInt(10);
        comodin= random.nextInt(3);
        resb=random.nextInt(resa+comodin);
        dresa.setText(String.valueOf(resa));
        dresb.setText(String.valueOf(resb));
        resul=resa-resb;
        String ressta=respuestaresta.getText().toString();

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta();
            }
        });
    }
    private void comprobarRespuesta() {
        String ressta = respuestaresta.getText().toString();

        if (!ressta.isEmpty()) {
            int respuestaUsuario = Integer.parseInt(ressta);

            if (respuestaUsuario == resul) {
                Toast.makeText(restacontexto.this, "¡Correcto!", Toast.LENGTH_SHORT).show();
                generarNuevaSuma();
                respuestaresta.setText("");
            } else {
                Toast.makeText(restacontexto.this, "Incorrecto. Vuelve a intentarlo.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(restacontexto.this, "Por favor, ingresa una respuesta.", Toast.LENGTH_SHORT).show();
        }
    }
    private void generarNuevaSuma() {
        Random random   = new Random();
        resa=random.nextInt(10);
        resb=random.nextInt(resa+1);
        dresa.setText(String.valueOf(resa));
        dresb.setText(String.valueOf(resb));
        resul=resa-resb;


    }
}