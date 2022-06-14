package com.example.myapplication.ui.plantamedicinal;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.PlantaMedicinal;
import com.example.myapplication.db.repositories.PlantaMedicinalRepository;

public class PlantaMedicinalPopUp {
    private PlantaMedicinalRepository plantaMedicinalRepository;

    public void showPopupWindow(final View view, PlantaMedicinal plantaMedicinal) {
        plantaMedicinalRepository = new PlantaMedicinalRepository(view.getContext());
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.planta_popup, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.update();
        EditText nombrePlanta = popupView.findViewById(R.id.nombre_planta);
        EditText descripcionPlanta = popupView.findViewById(R.id.descripcion_planta);
        Button save = popupView.findViewById(R.id.guardar_planta);
        if(plantaMedicinal != null) {
            nombrePlanta.setText(plantaMedicinal.nombre);
            descripcionPlanta.setText(plantaMedicinal.descripcion);
            Button delete = popupView.findViewById(R.id.eliminar_planta);
            delete.setVisibility(View.VISIBLE);
            delete.setOnClickListener(v->{
                plantaMedicinalRepository.delete(plantaMedicinal);
                popupWindow.dismiss();
            });
        }
        save.setOnClickListener(v -> {
            PlantaMedicinal planta = new PlantaMedicinal();
            planta.descripcion = descripcionPlanta.getText().toString();
            planta.nombre = nombrePlanta.getText().toString();
            if(plantaMedicinal != null)
            {
                planta.uid = plantaMedicinal.uid;
                plantaMedicinalRepository.update(planta);
            }else
            {
                plantaMedicinalRepository.addPlanta(planta);
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