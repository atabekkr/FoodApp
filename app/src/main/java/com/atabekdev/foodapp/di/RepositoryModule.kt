package com.atabekdev.foodapp.di

import com.atabekdev.foodapp.data.repository.MainRepositoryImpl
import com.atabekdev.foodapp.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindOfferRepository(
        repository: MainRepositoryImpl,
    ): MainRepository

}