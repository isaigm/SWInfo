package com.example.myapplication.ui.plantamedicinal;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.PlantaMedicinal;
import com.example.myapplication.db.models.PlantaMedicinalViewModel;
import java.util.ArrayList;
import java.util.List;



public class PlantaMedicinalFragment extends Fragment implements PlantaMedicinalAdapter.OnClickListener {
    private List<PlantaMedicinal> data;
    public PlantaMedicinalFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        PlantaMedicinalViewModel plantaMedicinalViewModel = new ViewModelProvider(this).get(PlantaMedicinalViewModel.class);
        View root = inflater.inflate(R.layout.planta_fragment, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.plantarecycleview);
        data = new ArrayList<>();
        PlantaMedicinalAdapter adapter = new PlantaMedicinalAdapter(data, this);
        plantaMedicinalViewModel.getPlantas().observe(getViewLifecycleOwner(), adapter::setData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        return root;
    }
    @Override
    public void onClick(int pos) {
        PlantaMedicinalPopUp plantaMedicinalPopUp = new PlantaMedicinalPopUp();
        plantaMedicinalPopUp.showPopupWindow(getView(), data.get(pos));
    }
}