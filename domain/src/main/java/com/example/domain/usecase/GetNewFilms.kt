package com.example.domain.usecase

import com.example.domain.repo.FilmsRepo

class GetNewFilms (private val filmsRepo: FilmsRepo) {
    suspend operator fun invoke() = filmsRepo.getFilmsFromRemote()



}