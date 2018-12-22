package curso.edu.eddgooglecalendar_201503422_201404200;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CompraProducto extends AppCompatActivity  {

    TextView nombre,precio;
    EditText cantidad;
    Button cargar;
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
        setContentView(R.layout.activity_compraproducto);

        nombre=(TextView)findViewById(R.id.n);
        precio=(TextView)findViewById(R.id.p);
        cantidad=(EditText) findViewById(R.id.c);
        cargar=(Button) findViewById(R.id.bcarga);

        String producto=getIntent().getExtras().getString("Producto");
        String p=Server.PRECIOPRODUCTO(producto);
        nombre.setText(producto);
        precio.setText("Q"+p);

        cargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String aux=cantidad.getText().toString();
                    int auxcantidad = Integer.parseInt(String.valueOf(aux));
                    String aux2=precio.getText().toString();
                    String aux3=Server.IDPRODUCTO(getIntent().getExtras().getString("Producto"));
                    aux2=aux2.replace("Q","");
                    int auxprecio=Integer.parseInt(String.valueOf(aux2));
                    int auxid=Integer.parseInt(String.valueOf(aux3));
                    MiBaseDatos MDB = new MiBaseDatos(getApplicationContext());
                    MDB.insertarPRODUCTO(auxid,auxcantidad, auxprecio);
                    Intent j = new Intent(CompraProducto.this, Menu.class);
                    j.putExtra("User",getIntent().getExtras().getString("User"));
                    CompraProducto.this.startActivity(j);
                }
                catch (Exception e){
                    Toast.makeText(CompraProducto.this,"LA CANTIDAD NO ES ENTERA",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
