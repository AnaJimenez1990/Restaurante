package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 10/3/2017.
 */

import android.app.ListActivity;
import android.os.Bundle;
import com.example.anagabriela.restaurante.LaTejaActivity;
import com.example.anagabriela.restaurante.MiAdaptadorTapas;
public class CafesListActivity extends ListActivity {
    public CafesListActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903040);
        this.setListAdapter(new MiAdaptadorTapas(this, LaTejaActivity.almacen.listaCafes(), LaTejaActivity.almacen.listaCafesPrecio()));
    }
}
