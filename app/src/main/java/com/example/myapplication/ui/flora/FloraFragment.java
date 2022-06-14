package com.example.myapplication.ui.flora;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Flora;
import com.example.myapplication.db.models.FloraViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class FloraFragment extends Fragment implements FloraAdapter.OnClickListener {
    private List<Flora> data;
    public FloraFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("SD");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FloraViewModel floraViewModel = new ViewModelProvider(this).get(FloraViewModel.class);
        View root = inflater.inflate(R.layout.flora_fragment, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.florarecycleview);
        data = new ArrayList<>();
        FloraAdapter adapter = new FloraAdapter(data, this);
        floraViewModel.getFlora().observe(getViewLifecycleOwner(), adapter::setData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);



        return root;
    }
    @Override
    public void onClick(int pos) {
        FloraPopUp floraPopUp = new FloraPopUp();
        floraPopUp.showPopupWindow(getView(), data.get(pos));
    }
}