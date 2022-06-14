package com.example.myapplication.ui.fauna;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Fauna;
import java.util.List;

public class FaunaAdapter extends RecyclerView.Adapter<FaunaAdapter.ViewHolder> {
    private List<Fauna> data;
    private final OnClickListener onClickListener;

    @NonNull
    @Override
    public FaunaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fauna, parent, false);
        return new FaunaAdapter.ViewHolder(view, onClickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull FaunaAdapter.ViewHolder holder, int position) {
        holder.setData(data.get(position));
    }
    public void setData(List<Fauna> newData) {
        if (data != null) {
            data.clear();
            data.addAll(newData);
            notifyDataSetChanged();
        } else {
            data = newData;
        }
    }
    public FaunaAdapter(List<Fauna> data, FaunaAdapter.OnClickListener onClickListener ){
        this.data = data;
        this.onClickListener = onClickListener;
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    static public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private final TextView nombre;
        private final TextView descripcion;
        private final FaunaAdapter.OnClickListener onClickListener;
        public ViewHolder(@NonNull View itemView, FaunaAdapter.OnClickListener onClickListener) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_fauna_item);
            descripcion = itemView.findViewById(R.id.descripcion_fauna_item);
            this.onClickListener = onClickListener;
            itemView.setOnClickListener(this);
        }
        public void setData(Fauna fauna) {
            this.descripcion.setText(String.format("Descripción: %s", fauna.descripcion));
            this.nombre.setText(fauna.nombre);
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