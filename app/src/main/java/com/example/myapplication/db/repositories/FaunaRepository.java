package com.example.myapplication.db.repositories;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.myapplication.db.AppDataBase;
import com.example.myapplication.db.daos.FaunaDao;
import com.example.myapplication.db.entities.Fauna;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FaunaRepository {
    private final FaunaDao faunaDao;
    private final ExecutorService executorService;
    FaunaRepository(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        faunaDao = db.faunaDao();
    }
    public FaunaRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        faunaDao = db.faunaDao();
        executorService = Executors.newSingleThreadExecutor();
    }
    public LiveData<List<Fauna>> getFauna() {
        return  faunaDao.getAll();
    }

    public void addFauna(Fauna fauna)
    {
        executorService.execute(() -> faunaDao.insertAll(fauna));
    }

    public void update(Fauna fauna){
        executorService.execute(() -> faunaDao.update(fauna));
    }
    public void delete(Fauna fauna)
    {
        executorService.execute(() -> faunaDao.delete(fauna));
    }

}
