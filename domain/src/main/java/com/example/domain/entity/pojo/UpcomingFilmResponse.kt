package com.example.domain.entity.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "up_coming_film")
data class UpcomingFilmResponse(
    @PrimaryKey
    val id: Int,
    val data: List<UpcomingFilms>

)