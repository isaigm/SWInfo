package com.example.myapplication.db.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import com.example.myapplication.db.AppDataBase;
import com.example.myapplication.db.daos.TradicionDao;
import com.example.myapplication.db.entities.Tradicion;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TradicionRepository {
    private final TradicionDao tradicionDao;
    private final ExecutorService executorService;
    TradicionRepository(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        tradicionDao = db.tradicionDao();
    }
    public TradicionRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        tradicionDao = db.tradicionDao();
        executorService = Executors.newSingleThreadExecutor();
    }
    public LiveData<List<Tradicion>> getTradiciones() {
        return  tradicionDao.getAll();
    }

    public void addTradicion(Tradicion tradicion)
    {
        executorService.execute(() -> tradicionDao.insertAll(tradicion));
    }
    public void update(Tradicion tradicion){
        executorService.execute(() -> tradicionDao.update(tradicion));
    }
    public void delete(Tradicion tradicion)
    {
        executorService.execute(() -> tradicionDao.delete(tradicion));
    }

}
