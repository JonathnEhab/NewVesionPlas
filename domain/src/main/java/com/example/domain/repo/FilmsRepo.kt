package com.example.domain.repo

import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.NewFilms
import com.example.domain.entity.pojo.UpcomingFilmResponse
import com.example.domain.entity.pojo.UpcomingFilms

interface FilmsRepo {
    suspend fun getFilmsFromRemote(): NewFilmResponse
    suspend fun getUpComingFromRemote(): UpcomingFilmResponse
    suspend fun getFilmDetails():NewFilms
    suspend fun findFilm() : List<UpcomingFilms>


}