package com.example.domain.usecase

import com.example.domain.repo.FilmsRepo

class FindFilm(private val filmsRepo: FilmsRepo) {
    suspend operator fun invoke()= filmsRepo.findFilm()
}