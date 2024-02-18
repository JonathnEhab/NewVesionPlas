package com.example.domain.usecase

import com.example.domain.repo.FilmsRepo

class FilmDetails(private val filmsRepo: FilmsRepo) {
    suspend operator fun invoke() = filmsRepo.getFilmDetails()
}