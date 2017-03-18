package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 17/3/2017.
 */
import android.app.ListActivity;
import android.os.Bundle;
import com.example.anagabriela.restaurante.LaTejaActivity;
import com.example.anagabriela.restaurante.MiAdaptadorTapas;

public class TapasListActivity extends ListActivity {
    public TapasListActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903051);
        this.setListAdapter(new MiAdaptadorTapas(this, LaTejaActivity.almacen.listaTapas(), LaTejaActivity.almacen.listaTapasPrecio()));
    }
}
