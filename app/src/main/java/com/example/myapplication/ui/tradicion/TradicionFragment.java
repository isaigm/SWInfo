package com.example.myapplication.ui.tradicion;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Tradicion;
import com.example.myapplication.db.models.TradicionViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class TradicionFragment extends Fragment implements TradicionAdapter.OnClickListener{
    private List<Tradicion> data;
    public TradicionFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TradicionViewModel tradicionViewModel = new ViewModelProvider(this).get(TradicionViewModel.class);
        View root = inflater.inflate(R.layout.tradicion_fragment, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.tradicionrecycleview);
        data = new ArrayList<>();
        TradicionAdapter adapter = new TradicionAdapter(data, this);
        tradicionViewModel.getTradiciones().observe(getViewLifecycleOwner(), adapter::setData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);



        return root;
    }

    @Override
    public void onClick(int pos) {
        TradicionPopUp tradicionPopUp = new TradicionPopUp();
        tradicionPopUp.showPopupWindow(getView(), data.get(pos));
    }
}
