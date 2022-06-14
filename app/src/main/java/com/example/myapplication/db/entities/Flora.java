package com.example.myapplication.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Flora {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "nombre")
    public String nombre;
    @ColumnInfo(name = "características")
    public String caracteristicas;
}
