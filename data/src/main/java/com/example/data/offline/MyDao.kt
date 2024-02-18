package com.example.data.offline

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.UpcomingFilmResponse

@Dao
interface MyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNewFilms(films: NewFilmResponse)

    @Query("SELECT * FROM new_films ")
    suspend fun getNewFilms(): NewFilmResponse

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUpComingFilms(films: UpcomingFilmResponse)

    @Query("SELECT * FROM up_coming_film ")
    suspend fun getUpComingFilms(): UpcomingFilmResponse

}