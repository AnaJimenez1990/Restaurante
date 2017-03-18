package com.example.anagabriela.restaurante;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import com.example.anagabriela.restaurante.Calendario;
import com.example.anagabriela.restaurante.ManejadorSerWeb;
import com.example.anagabriela.restaurante.ReservaAceptada;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
/**
 * Created by Ana Gabriela on 17/3/2017.
 */

public class ReservaActivity extends Activity {
    private TimePicker tiempo;
    private Button calendario;
    private boolean calendarioLanzado = false;
    private boolean reservaRealizada = false;
    private int dia;
    private int mes;
    private int ano;
    private int hora;
    private int minutos;
    private String nombre;
    private String numPersonas;
    private TimePicker reloj;
    private EditText nombreET;
    private EditText numPersonasET;
    private Button bReservar;

    public ReservaActivity() {
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(2130903049);
        this.tiempo = (TimePicker)this.findViewById(2131034137);
        this.tiempo.setIs24HourView(Boolean.valueOf(true));
        this.calendario = (Button)this.findViewById(2131034146);
        this.reloj = (TimePicker)this.findViewById(2131034137);
        this.nombreET = (EditText)this.findViewById(2131034144);
        this.nombreET.clearFocus();
        this.numPersonasET = (EditText)this.findViewById(2131034145);
        this.numPersonasET.clearFocus();
        this.bReservar = (Button)this.findViewById(2131034140);
        Calendar c = Calendar.getInstance();
        this.ano = c.get(1);
        this.mes = c.get(2);
        this.dia = c.get(5);
        this.calendario.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReservaActivity.this.lanzarCalendario();
                ReservaActivity.this.calendarioLanzado = true;
            }
        });
        this.bReservar.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                ReservaActivity.this.hora = ReservaActivity.this.reloj.getCurrentHour().intValue();
                ReservaActivity.this.minutos = ReservaActivity.this.reloj.getCurrentMinute().intValue();
                ReservaActivity.this.nombre = ReservaActivity.this.nombreET.getText().toString();
                ReservaActivity.this.numPersonas = ReservaActivity.this.numPersonasET.getText().toString();
                ReservaActivity.this.guardarReserva(ReservaActivity.this.hora, ReservaActivity.this.minutos, ReservaActivity.this.dia, ReservaActivity.this.mes, ReservaActivity.this.ano, ReservaActivity.this.nombre, ReservaActivity.this.numPersonas);
            }
        });
    }

    public void lanzarCalendario() {
        Intent i = new Intent(this, Calendario.class);
        this.startActivity(i);
    }

    protected void onResume() {
        super.onResume();
        if(this.reservaRealizada) {
            this.finish();
        }

        if(this.calendarioLanzado) {
            this.dia = Calendario.dia;
            this.mes = Calendario.mes;
            this.ano = Calendario.ano;
        }

    }

    public void guardarReserva(int hora, int minutos, int dia, int mes, int ano, String nombre, String numPersonas) {
        try {
            URL e = new URL("http://192.168.1.7:8080/ReservasServicioWeb/services/ReservasServicioWeb.ReservasServicioWebHttpEndpoint/nueva");
            HttpURLConnection conecxion = (HttpURLConnection)e.openConnection();
            conecxion.setRequestMethod("POST");
            conecxion.setDoOutput(true);
            OutputStreamWriter sal = new OutputStreamWriter(conecxion.getOutputStream());
            sal.write("hora=");
            sal.write(URLEncoder.encode(String.valueOf(hora), "UTF-8"));
            sal.write("&minutos=");
            sal.write(URLEncoder.encode(String.valueOf(minutos), "UTF-8"));
            sal.write("&dia=");
            sal.write(URLEncoder.encode(String.valueOf(dia), "UTF-8"));
            sal.write("&mes=");
            sal.write(URLEncoder.encode(String.valueOf(mes), "UTF-8"));
            sal.write("&ano=");
            sal.write(URLEncoder.encode(String.valueOf(ano), "UTF-8"));
            sal.write("&nombre=");
            sal.write(URLEncoder.encode(nombre, "UTF-8"));
            sal.write("&numPersonas=");
            sal.write(URLEncoder.encode(numPersonas, "UTF-8"));
            sal.flush();
            if(conecxion.getResponseCode() == 200) {
                SAXParserFactory i = SAXParserFactory.newInstance();
                SAXParser parser = i.newSAXParser();
                XMLReader lector = parser.getXMLReader();
                ManejadorSerWeb manejadorXML = new ManejadorSerWeb();
                lector.setContentHandler(manejadorXML);
                lector.parse(new InputSource(conecxion.getInputStream()));
                if(manejadorXML.getLista().size() != 1 || !((String)manejadorXML.getLista().get(0)).equals("OK")) {
                    Log.e("LaTeja", "Error en respuesta servidor");
                }
            } else {
                Log.e("LaTeja", "ha petao");
            }

            conecxion.disconnect();
            this.reservaRealizada = true;
            Intent i1 = new Intent(this, ReservaAceptada.class);
            this.startActivity(i1);
        } catch (Exception var15) {
            Log.e("LaTeja", "ha petao2", var15);
        }

    }
}
