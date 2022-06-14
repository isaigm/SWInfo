package com.example.myapplication.db.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.myapplication.db.entities.Flora;
import java.util.List;

@Dao
public interface FloraDao {
    @Query("SELECT * FROM flora")
    LiveData<List<Flora>> getAll();
    @Query("SELECT * FROM flora WHERE uid IN (:ids)")
    LiveData<List<Flora>> loadAllByIds(int[] ids);
    @Insert
    void insertAll(Flora... flora);
    @Delete
    void delete(Flora flora);
    @Update
    void update(Flora flora);
}
