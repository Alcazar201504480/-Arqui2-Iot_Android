package curso.edu.eddgooglecalendar_201503422_201404200;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.annotation.NonNull;

import java.util.List;


public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder> {
    private List<Categoria> items;
    private RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public CategoriaAdapter(List<Categoria> items,@NonNull RecyclerViewOnItemClickListener
            recyclerViewOnItemClickListener) {
        this.items = items;
        this.recyclerViewOnItemClickListener = recyclerViewOnItemClickListener;
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CategoriaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.anime_card, viewGroup, false);
        return new CategoriaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoriaViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.nombre.setText(items.get(i).getNombre());
    }

    public  class CategoriaViewHolder extends RecyclerView.ViewHolder implements View
            .OnClickListener{
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView nombre;

        public CategoriaViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            nombre = (TextView) v.findViewById(R.id.nombre);
            v.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            recyclerViewOnItemClickListener.onClick(v, getAdapterPosition());
        }
    }




}
