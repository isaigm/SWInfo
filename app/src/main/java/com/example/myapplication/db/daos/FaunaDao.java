package com.example.myapplication.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.db.entities.Fauna;
import com.example.myapplication.db.entities.PlantaMedicinal;

import java.util.List;

@Dao
public interface FaunaDao {
    @Query("SELECT * FROM fauna")
    LiveData<List<Fauna>> getAll();

    @Query("SELECT * FROM fauna WHERE uid IN (:ids)")
    LiveData<List<Fauna>> loadAllByIds(int[] ids);

    @Insert
    void insertAll(Fauna... fauna);

    @Delete
    void delete(Fauna fauna);
    @Update
    void update(Fauna fauna);
}