package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 17/3/2017.
 */

import android.app.ListActivity;
import android.os.Bundle;
import com.example.anagabriela.restaurante.LaTejaActivity;
import com.example.anagabriela.restaurante.MiAdaptadorPlatos;

public class PlatosListActivity  extends ListActivity{
    public PlatosListActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903048);
        this.setListAdapter(new MiAdaptadorPlatos(this, LaTejaActivity.almacen.listaPlatos(), LaTejaActivity.almacen.listaPlatosPrecio(), LaTejaActivity.almacen.listaPlatosDescripcion()));
    }
}
