package com.example.anagabriela.restaurante;

/**
 * Created by Ana Gabriela on 10/3/2017.
 */
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import java.util.Vector;

public class AlmacenProductosDB extends SQLiteOpenHelper{

        public AlmacenProductosDB(Context context) {
            super(context, "productos", (CursorFactory)null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE productos (_id INTEGER PRIMARY KEY AUTOINCREMENT, tipo TEXT, codigo TEXT, nombre TEXT, descripcion TEXT, precio TEXT)");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }

        public void guardarValor(String tipo, String codigo, String nombre, String descripcion, String precio) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL("INSERT INTO productos VALUES (null, \'" + tipo + "\', \'" + codigo + "\', \'" + nombre + "\', \'" + descripcion + "\', \'" + precio + "\')");
        }

        public Vector<String> listaTapas() {
            String[] CAMPOS = new String[]{"codigo", "nombre"};
            String[] ARGS = new String[]{"tapa"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0) + "  " + cursor.getString(1));
            }

            cursor.close();
            return result;
        }

        public Vector<String> listaTapasPrecio() {
            String[] CAMPOS = new String[]{"precio"};
            String[] ARGS = new String[]{"tapa"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0));
            }

            cursor.close();
            return result;
        }

        public Vector<String> listaPlatos() {
            String[] CAMPOS = new String[]{"codigo", "nombre"};
            String[] ARGS = new String[]{"plato"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0) + "  " + cursor.getString(1));
            }

            cursor.close();
            return result;
        }

        public Vector<String> listaPlatosDescripcion() {
            String[] CAMPOS = new String[]{"descripcion"};
            String[] ARGS = new String[]{"plato"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0));
            }

            cursor.close();
            return result;
        }

        public Vector<String> listaPlatosPrecio() {
            String[] CAMPOS = new String[]{"precio"};
            String[] ARGS = new String[]{"plato"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0));
            }

            cursor.close();
            return result;
        }

        public Vector<String> listaCafes() {
            String[] CAMPOS = new String[]{"codigo", "nombre"};
            String[] ARGS = new String[]{"cafe"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0) + "  " + cursor.getString(1));
            }

            cursor.close();
            return result;
        }

        public Vector<String> listaCafesPrecio() {
            String[] CAMPOS = new String[]{"precio"};
            String[] ARGS = new String[]{"cafe"};
            Vector result = new Vector();
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.query("productos", CAMPOS, "tipo=?", ARGS, (String)null, (String)null, (String)null);

            while(cursor.moveToNext()) {
                result.add(cursor.getString(0));
            }

            cursor.close();
            return result;
        }
    }


