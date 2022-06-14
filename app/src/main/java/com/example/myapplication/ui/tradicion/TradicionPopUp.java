package com.example.myapplication.ui.tradicion;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Tradicion;
import com.example.myapplication.db.repositories.TradicionRepository;

public class TradicionPopUp {
    private TradicionRepository tradicionRepository;

    public void showPopupWindow(final View view, Tradicion tradicion) {
        tradicionRepository = new TradicionRepository(view.getContext());
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.tradicion_popup, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.update();
        EditText nombreTradicion = popupView.findViewById(R.id.nombre_tradicion);
        EditText fechaDeCelebracion = popupView.findViewById(R.id.fecha_de_celebracion);
        EditText tipo = popupView.findViewById(R.id.tipo_tradicion);
        EditText descripcion = popupView.findViewById(R.id.descripcion_tradicion);
        Button save = popupView.findViewById(R.id.guardar_tradicion);
        if(tradicion != null) {
            nombreTradicion.setText(tradicion.nombre);
            fechaDeCelebracion.setText(tradicion.fechaDeCelebracion);
            tipo.setText(tradicion.tipo);
            descripcion.setText(tradicion.descripcion);

            Button delete = popupView.findViewById(R.id.eliminar_tradicion);
            delete.setVisibility(View.VISIBLE);
            delete.setOnClickListener(v->{
                tradicionRepository.delete(tradicion);
                popupWindow.dismiss();
            });
        }
        save.setOnClickListener(v -> {
            Tradicion trad = new Tradicion();
            trad.nombre = nombreTradicion.getText().toString();
            trad.fechaDeCelebracion = fechaDeCelebracion.getText().toString();
            trad.descripcion = descripcion.getText().toString();
            trad.tipo = tipo.getText().toString();
            if(tradicion != null)
            {
                trad.uid = tradicion.uid;
                tradicionRepository.update(trad);
            }else
            {
                tradicionRepository.addTradicion(trad);
            }
            popupWindow.dismiss();
        });
        popupView.setOnTouchListener((v, event) -> {
            v.performClick();
            popupWindow.dismiss();
            return true;
        });
    }
}
