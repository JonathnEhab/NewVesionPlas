package com.example.domain.entity.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "new_films")
data class NewFilmResponse(
    @PrimaryKey
    val id: Int,
    val data: List<NewFilms>

)