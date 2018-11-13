package com.example.nacho.room_livedata_viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ClaseDao {

    @Insert
    void insert(Clase clase);

    @Query("DELETE FROM clases_table")
    void deleteAll();

    @Query("SELECT * from clases_table ORDER BY nombre ASC")
    LiveData<List<Clase>> getAllClases();
}
