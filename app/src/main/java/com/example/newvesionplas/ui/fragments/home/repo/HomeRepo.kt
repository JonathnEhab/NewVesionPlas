package com.example.newvesionplas.ui.fragments.home.repo

import androidx.lifecycle.MutableLiveData
import com.example.data.offline.MyDao
import com.example.data.online.FilmsApiService
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.NewFilms
import com.example.domain.entity.pojo.UpcomingFilmResponse
import javax.inject.Inject

class HomeRepo @Inject constructor(private val apiService: FilmsApiService, val dao: MyDao) {
    val newFilmLiveData = MutableLiveData<NewFilmResponse>()
    val upComingFilmsLiveData = MutableLiveData<UpcomingFilmResponse>()




    suspend fun setNewFilms() {
        val newFilms = apiService.getNewFilmsFilms()
        newFilmLiveData.postValue(newFilms)
        dao.insertNewFilms(newFilms)
    }
    suspend fun getNewFilm() {
        val newFilms = dao.getNewFilms()
        newFilmLiveData.postValue(newFilms)
    }

    suspend fun setUpcoming() {
        val uPComingFilms = apiService.getUpcomingFilmsFilms()
        upComingFilmsLiveData.postValue(uPComingFilms)
        dao.insertUpComingFilms(uPComingFilms)
    }

    suspend fun getUpComingFilm() {
        val uPComingFilms = dao.getUpComingFilms()
        upComingFilmsLiveData.postValue(uPComingFilms)
     //   Log.d("TAG", "getUpComingFilm: "+uPComingFilms.data)
    }

    suspend fun getNewFilmDetails(id :String): NewFilms {
        return apiService.getNewFilmDetails(id)
    }


}