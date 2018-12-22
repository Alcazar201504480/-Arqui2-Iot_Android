package curso.edu.eddgooglecalendar_201503422_201404200;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import android.widget.Toast;

public class Productos extends AppCompatActivity  {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    List<Producto> items = new ArrayList<>();
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
        setContentView(R.layout.activity_productos);

        String respuesta=Server.PRODUCTOS(getIntent().getExtras().getString("Categoria"));
        String[] parts = respuesta.split(",");

        for(int i=0;i<parts.length;i++)
        {
            items.add(new Producto(parts[i]));
        }
        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recicladorproductos);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new ProductoAdapter(items,new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                //String respuesta=Server.PRECIOPRODUCTO(items.get(position).getNombre());
                //Toast.makeText(Productos.this,"Q"+respuesta,Toast.LENGTH_SHORT).show();
                Intent j = new Intent(Productos.this, CompraProducto.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                j.putExtra("Producto",items.get(position).getNombre());
                Productos.this.startActivity(j);
            }
        });
        recycler.setAdapter(adapter);


    }

}
