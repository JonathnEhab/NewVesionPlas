package com.example.newvesionplas.di

import com.example.data.online.FilmsApiService
import com.example.data.repo.FilmsImpl
import com.example.domain.repo.FilmsRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepo(filmsApiService: FilmsApiService,  id :String ,   title :String): FilmsRepo {
        return FilmsImpl(filmsApiService,id,title)
    }
}