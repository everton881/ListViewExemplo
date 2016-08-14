package com.example.everton.listviewexemplo;

import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.everton.listviewexemplo.R;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Carros> carros;
    CarrosAdapter adapter;
    ListView listView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = new ListView(this);
        setContentView(listView);



           carros = new ArrayList<Carros>();
            carros.add(new Carros("celta", 1998, 1));
            carros.add(new Carros("Gol" , 2016, 0));
            carros.add(new Carros("Uno", 2013, 2));
            carros.add(new Carros("KA", 2012, 3));

           adapter = new CarrosAdapter(this, carros);
           listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Carros carro = (Carros) parent.getItemAtPosition(position);

                Intent it = new Intent(MainActivity.this, Main3Activity.class);
                it.putExtra("modelo", carro.modelo);
                it.putExtra("ano", carro.ano);
                it.putExtra("imagem", carro.img);
                startActivity(it);


             //   Toast.makeText(MainActivity.this, carro.modelo + " - " + carro.ano, Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void novoCarroClick(View view) {
    }
}
