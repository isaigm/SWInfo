package com.example.myapplication.db.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Tradicion {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "nombre")
    public String nombre;

    @ColumnInfo(name = "fecha_de_celebracion")
    public String fechaDeCelebracion;

    @ColumnInfo(name = "tipo")
    public String tipo;

    @ColumnInfo(name = "descripcion")
    public String descripcion;
}
