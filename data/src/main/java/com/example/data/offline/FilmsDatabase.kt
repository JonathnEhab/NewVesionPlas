package com.example.data.offline

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.offline.converters.NewFilmsConverters
import com.example.data.offline.converters.UpcomingFilmsConverters
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.UpcomingFilmResponse

@Database(entities = [NewFilmResponse::class, UpcomingFilmResponse::class], version = 1, exportSchema = false)
@TypeConverters(NewFilmsConverters::class, UpcomingFilmsConverters::class)
abstract class FilmsDatabase : RoomDatabase() {
    abstract fun filmsDao(): MyDao
}