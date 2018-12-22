package curso.edu.eddgooglecalendar_201503422_201404200;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class Modificar extends AppCompatActivity implements View.OnClickListener {
    Button crear;
    EditText fondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);

        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        crear=(Button) findViewById(R.id.seleccion);

        fondo=(EditText)findViewById(R.id.fondos);

        crear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v==crear){
            String aux=fondo.getText().toString();
            try{
                int auxEntero = Integer.parseInt(String.valueOf(aux));
                Server.AUMENTARFONDOS(getIntent().getExtras().getString("User"),String.valueOf(aux));
                Intent j = new Intent(Modificar.this, Menu.class);
                j.putExtra("User", getIntent().getExtras().getString("User"));
                Modificar.this.startActivity(j);
            }catch(Exception e) {

            }
        }

    }
}