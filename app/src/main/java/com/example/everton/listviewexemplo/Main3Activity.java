package com.example.everton.listviewexemplo;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String modelo = intent.getStringExtra("modelo");
        int ano = intent.getIntExtra("ano", 0);
        int imagem = intent.getIntExtra("imagem", 0);

        ImageView img = (ImageView) findViewById(R.id.imagem2);
        TextView txtModelo = (TextView) findViewById(R.id.modelo_text2);
        TextView txtano = (TextView) findViewById(R.id.ano_text2);
        Resources res = this.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);
        img.setImageDrawable(logos.getDrawable(imagem));

        txtModelo.setText(modelo);
        txtano.setText(String.valueOf(ano));



    }
}
