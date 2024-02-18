package com.example.domain.entity.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "up_coming_film")
data class UpcomingFilms (
    @PrimaryKey
    val id: Int,

    val country: String,
    val genres: List<String>,

    val images: List<String>,

    val imdb_rating: String,

    val poster: String,

    val title: String,

    val year: String
)