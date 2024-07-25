package com.atabekdev.foodapp.di

import com.atabekdev.foodapp.domain.repository.MainRepository
import com.atabekdev.foodapp.domain.usecase.MainUseCase
import com.atabekdev.foodapp.domain.usecase.MainUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun bindOfferUseCase(
        repo: MainRepository,
    ): MainUseCase {
        return MainUseCaseImpl(repo)
    }

}