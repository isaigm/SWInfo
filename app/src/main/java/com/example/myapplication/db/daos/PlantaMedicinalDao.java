package com.example.myapplication.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.myapplication.db.entities.PlantaMedicinal;

import java.util.List;

@Dao
public interface PlantaMedicinalDao {
    @Query("SELECT * FROM plantamedicinal")
    LiveData<List<PlantaMedicinal>> getAll();

    @Query("SELECT * FROM plantamedicinal WHERE uid IN (:ids)")
    LiveData<List<PlantaMedicinal>> loadAllByIds(int[] ids);

    @Insert
    void insertAll(PlantaMedicinal... plantas);

    @Delete
    void delete(PlantaMedicinal plantaMedicinal);
    @Update
    void update(PlantaMedicinal plantaMedicinal);
}
