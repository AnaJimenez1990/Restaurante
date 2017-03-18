package com.example.anagabriela.restaurante;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Vector;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 * Created by Ana Gabriela on 17/3/2017.
 */

public class ManejadorSerWeb extends DefaultHandler {
    private Vector<String> lista;
    private StringBuilder cadena;

    ManejadorSerWeb() {
    }

    public Vector<String> getLista() {
        return this.lista;
    }

    public void startDocument() throws SAXException {
        this.cadena = new StringBuilder();
        this.lista = new Vector();
    }

    public void characters(char[] ch, int comienzo, int longitud) {
        this.cadena.append(ch, comienzo, longitud);
    }

    public void endElement(String uri, String nombreLocal, String nombreCualif) throws SAXException {
        if(nombreLocal.equalsIgnoreCase("return")) {
            try {
                this.lista.add(URLDecoder.decode(this.cadena.toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
                Log.e("Ateroides", var5.getMessage(), var5);
            }
        }

        this.cadena.setLength(0);
    }
}
