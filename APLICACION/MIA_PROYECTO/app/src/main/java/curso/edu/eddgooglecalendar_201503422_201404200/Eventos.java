package curso.edu.eddgooglecalendar_201503422_201404200;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class Eventos extends AppCompatActivity  {

    TextView nit,dpi,nombre,apellido,estado,sexo,fondos;
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
        setContentView(R.layout.activity_eventos);

        nit=(TextView)findViewById(R.id.nit);
        dpi=(TextView)findViewById(R.id.DPI);
        nombre=(TextView)findViewById(R.id.nombre);
        apellido=(TextView)findViewById(R.id.apellido);
        estado=(TextView)findViewById(R.id.estado);
        sexo=(TextView)findViewById(R.id.sexo);
        fondos=(TextView)findViewById(R.id.fondos);


        String respuesta=Server.ESTADOCUENTA(getIntent().getExtras().getString("User"));
        String[] parts = respuesta.split(",");
        nit.setText(parts[0]);
        dpi.setText(parts[1]);
        nombre.setText(parts[2]);
        apellido.setText(parts[3]);
        estado.setText(parts[4]);
        sexo.setText(parts[5]);
        fondos.setText("Q"+parts[6]);
    }

}
