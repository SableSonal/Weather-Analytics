package com.weatherassignmentapplication.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface WeatherDetailsDao {

    @Query("SELECT * FROM WeatherDetailsEntity")
    List<WeatherDetailsEntity> getAll();

    @Insert
    void insert(WeatherDetailsEntity task);

}
