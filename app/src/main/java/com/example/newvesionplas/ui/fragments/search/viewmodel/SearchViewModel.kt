package com.example.newvesionplas.ui.fragments.search.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.pojo.NewFilmResponse
import com.example.domain.entity.pojo.NewFilms
import com.example.domain.entity.pojo.UpcomingFilmResponse
import com.example.domain.entity.pojo.UpcomingFilms
import com.example.newvesionplas.ui.fragments.search.repo.SearchRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor( private val searchRepo: SearchRepo)  :ViewModel(){
    private val _findFilm =MutableLiveData<List<UpcomingFilms> >()
    val findFilm : MutableLiveData<List<UpcomingFilms> > get()  = _findFilm

    fun findFilm(title : String){
        viewModelScope.launch {
            try {
                _findFilm.value=searchRepo.search(title)
            }catch (e :Exception){
                Log.e("TAG", "error is: $e ", )
            }
        }
    }
}