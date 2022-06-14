package com.example.myapplication.db.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.db.entities.PlantaMedicinal;
import com.example.myapplication.db.repositories.PlantaMedicinalRepository;

import java.util.List;

public class PlantaMedicinalViewModel extends AndroidViewModel {
    private final PlantaMedicinalRepository plantaMedicinalRepository;
    private final LiveData<List<PlantaMedicinal>> plantas;
    public PlantaMedicinalViewModel(@NonNull Application application) {
        super(application);
        plantaMedicinalRepository = new PlantaMedicinalRepository(application);
        plantas = plantaMedicinalRepository.getPlantas();

    }
    public LiveData<List<PlantaMedicinal>> getPlantas() {
        return plantas;
    }
    public void addPlanta(PlantaMedicinal planta) {
        plantaMedicinalRepository.addPlanta(planta);
    }
    public void update(PlantaMedicinal planta) {
        plantaMedicinalRepository.update(planta);
    }
    public void delete(PlantaMedicinal planta) {
        plantaMedicinalRepository.delete(planta);
    }
}
