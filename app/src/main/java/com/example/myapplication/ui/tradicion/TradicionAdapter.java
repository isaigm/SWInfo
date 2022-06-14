package com.example.myapplication.ui.tradicion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Tradicion;

import java.util.List;

public class TradicionAdapter  extends RecyclerView.Adapter<TradicionAdapter.ViewHolder>{

    private List<Tradicion> data;
    private final TradicionAdapter.OnClickListener onClickListener;

    @NonNull
    @Override
    public TradicionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tradicion, parent, false);
        return new TradicionAdapter.ViewHolder(view, onClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull TradicionAdapter.ViewHolder holder, int position) {
        holder.setData(data.get(position));
    }
    public void setData(List<Tradicion> newData) {
        if (data != null) {
            data.clear();
            data.addAll(newData);
            notifyDataSetChanged();
        } else {
            data = newData;
        }
    }
    public TradicionAdapter(List<Tradicion> data, TradicionAdapter.OnClickListener onClickListener ){
        this.data = data;
        this.onClickListener = onClickListener;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    static public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombreTradicion;
        private final TextView fechaDeCelebracion;
        private final TextView tipo;
        private final TextView descripcion;
        private final TradicionAdapter.OnClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, TradicionAdapter.OnClickListener onClickListener) {
            super(itemView);
            nombreTradicion = itemView.findViewById(R.id.nombre_tradicion_item);
            fechaDeCelebracion = itemView.findViewById(R.id.fecha_de_celebracion_item);
            tipo = itemView.findViewById(R.id.tipo_tradicion_item);
            descripcion = itemView.findViewById(R.id.descripcion_tradicion_item);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }
        public void setData(Tradicion tradicion) {
            this.nombreTradicion.setText(tradicion.nombre);
            this.fechaDeCelebracion.setText(String.format("Fecha: %s", tradicion.fechaDeCelebracion));
            this.tipo.setText(String.format("Tipo: %s", tradicion.tipo));
            this.descripcion.setText(String.format("Descripción: %s", tradicion.descripcion));
        }

        @Override
        public void onClick(View view) {
            onClickListener.onClick(getAbsoluteAdapterPosition());
        }
    }
    public interface  OnClickListener
    {
        void onClick(int pos);
    }
}
