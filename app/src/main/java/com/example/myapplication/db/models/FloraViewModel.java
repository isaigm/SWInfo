package com.example.myapplication.db.models;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.myapplication.db.entities.Flora;
import com.example.myapplication.db.repositories.FloraRepository;

import java.util.List;

public class FloraViewModel extends AndroidViewModel {
    private final FloraRepository floraRepository;
    private final LiveData<List<Flora>> flora;
    public FloraViewModel(@NonNull Application application) {
        super(application);
        floraRepository = new FloraRepository(application);
        flora = floraRepository.getFlora();

    }
    public LiveData<List<Flora>> getFlora() {
        return flora;
    }
    public void addFlora(Flora flora) {
        floraRepository.addFlora(flora);
    }
    public void update(Flora flora) {
        floraRepository.update(flora);
    }
    public void delete(Flora flora) {
        floraRepository.delete(flora);
    }
}
