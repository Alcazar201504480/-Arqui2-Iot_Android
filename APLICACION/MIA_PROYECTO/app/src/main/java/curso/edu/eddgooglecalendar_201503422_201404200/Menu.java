package curso.edu.eddgooglecalendar_201503422_201404200;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Button comp=(Button) findViewById(R.id.Compras);
        final Button agr=(Button) findViewById(R.id.Agregar);
        final Button cuent=(Button) findViewById(R.id.Cuenta);
        final Button re=(Button) findViewById(R.id.Rep);
        final Button resumen=(Button) findViewById(R.id.ResumenCompras);
        final Button salir=(Button) findViewById(R.id.Salir);


        comp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(Menu.this, Compras.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                Menu.this.startActivity(j);
            }
        });
        agr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent j = new Intent(Menu.this, Modificar.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                Menu.this.startActivity(j);
            }
        });
        cuent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Menu.this, Eventos.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                Menu.this.startActivity(j);
            }
        });
        re.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Menu.this, Reporte.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                Menu.this.startActivity(j);
            }
        });
        resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Menu.this, ResumenCompras.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                Menu.this.startActivity(j);
            }
        });
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent j = new Intent(Menu.this, Login_Register.class);
                Menu.this.startActivity(j);
            }
        });

    }

}
