package com.example.myapplication.db.repositories;
import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.myapplication.db.AppDataBase;
import com.example.myapplication.db.daos.PlantaMedicinalDao;
import com.example.myapplication.db.entities.PlantaMedicinal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PlantaMedicinalRepository {
    private final PlantaMedicinalDao plantaMedicinalDao;
    private final ExecutorService executorService;
    PlantaMedicinalRepository(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        plantaMedicinalDao = db.plantaMedicinalDao();
    }
    public PlantaMedicinalRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        plantaMedicinalDao = db.plantaMedicinalDao();
        executorService = Executors.newSingleThreadExecutor();
    }
    public LiveData<List<PlantaMedicinal>> getPlantas() {
        return  plantaMedicinalDao.getAll();
    }

    public void addPlanta(PlantaMedicinal plantaMedicinal)
    {
        executorService.execute(() -> plantaMedicinalDao.insertAll(plantaMedicinal));
    }

    public void update(PlantaMedicinal plantaMedicinal){
        executorService.execute(() -> plantaMedicinalDao.update(plantaMedicinal));
    }
    public void delete(PlantaMedicinal plantaMedicinal)
    {
        executorService.execute(() -> plantaMedicinalDao.delete(plantaMedicinal));
    }

}
