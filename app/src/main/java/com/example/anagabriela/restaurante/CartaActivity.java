package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 10/3/2017.
 */
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.example.anagabriela.restaurante.CafesListActivity;
import com.example.anagabriela.restaurante.PlatosListActivity;
import com.example.anagabriela.restaurante.TapasListActivity;

public class CartaActivity extends TabActivity {
    public CartaActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903041);
        Resources res = this.getResources();
        TabHost tabHost = this.getTabHost();
        Intent intent = (new Intent()).setClass(this, TapasListActivity.class);
        TabSpec spec = tabHost.newTabSpec("tab1").setIndicator((CharSequence)null, res.getDrawable(2130837512)).setContent(intent);
        tabHost.addTab(spec);
        intent = (new Intent()).setClass(this, PlatosListActivity.class);
        spec = tabHost.newTabSpec("tab2").setIndicator((CharSequence)null, res.getDrawable(2130837515)).setContent(intent);
        tabHost.addTab(spec);
        intent = (new Intent()).setClass(this, CafesListActivity.class);
        spec = tabHost.newTabSpec("tab3").setIndicator((CharSequence)null, res.getDrawable(2130837509)).setContent(intent);
        tabHost.addTab(spec);
    }

}
