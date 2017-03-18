package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 10/3/2017.
 */
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;

public class Calendario extends Activity {
    private DatePicker fecha;
    private Button aceptar;
    public static int dia;
    public static int mes;
    public static int ano;

    public Calendario() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903042);
        this.fecha = (DatePicker)this.findViewById(2131034112);
        this.aceptar = (Button)this.findViewById(2131034113);
        this.aceptar.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Calendario.this.guardarFecha();
            }
        });
    }

    public void guardarFecha() {
        dia = this.fecha.getDayOfMonth();
        mes = this.fecha.getMonth();
        ano = this.fecha.getYear();
        this.finish();
    }
}


