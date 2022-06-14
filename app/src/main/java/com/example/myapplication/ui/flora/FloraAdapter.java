package com.example.myapplication.ui.flora;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Flora;
import java.util.List;

public class FloraAdapter extends RecyclerView.Adapter<FloraAdapter.ViewHolder> {
    private List<Flora> data;
    private final FloraAdapter.OnClickListener onClickListener;

    @NonNull
    @Override
    public FloraAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_flora, parent, false);
        return new FloraAdapter.ViewHolder(view, onClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull FloraAdapter.ViewHolder holder, int position) {
        holder.setData(data.get(position));
    }
    public void setData(List<Flora> newData) {
        if (data != null) {
            data.clear();
            data.addAll(newData);
            notifyDataSetChanged();
        } else {
            data = newData;
        }
    }
    public FloraAdapter(List<Flora> data, FloraAdapter.OnClickListener onClickListener ){
        this.data = data;
        this.onClickListener = onClickListener;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    static public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombreFlora;
        private final TextView caracteristicas;
        private final FloraAdapter.OnClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, FloraAdapter.OnClickListener onClickListener) {
            super(itemView);
            nombreFlora = itemView.findViewById(R.id.nombre_flora_item);
            caracteristicas = itemView.findViewById(R.id.caracteristicas_flora_item);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }
        public void setData(Flora flora) {
            this.caracteristicas.setText(String.format("Características: %s", flora.caracteristicas));
            this.nombreFlora.setText(flora.nombre);
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