package com.example.myapplication.ui.flora;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.myapplication.R;
import com.example.myapplication.db.entities.Flora;
import com.example.myapplication.db.repositories.FloraRepository;

public class FloraPopUp {
    private FloraRepository floraRepository;

    public void showPopupWindow(final View view, Flora flora) {
        floraRepository = new FloraRepository(view.getContext());
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.flora_popup, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        popupWindow.setAnimationStyle(R.style.popup_window_animation);
        popupWindow.update();
        EditText nombre = popupView.findViewById(R.id.nombre_flora);
        EditText caracteristicas = popupView.findViewById(R.id.caracteristicas_flora);
        Button save = popupView.findViewById(R.id.guardar_flora);
        if(flora != null) {
            nombre.setText(flora.nombre);
            caracteristicas.setText(flora.caracteristicas);
            Button delete = popupView.findViewById(R.id.eliminar_flora);
            delete.setVisibility(View.VISIBLE);
            delete.setOnClickListener(v->{
                floraRepository.delete(flora);
                popupWindow.dismiss();
            });
        }
        save.setOnClickListener(v -> {
            Flora flora_ = new Flora();
            flora_.caracteristicas = caracteristicas.getText().toString();
            flora_.nombre = nombre.getText().toString();
            if(flora != null)
            {
                flora_.uid = flora.uid;
                floraRepository.update(flora_);
            }else
            {
                floraRepository.addFlora(flora_);
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