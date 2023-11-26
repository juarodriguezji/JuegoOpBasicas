package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class multiplicar extends AppCompatActivity {
Button multext;
Button multvoice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicar);
        multext=(Button) findViewById(R.id.multext);
        multvoice=(Button)findViewById(R.id.mulvoice);
        multext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(multiplicar.this,multiplicarcontexto.class));
            }
        });
        multvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(multiplicar.this,multivoice.class));
            }
        });
    }
}