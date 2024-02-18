package com.example.newvesionplas.ui.fragments.details.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.pojo.NewFilms
import com.example.newvesionplas.ui.fragments.home.repo.HomeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetalisViewModel@Inject constructor(private val homeRepo: HomeRepo) : ViewModel()  {

    private val _filmDetails = MutableLiveData<NewFilms>()
    val filmDetails : MutableLiveData<NewFilms> get() = _filmDetails
    fun getFilmDetails(filmId :String){
        viewModelScope.launch {
            try {
                _filmDetails.value=homeRepo.getNewFilmDetails(filmId)
            }catch (e : java.lang.Exception){
                Log.e("TAG", "getFilmDetails: "+e.message )
            }
        }
    }
}