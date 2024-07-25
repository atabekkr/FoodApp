package com.atabekdev.foodapp.di

import com.atabekdev.foodapp.data.mapper.MealMapper
import com.atabekdev.foodapp.data.models.MealResponse
import com.atabekdev.foodapp.domain.mapper.base.MyMapper
import com.atabekdev.foodapp.domain.models.Meal
import com.atabekdev.foodapp.presenter.models.MealUI
import com.atabekdev.foodapp.presenter.ui.mapper.MealUIMapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MapperModule {

    @Binds
    abstract fun bindMealMapper(
        mapper: MealMapper,
    ) : MyMapper<MealResponse, Meal>

    @Binds
    abstract fun bindMealUIMapper(
        mapper: MealUIMapper,
    ) : MyMapper<Meal, MealUI>


}