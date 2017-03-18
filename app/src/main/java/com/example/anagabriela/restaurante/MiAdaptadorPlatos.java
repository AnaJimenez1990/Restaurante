package com.example.anagabriela.restaurante;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Vector;


/**
 * Created by Ana Gabriela on 17/3/2017.
 */

public class MiAdaptadorPlatos extends BaseAdapter {
    private final Activity actividad;
    private final Vector<String> lista;
    private final Vector<String> lista2;
    private final Vector<String> lista3;

    public MiAdaptadorPlatos(Activity actividad, Vector<String> lista, Vector<String> lista2, Vector<String> lista3) {
        this.actividad = actividad;
        this.lista = lista;
        this.lista2 = lista2;
        this.lista3 = lista3;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.actividad.getLayoutInflater();
        View view = inflater.inflate(2130903044, (ViewGroup)null, true);
        TextView textView = (TextView)view.findViewById(2131034122);
        textView.setText((CharSequence)this.lista.elementAt(position));
        TextView textView2 = (TextView)view.findViewById(2131034120);
        textView2.setText((String)this.lista2.elementAt(position) + " €");
        TextView textView3 = (TextView)view.findViewById(2131034124);
        textView3.setText((CharSequence)this.lista3.elementAt(position));
        ImageView imageView = (ImageView)view.findViewById(2131034119);
        imageView.setImageResource(2130837505);
        return view;
    }

    public int getCount() {
        return this.lista.size();
    }

    public Object getItem(int arg0) {
        return this.lista.elementAt(arg0);
    }

    public long getItemId(int position) {
        return (long)position;
    }
}

