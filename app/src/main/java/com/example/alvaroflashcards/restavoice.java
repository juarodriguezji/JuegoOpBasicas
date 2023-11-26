package com.example.alvaroflashcards;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class restavoice extends AppCompatActivity {

    TTSManager ttsManager=null;
    private static final int SPEECH_REQUEST_CODE = 0;
    int sumav;
    int comodin;
    int sumbv ;
    int resumv;
    TextView resmulvoic;
    int multuser;
    Button check;
    String text;
    Button starter;
    ImageButton microfono;
    int resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restavoice);
        Random random = new Random();
        comodin=random.nextInt(3);
        sumav = random.nextInt(10);
        sumbv = random.nextInt(sumav+comodin);
        resul=sumav-sumbv;
        starter = (Button) findViewById(R.id.inimulv);
        check = (Button) findViewById(R.id.validamulv);
        resmulvoic=(TextView)findViewById(R.id.mulvoxtxt);
        microfono = (ImageButton) findViewById(R.id.micromul);
        ttsManager = new TTSManager();
        ttsManager.init(this);

        starter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text = "Estás en el modulo de la operación resta la operación que debes hacer es" + sumav + "menos " + sumbv;
                ttsManager.initQueue(text);
            }
        });

        microfono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking");
                try{
                    startActivityForResult(intent, 100);
                }
                catch(ActivityNotFoundException a){
                    System.exit(0);

                }
            }

        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                comprobarRespuesta();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100 && resultCode == RESULT_OK){
            resmulvoic.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
        }
    }
    private void comprobarRespuesta() {
        String ressuma = resmulvoic.getText().toString();

        if (!ressuma.isEmpty()) {
            int respuestaUsuario = Integer.parseInt(ressuma);

            if (respuestaUsuario == resul) {
                text = "¡Correcto!";
                ttsManager.initQueue(text);
                generarNuevaResta();
                resmulvoic.setText("");
            } else {
                text = "¡Incorrecto , Vuelve a intentarlo !";
                ttsManager.initQueue(text);
            }
        } else {
            text = "¿Estás ahí? ,Ingresa una respuesta.";
            ttsManager.initQueue(text);
        }
    }
    private void generarNuevaResta() {
        Random random = new Random();

        // Generar dos números aleatorios de 0 a 9
        comodin=random.nextInt(3);
        sumav = random.nextInt(10);
        sumbv = random.nextInt(sumav+comodin);


        // Calcular la respuesta correcta
        resul = sumav - sumbv;
        text = " ¡Correcto!La siguiente operación a realizar es:" + sumav + "menos " + sumbv;
        ttsManager.initQueue(text);

    }
}