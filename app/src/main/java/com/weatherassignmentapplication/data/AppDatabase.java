package com.weatherassignmentapplication.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


//database
@Database(entities = {WeatherDetailsEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WeatherDetailsDao weatherDetailsDao();
}


