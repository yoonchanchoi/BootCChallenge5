package com.example.bootcchallenge5.data.di

import com.example.bootcchallenge5.data.repository.DefaultSearchRepository
import com.example.bootcchallenge5.data.repository.DefaultSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class SearchRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindSearchManager(searchManagerImpl: DefaultSearchRepositoryImpl): DefaultSearchRepository

}