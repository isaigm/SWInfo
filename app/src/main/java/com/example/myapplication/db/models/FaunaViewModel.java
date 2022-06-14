package com.example.myapplication.db.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.myapplication.db.entities.Fauna;
import com.example.myapplication.db.repositories.FaunaRepository;

import java.util.List;

public class FaunaViewModel extends AndroidViewModel {
    private final FaunaRepository faunaRepository;
    private final LiveData<List<Fauna>> fauna;
    public FaunaViewModel(@NonNull Application application) {
        super(application);
        faunaRepository = new FaunaRepository(application);
        fauna = faunaRepository.getFauna();

    }
    public LiveData<List<Fauna>> getFauna() {
        return fauna;
    }
    public void addPlanta(Fauna fauna) {
        faunaRepository.addFauna(fauna);
    }
    public void update(Fauna fauna) {
        faunaRepository.update(fauna);
    }
    public void delete(Fauna fauna) {
        faunaRepository.delete(fauna);
    }
}
