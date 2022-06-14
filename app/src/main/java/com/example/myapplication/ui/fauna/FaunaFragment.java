package com.example.myapplication.ui.fauna;


import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.myapplication.R;
import com.example.myapplication.db.entities.Fauna;
import com.example.myapplication.db.models.FaunaViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;

public class FaunaFragment extends Fragment implements FaunaAdapter.OnClickListener {
    private List<Fauna> data;
    public FaunaFragment() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FaunaViewModel faunaViewModel = new ViewModelProvider(this).get(FaunaViewModel.class);
        View root = inflater.inflate(R.layout.fauna_fragment, container, false);
        RecyclerView recyclerView = root.findViewById(R.id.faunarecycleview);
        data = new ArrayList<>();
        FaunaAdapter adapter = new FaunaAdapter(data, this);
        faunaViewModel.getFauna().observe(getViewLifecycleOwner(), adapter::setData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


        return root;
    }
    @Override
    public void onClick(int pos) {
        FaunaPopUp faunaPopUp = new FaunaPopUp();
        faunaPopUp.showPopupWindow(getView(), data.get(pos));
    }
}