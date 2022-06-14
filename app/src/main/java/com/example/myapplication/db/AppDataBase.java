package com.example.myapplication.db;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.myapplication.db.daos.FaunaDao;
import com.example.myapplication.db.daos.FloraDao;
import com.example.myapplication.db.entities.Fauna;
import com.example.myapplication.db.entities.Flora;
import com.example.myapplication.db.entities.PlantaMedicinal;
import com.example.myapplication.db.entities.Tradicion;
import com.example.myapplication.db.daos.TradicionDao;
import com.example.myapplication.db.daos.PlantaMedicinalDao;


@Database(entities = {PlantaMedicinal.class, Tradicion.class, Flora.class, Fauna.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase instance;
    public static synchronized  AppDataBase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "db")
                    .createFromAsset("db.db")
                    .build();
        }
        return instance;
    }
    public abstract PlantaMedicinalDao plantaMedicinalDao();
    public abstract TradicionDao tradicionDao();
    public abstract FloraDao floraDao();
    public abstract FaunaDao faunaDao();
}