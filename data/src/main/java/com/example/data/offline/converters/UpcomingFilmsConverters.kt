package com.example.data.offline.converters

import androidx.room.TypeConverter
import com.example.domain.entity.pojo.UpcomingFilms
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class UpcomingFilmsConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromFilmList(films: List<UpcomingFilms>?): String? {
        return films?.let {gson.toJson(films)}
    }

    @TypeConverter
    fun toFilmList(filmsString: String?): List<UpcomingFilms>? {
        val type = object: TypeToken<List<UpcomingFilms>>() {}.type
        return gson.fromJson<List<UpcomingFilms>>(filmsString, type)
    }
}