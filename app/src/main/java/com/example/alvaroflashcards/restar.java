package com.example.alvaroflashcards;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class restar extends AppCompatActivity {
    Button restatexto;
    Button restavoz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restar);
        restatexto=(Button)findViewById(R.id.texrex);
        restavoz=(Button)findViewById(R.id.voxrex);

        restatexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(restar.this,restacontexto.class));
            }
        });
        restavoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(restar.this,restavoice.class));
            }
        });
    }
}