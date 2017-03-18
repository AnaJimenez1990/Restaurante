package com.example.anagabriela.restaurante;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.example.anagabriela.restaurante.AlmacenProductosDB;
import com.example.anagabriela.restaurante.CartaActivity;
import com.example.anagabriela.restaurante.HistoriaActivity;
import com.example.anagabriela.restaurante.OtraActivity;
import com.example.anagabriela.restaurante.ReservaActivity;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * Created by Ana Gabriela on 17/3/2017.
 */

public class LaTejaActivity extends Activity{
    private ImageView bCarta;
    private ImageView bReserva;
    private ImageView bHistoria;
    private ImageView bOtro;
    public static AlmacenProductosDB almacen;

    public LaTejaActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903046);
        almacen = new AlmacenProductosDB(this);

        try {
            String e = "cargada.txt";
            FileInputStream fichero1 = this.openFileInput(e);
            fichero1.close();
        } catch (FileNotFoundException var6) {
            almacen.guardarValor("tapa", "t1.", "Bravas", "", "3.50");
            almacen.guardarValor("tapa", "t2.", "Calamares", "", "5.50");
            almacen.guardarValor("tapa", "t3.", "Sepia", "", "5.80");
            almacen.guardarValor("tapa", "t4.", "Choricitos del infierno", "", "4.20");
            almacen.guardarValor("tapa", "t5.", "Puntilla", "", "4.50");
            almacen.guardarValor("tapa", "t6.", "Morro especial", "", "3.20");
            almacen.guardarValor("tapa", "t7.", "Ensaladilla", "", "3.50");
            almacen.guardarValor("tapa", "t8.", "Gamabas al ajillo", "", "5.20");
            almacen.guardarValor("tapa", "t9.", "Boquerones", "", "3.60");
            almacen.guardarValor("tapa", "t10.", "Pescadito frito", "", "3.00");
            almacen.guardarValor("tapa", "t11.", "Salpicón de marisco", "", "3.50");
            almacen.guardarValor("tapa", "t12.", "Croquetón ud.", "", "0.80");
            almacen.guardarValor("plato", "p1.", "Bacon", "Bacon, patatas, ensalada y huevo", "6.50");
            almacen.guardarValor("plato", "p2.", "Lomo", "Lomo, patatas, huevo y verduras plancha", "6.80");
            almacen.guardarValor("plato", "p3.", "Pinchos", "Pinchos, patatas, huevo y verdura plancha", "6.80");
            almacen.guardarValor("plato", "p4.", "Orza", "Costilla, longaniza, lomo, patatas y huevo", "7.40");
            almacen.guardarValor("plato", "p5.", "Cordero", "Cordero, huevo, pimiento y patatas", "8.60");
            almacen.guardarValor("plato", "p6.", "Caballo", "Filete de caballo, patatas y verdura plancha", "8.20");
            almacen.guardarValor("plato", "p7", "Entrecot ternera", "Entrecot de ternera y patatas", "12.80");
            almacen.guardarValor("cafe", "", "Cafe solo", "", "1.00");
            almacen.guardarValor("cafe", "", "Cortado", "", "1.10");
            almacen.guardarValor("cafe", "", "Infusión", "", "1.00");
            almacen.guardarValor("cafe", "", "Bombón", "", "1.20");
            almacen.guardarValor("cafe", "", "Capuchino", "", "1.80");
            almacen.guardarValor("cafe", "", "Irlandés", "", "2.00");
            almacen.guardarValor("cafe", "", "Carajillo", "", "1.30");

            try {
                String fichero = "cargada.txt";
                FileOutputStream fos = this.openFileOutput(fichero, '耀');
                fos.write("cargado".getBytes());
                fos.close();
            } catch (Exception var5) {
                ;
            }
        } catch (Exception var7) {
            ;
        }

        this.bCarta = (ImageView)this.findViewById(2131034131);
        this.bCarta.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LaTejaActivity.this.lanzarCarta();
            }
        });
        this.bReserva = (ImageView)this.findViewById(2131034132);
        this.bReserva.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LaTejaActivity.this.lanzarReserva();
            }
        });
        this.bHistoria = (ImageView)this.findViewById(2131034130);
        this.bHistoria.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LaTejaActivity.this.lanzarHistoria();
            }
        });
        this.bOtro = (ImageView)this.findViewById(2131034133);
        this.bOtro.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                LaTejaActivity.this.lanzarOtro();
            }
        });
    }

    public void lanzarCarta() {
        Intent i = new Intent(this, CartaActivity.class);
        this.startActivity(i);
    }

    public void lanzarReserva() {
        Intent i = new Intent(this, ReservaActivity.class);
        this.startActivity(i);
    }

    public void lanzarHistoria() {
        Intent i = new Intent(this, HistoriaActivity.class);
        this.startActivity(i);
    }

    public void lanzarOtro() {
        Intent i = new Intent(this, OtraActivity.class);
        this.startActivity(i);
    }
}
