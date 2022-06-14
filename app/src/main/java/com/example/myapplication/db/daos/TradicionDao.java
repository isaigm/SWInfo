package com.example.myapplication.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.myapplication.db.entities.Tradicion;

import java.util.List;

@Dao
public interface TradicionDao {
    @Query("SELECT * FROM tradicion")
    LiveData<List<Tradicion>> getAll();
    @Query("SELECT * FROM tradicion WHERE uid IN (:ids)")
    LiveData<List<Tradicion>> loadAllByIds(int[] ids);
    @Insert
    void insertAll(Tradicion... tradiciones);
    @Delete
    void delete(Tradicion tradicion);
    @Update
    void update(Tradicion tradicion);
}
