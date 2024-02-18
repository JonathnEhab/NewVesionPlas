package com.example.newvesionplas.di

import android.content.Context
import androidx.room.Room
import com.example.data.offline.FilmsDatabase
import com.example.data.offline.MyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Singleton
    @Provides
    fun getRoomInstance (@ApplicationContext context: Context) : FilmsDatabase {
        return Room.databaseBuilder(context
            , FilmsDatabase::class.java
            , "Posts Database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun getMyDao (roomDataBase : FilmsDatabase) : MyDao {
        return roomDataBase.filmsDao()
    }
}