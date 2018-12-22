package curso.edu.eddgooglecalendar_201503422_201404200;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import java.util.ArrayList;
import android.widget.TableLayout;
import android.widget.Toast;

public class Reporte extends AppCompatActivity  {

    TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
            //your codes here
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reporte);


        Tabla tabla = new Tabla(this, (TableLayout)findViewById(R.id.tabla));
        tabla.agregarCabecera(R.array.cabecera_tabla);
        String respuesta=Server.REPORTEANDROID(getIntent().getExtras().getString("User"));
        if(respuesta!="")
        {
            String[] parts = respuesta.split(";");
            for(int i = 0; i <parts.length; i++)
            {
                String[] parts2 = parts[i].split(",");
                ArrayList<String> elementos = new ArrayList<String>();
                elementos.add(parts2[0]);
                elementos.add(parts2[1]);
                elementos.add(parts2[2]);
                elementos.add("Q"+parts2[3]);
                tabla.agregarFilaTabla(elementos);
            }
        }




    }

}
