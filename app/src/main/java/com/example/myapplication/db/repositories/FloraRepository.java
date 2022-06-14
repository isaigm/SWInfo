package com.example.myapplication.db.repositories;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import com.example.myapplication.db.AppDataBase;
import com.example.myapplication.db.daos.FloraDao;
import com.example.myapplication.db.entities.Flora;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FloraRepository {
    private final FloraDao floraDao;
    private final ExecutorService executorService;
    FloraRepository(Application application) {
        AppDataBase db = AppDataBase.getInstance(application);
        executorService = Executors.newSingleThreadExecutor();
        floraDao = db.floraDao();
    }
    public FloraRepository(Context context) {
        AppDataBase db = AppDataBase.getInstance(context);
        floraDao = db.floraDao();
        executorService = Executors.newSingleThreadExecutor();
    }
    public LiveData<List<Flora>> getFlora() {
        return  floraDao.getAll();
    }

    public void addFlora(Flora flora)
    {
        executorService.execute(() -> floraDao.insertAll(flora));
    }

    public void update(Flora flora){
        executorService.execute(() -> floraDao.update(flora));
    }
    public void delete(Flora flora)
    {
        executorService.execute(() -> floraDao.delete(flora));
    }

}
