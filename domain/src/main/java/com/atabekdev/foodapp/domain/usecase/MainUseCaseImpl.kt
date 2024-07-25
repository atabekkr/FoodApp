package com.atabekdev.foodapp.domain.usecase

import com.atabekdev.foodapp.domain.models.Meal
import com.atabekdev.foodapp.domain.repository.MainRepository

class MainUseCaseImpl(
    private val repository: MainRepository,
) : MainUseCase {
    override suspend fun getFreshRecipe(): Result<List<Meal>> {
        return repository.getFreshRecipes()
    }

    override suspend fun getMealById(id: Int): Result<Meal> {
        return repository.getMealById(id)
    }
}