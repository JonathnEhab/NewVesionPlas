package com.example.data.offline.converters

import androidx.room.TypeConverter
import com.example.domain.entity.pojo.NewFilms
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class NewFilmsConverters {
    private val gson = Gson()

    @TypeConverter
    fun fromFilmList(films: List<NewFilms>?): String? {
        return films?.let {
            gson.toJson(films
            )}
    }

    @TypeConverter
    fun toFilmList(filmsString: String?): List<NewFilms>? {
        val type = object: TypeToken<List<NewFilms>>() {}.type
        return gson.fromJson<List<NewFilms>>(filmsString, type)
    }
}