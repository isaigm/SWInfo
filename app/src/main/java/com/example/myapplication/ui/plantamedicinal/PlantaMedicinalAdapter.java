package com.example.myapplication.ui.plantamedicinal;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.db.entities.PlantaMedicinal;

import java.util.List;

public class PlantaMedicinalAdapter extends RecyclerView.Adapter<PlantaMedicinalAdapter.ViewHolder> {
    private List<PlantaMedicinal> data;
    private final OnClickListener onClickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planta, parent, false);
        return new ViewHolder(view, onClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(data.get(position));
    }
    public void setData(List<PlantaMedicinal> newData) {
        if (data != null) {
            data.clear();
            data.addAll(newData);
            notifyDataSetChanged();
        } else {
            data = newData;
        }
    }
    public PlantaMedicinalAdapter(List<PlantaMedicinal> data, OnClickListener onClickListener ){
        this.data = data;
        this.onClickListener = onClickListener;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    static public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombrePlanta;
        private final TextView descripcionPlanta;
        private final OnClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);
            nombrePlanta = itemView.findViewById(R.id.nombre_planta_item);
            descripcionPlanta = itemView.findViewById(R.id.descripcion_planta_item);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }
        public void setData(PlantaMedicinal planta) {
            this.descripcionPlanta.setText(String.format("Descripción: %s", planta.descripcion));
            this.nombrePlanta.setText(planta.nombre);
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
