package com.example.newvesionplas.ui.fragments.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.UpcomingFilmResponse
import com.example.newvesionplas.ui.fragments.home.repo.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeRepo: HomeRepo) : ViewModel() {
    var newFilmLiveData : LiveData<NewFilmResponse> = homeRepo.newFilmLiveData
    var upComingLiveData  : LiveData<UpcomingFilmResponse> = homeRepo.upComingFilmsLiveData
    fun newFilms() {
        viewModelScope.launch {
            try {
                homeRepo.setNewFilms()
            } catch (e: Exception) {
                homeRepo.getNewFilm()
            }
        }
    }
    fun upComingFilms() {
        viewModelScope.launch {
            try {
                homeRepo.setUpcoming()
            } catch (e: Exception) {
                homeRepo.getUpComingFilm()
            }
        }
    }

}
