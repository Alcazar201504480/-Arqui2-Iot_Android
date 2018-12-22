package curso.edu.eddgooglecalendar_201503422_201404200;


import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;
public class Compras extends AppCompatActivity  {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    List<Categoria> items = new ArrayList<>();
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
        setContentView(R.layout.activity_compras);

        String respuesta=Server.CATEGORIAS();
        String[] parts = respuesta.split(",");

        for(int i=0;i<parts.length;i++)
        {
            items.add(new Categoria(R.drawable.ropa, parts[i]));
        }
        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new CategoriaAdapter(items ,new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View v, int position) {
                //Toast.makeText(Compras.this, items.get(position).getNombre(), Toast.LENGTH_SHORT).show();
                Intent j = new Intent(Compras.this, Productos.class);
                j.putExtra("User",getIntent().getExtras().getString("User"));
                j.putExtra("Categoria",items.get(position).getNombre());
                Compras.this.startActivity(j);
            }
        });
        recycler.setAdapter(adapter);



    }

}
