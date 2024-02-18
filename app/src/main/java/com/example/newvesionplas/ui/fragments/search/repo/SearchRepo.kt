package com.example.newvesionplas.ui.fragments.search.repo

import androidx.lifecycle.MutableLiveData
import com.example.data.online.FilmsApiService
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.NewFilms
import com.example.domain.entity.pojo.UpcomingFilmResponse
import com.example.domain.entity.pojo.UpcomingFilms
import javax.inject.Inject

class SearchRepo @Inject constructor(private val filmsApiService: FilmsApiService) {
     val findFilm =MutableLiveData<List<UpcomingFilms> >()
    suspend fun search(  title :String) :List<UpcomingFilms> {
        return filmsApiService.findFilms(title)
    }
}