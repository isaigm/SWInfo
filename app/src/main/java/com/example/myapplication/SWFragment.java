package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SWFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Pair<String, String>> data;
    public SWFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sw, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false));

        if (getArguments() != null) {
            int pos = getArguments().getInt("pos");
            switch (pos){
                case 0: getPlanets();
                break;
                case 1: getPeople();
                break;
                case 2: getVehicles();
                break;
            }
        }
        return view;
    }
    private void getPlanets(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SWInfoAPI swInfoAPI = retrofit.create(SWInfoAPI.class);
        Call<Result<Planet>> planets = swInfoAPI.getPlanets();
        planets.enqueue(new Callback<Result<Planet>>() {
            @Override
            public void onResponse(Call<Result<Planet>> call, Response<Result<Planet>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }else{
                    data = new ArrayList<>();
                    ArrayList<Planet> results = response.body().getResults();
                    for(Planet planet: results){
                        data.add(new Pair<String, String>(String.format("Diameter: %s Population: %s", planet.getDiameter(), planet.getPopulation()), planet.getName()));
                    }
                    Adapter adapter = new Adapter(data);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<Result<Planet>> call, Throwable t) {
                Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getVehicles(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SWInfoAPI swInfoAPI = retrofit.create(SWInfoAPI.class);
        Call<Result<Vehicle>> vehicles = swInfoAPI.getVehicles();
        vehicles.enqueue(new Callback<Result<Vehicle>>() {
            @Override
            public void onResponse(Call<Result<Vehicle>> call, Response<Result<Vehicle>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }else{
                    data = new ArrayList<>();
                    ArrayList<Vehicle> results = response.body().getResults();
                    for(Vehicle vehicle: results){
                        data.add(new Pair<String, String>(String.format("Model: %s Manufacturer: %s", vehicle.getModel(), vehicle.getManufacturer()), vehicle.getName()));
                    }
                    Adapter adapter = new Adapter(data);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<Result<Vehicle>> call, Throwable t) {
                Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getPeople(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://swapi.dev/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        SWInfoAPI swInfoAPI = retrofit.create(SWInfoAPI.class);
        Call<Result<People>> people = swInfoAPI.getPeople();
        people.enqueue(new Callback<Result<People>>() {
            @Override
            public void onResponse(Call<Result<People>> call, Response<Result<People>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
                }else{
                    data = new ArrayList<>();
                    ArrayList<People> results = response.body().getResults();
                    for(People people: results){
                        data.add(new Pair<String, String>(String.format("Height: %s Birth year: %s", people.getHeight(), people.getBirth_year()), people.getName()));
                    }
                    Adapter adapter = new Adapter(data);
                    recyclerView.setAdapter(adapter);
                }
            }
            @Override
            public void onFailure(Call<Result<People>> call, Throwable t) {
                Toast.makeText(getContext(), "Ha ocurrido un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}