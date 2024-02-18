package com.example.data.online

import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.NewFilms
import com.example.domain.entity.pojo.UpcomingFilmResponse
import com.example.domain.entity.pojo.UpcomingFilms
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FilmsApiService {
    @GET("movies?page=9")
    suspend fun getNewFilmsFilms(): NewFilmResponse

    @GET("movies?page=8")
    suspend fun getUpcomingFilmsFilms(): UpcomingFilmResponse

    @GET("movies/{id}")
    suspend fun getNewFilmDetails(@Path("id") id: String): NewFilms

    @GET("movies")
    suspend fun findFilms(@Query("title") title: String): List<UpcomingFilms>

}