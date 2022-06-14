package com.example.myapplication.db.models;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.example.myapplication.db.entities.Tradicion;
import com.example.myapplication.db.repositories.TradicionRepository;
import java.util.List;

public class TradicionViewModel extends AndroidViewModel {
    private final TradicionRepository tradicionRepository;
    private final LiveData<List<Tradicion>> tradiciones;
    public TradicionViewModel(@NonNull Application application) {
        super(application);
        tradicionRepository = new TradicionRepository(application);
        tradiciones = tradicionRepository.getTradiciones();
    }
    public LiveData<List<Tradicion>> getTradiciones() {
        return tradiciones;
    }
    public void addTradicion(Tradicion tradicion) {
        tradicionRepository.addTradicion(tradicion);
    }
    public void update(Tradicion tradicion) {
        tradicionRepository.update(tradicion);
    }
    public void delete(Tradicion tradicion) {
        tradicionRepository.delete(tradicion);
    }
}
