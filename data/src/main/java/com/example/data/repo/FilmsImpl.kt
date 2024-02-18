package com.example.data.repo

import com.example.data.online.FilmsApiService
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.NewFilms
import com.example.domain.entity.pojo.UpcomingFilmResponse
import com.example.domain.entity.pojo.UpcomingFilms
import com.example.domain.repo.FilmsRepo
import com.example.domain.usecase.GetNewFilms


class FilmsImpl(private val filmsApiService: FilmsApiService,private val id :String , private val title :String): FilmsRepo {
    override suspend fun getFilmsFromRemote(): NewFilmResponse = filmsApiService.getNewFilmsFilms()
    override suspend fun getUpComingFromRemote(): UpcomingFilmResponse =filmsApiService.getUpcomingFilmsFilms()
    override suspend fun getFilmDetails(): NewFilms = filmsApiService.getNewFilmDetails(id)
    override suspend fun findFilm(): List<UpcomingFilms>  = filmsApiService.findFilms(title)
}