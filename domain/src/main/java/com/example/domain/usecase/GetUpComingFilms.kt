package com.example.domain.usecase

import com.example.domain.repo.FilmsRepo

class GetUpComingFilms   (private val filmsRepo: FilmsRepo){
    suspend operator fun invoke() = filmsRepo.getUpComingFromRemote()
}