package com.example.everton.listviewexemplo;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Everton on 14/08/2016.
 */
public class CarrosAdapter extends BaseAdapter {

   Context ctx;
    List<Carros> carros;

    public CarrosAdapter(Context ctx, List<Carros> carros){
        this.ctx = ctx;
        this.carros = carros;

    }

    @Override
    public int getCount() {
        return carros.size();
    }

    @Override
    public Object getItem(int position) {
        return carros.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Carros carro = carros.get(position);
       // View linha = LayoutInflater.from(ctx).inflate(R.layout.activity_main2, null);
        ViewHolder holder = null;


        if(convertView ==null){


            convertView = LayoutInflater.from(ctx).inflate(R.layout.activity_main2, null);
            //Usando viewHolder
            holder = new ViewHolder();

             holder.imagem = (ImageView) convertView.findViewById(R.id.imagem);
             holder.txtModelo = (TextView) convertView.findViewById(R.id.modelo_text);
             holder.txtAno = (TextView) convertView.findViewById(R.id.ano_text);
            convertView.setTag(holder);
        }else{
            Log.d("NGVL", "View existente => position: " + position);
            holder = (ViewHolder) convertView.getTag();
        }
        //Usando a View padrão
        /*ImageView imagem = (ImageView) linha.findViewById(R.id.imagem);
        TextView txtModelo = (TextView) linha.findViewById(R.id.modelo_text);
        TextView txtAno = (TextView) linha.findViewById(R.id.ano_text);*/


        Resources res = ctx.getResources();
        TypedArray logos = res.obtainTypedArray(R.array.logos);
       holder.imagem.setImageDrawable(logos.getDrawable(carro.img));

        holder.txtModelo.setText(carro.modelo);
        holder.txtAno.setText(String.valueOf(carro.ano));

        return convertView;
    }

    static  class ViewHolder{

        ImageView imagem;
        TextView txtModelo;
        TextView txtAno;


    }

}
