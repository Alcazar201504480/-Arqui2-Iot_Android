package curso.edu.eddgooglecalendar_201503422_201404200;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by denis on 1/01/18.
 */

public class MiBaseDatos extends SQLiteOpenHelper {

    private static final int VERSION_BASEDATOS = 1;

    // Nombre de nuestro archivo de base de datos
    private static final String NOMBRE_BASEDATOS = "mibasedatos.db";

    // Sentencia SQL para la creación de una tabla
    private static final String TABLA_PRODUCTOS = "CREATE TABLE contactos" +
            "(_id INT PRIMARY KEY, cantidad INT,precio INT)";
    private static final String DELETE =
            "DROP TABLE IF EXISTS contactos";


    // CONSTRUCTOR de la clase
    public MiBaseDatos(Context context) {
        super(context, NOMBRE_BASEDATOS, null, VERSION_BASEDATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void CrearTabla()
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(DELETE);
        db.execSQL(TABLA_PRODUCTOS);
    }

    public void insertarPRODUCTO(int id, int cantidad,int precio) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("_id", id);
            valores.put("cantidad", cantidad);
            valores.put("precio", precio);
            db.insert("contactos", null, valores);
            db.close();
        }
    }
    public Contacto recuperarPRODUCTO(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"_id", "cantidad", "precio"};
        Cursor c = db.query("contactos", valores_recuperar, "_id=" + id,
                null, null, null, null, null);
        if(c != null) {
            c.moveToFirst();
        }
        Contacto contacto = new Contacto(c.getInt(0), c.getInt(1),
                c.getInt(2));
        db.close();
        c.close();
        return contacto;
    }
    public List<Contacto> recuperarCONTACTOS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Contacto> lista_contactos = new ArrayList<Contacto>();
        String[] valores_recuperar = {"_id", "cantidad", "precio"};
        Cursor c = db.query("contactos", valores_recuperar,
                null, null, null, null, null, null);
        if(c.moveToFirst())
        {
            do {
                Contacto contactos = new Contacto(c.getInt(0), c.getInt(1),
                        c.getInt(2));
                lista_contactos.add(contactos);
            } while (c.moveToNext());
        }

        db.close();
        c.close();
        return lista_contactos;
    }
}
