package com.example.myapplication.ui.fauna;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Fauna;
import com.example.myapplication.db.repositories.FaunaRepository;

public class FaunaPopUp {
    private FaunaRepository faunaRepository;

    public void showPopupWindow(final View view, Fauna fauna) {
        faunaRepository = new FaunaRepository(view.getContext());
        LayoutInflater inflater = (LayoutInflater) view.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.fauna_popup, null);
        int width = LinearLayout.LayoutParams.MATCH_PARENT;
        int height = LinearLayout.LayoutParams.MATCH_PARENT;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
        EditText nombre = popupView.findViewById(R.id.nombre_fauna);
        EditText descripcion = popupView.findViewById(R.id.descripcion_fauna);
        Button save = popupView.findViewById(R.id.guardar_fauna);
        if(fauna != null) {
            descripcion.setText(fauna.descripcion);
            nombre.setText(fauna.nombre);
            Button delete = popupView.findViewById(R.id.eliminar_fauna);
            delete.setVisibility(View.VISIBLE);
            delete.setOnClickListener(v->{
                faunaRepository.delete(fauna);
                popupWindow.dismiss();
            });
        }
        save.setOnClickListener(v -> {
            Fauna fauna_ = new Fauna();
            fauna_.descripcion = descripcion.getText().toString();
            fauna_.nombre = nombre.getText().toString();
            if(fauna != null)
            {
                fauna_.uid = fauna.uid;
                faunaRepository.update(fauna_);
            }else
            {
                faunaRepository.addFauna(fauna_);
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