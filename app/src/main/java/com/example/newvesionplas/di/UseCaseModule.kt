package com.example.newvesionplas.di

import com.example.domain.repo.FilmsRepo
import com.example.domain.usecase.GetNewFilms
import com.example.domain.usecase.GetUpComingFilms
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(filmsRepo: FilmsRepo): GetNewFilms {
        return GetNewFilms(filmsRepo)
    }
    @Provides
    fun provideUseCase_2(filmsRepo: FilmsRepo): GetUpComingFilms {
        return GetUpComingFilms(filmsRepo)
    }
}