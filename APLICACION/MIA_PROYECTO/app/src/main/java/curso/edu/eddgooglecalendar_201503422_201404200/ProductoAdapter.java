package curso.edu.eddgooglecalendar_201503422_201404200;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder> {
    private List<Producto> items;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public ProductoAdapter(List<Producto> items,@NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.items = items;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }



    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ProductoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.producto_card, viewGroup, false);
        return new ProductoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductoViewHolder viewHolder, int i) {
        viewHolder.nombre.setText(items.get(i).getNombre());
    }
    public  class ProductoViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener {
        // Campos respectivos de un item
        public TextView nombre;


        public ProductoViewHolder(View v) {
            super(v);
            nombre = (TextView) v.findViewById(R.id.nombre);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }

}
