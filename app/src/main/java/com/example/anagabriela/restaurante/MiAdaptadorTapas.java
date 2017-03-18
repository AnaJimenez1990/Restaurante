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

public class MiAdaptadorTapas  extends BaseAdapter  {
    private final Activity actividad;
    private final Vector<String> lista;
    private final Vector<String> lista2;

    public MiAdaptadorTapas(Activity actividad, Vector<String> lista, Vector<String> lista2) {
        this.actividad = actividad;
        this.lista = lista;
        this.lista2 = lista2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = this.actividad.getLayoutInflater();
        View view = inflater.inflate(2130903043, (ViewGroup)null, true);
        TextView textView = (TextView)view.findViewById(2131034117);
        textView.setText((CharSequence)this.lista.elementAt(position));
        TextView textView2 = (TextView)view.findViewById(2131034115);
        textView2.setText((String)this.lista2.elementAt(position) + " €");
        ImageView imageView = (ImageView)view.findViewById(2131034114);
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
