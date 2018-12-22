package curso.edu.eddgooglecalendar_201503422_201404200;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.ArrayList;

public class ResumenCompras extends AppCompatActivity  {
    int total;
    String cadena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumencompras);

        final TextView hola=(TextView)findViewById(R.id.Total);
        final Button comp=(Button) findViewById(R.id.boton);
        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.cabecera_compras);
        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
        final List<Contacto> lista=MDB.recuperarCONTACTOS();
        total=0;
        if(lista.size()>0)
        {
            cadena=getIntent().getExtras().getString("User")+":";
            for(Object object : lista) {
                Contacto element = (Contacto) object;
                ArrayList<String> elementos = new ArrayList<String>();
                elementos.add(String.valueOf(element.getID()));
                elementos.add(String.valueOf(element.getCantidad()));
                elementos.add(String.valueOf(element.getPrecio()));
                tabla.agregarFilaTabla(elementos);
                total=total+element.getCantidad()*element.getPrecio();
                cadena=cadena+element.getID()+","+element.getCantidad()+","+element.getPrecio()+";";
            }
        }
        hola.setText("Total:Q"+total);
        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lista.size()>0)
                {
                    String respuesta=Server.ESTADOCUENTA(getIntent().getExtras().getString("User"));
                    String[] parts = respuesta.split(",");
                    int fondos = Integer.parseInt(parts[6]);
                    if(fondos<total)
                    {
                        Toast.makeText(ResumenCompras.this,"NO HAY SUFICIENTES FONDOS", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Server.CREARFACTURA(cadena);
                        MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
                        MDB.CrearTabla();
                        Server.DISMINUIRFONDOS(getIntent().getExtras().getString("User"),String.valueOf(total));
                        Intent j = new Intent(ResumenCompras.this, Menu.class);
                        j.putExtra("User",getIntent().getExtras().getString("User"));
                        ResumenCompras.this.startActivity(j);
                    }
                }
                else
                {
                    Toast.makeText(ResumenCompras.this,"NO HAY ELEMENTOS EN EL CARRITO", Toast.LENGTH_SHORT).show();
                }

            }
        });




    }

}
