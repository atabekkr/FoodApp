package com.atabekdev.foodapp.domain.usecase

import com.atabekdev.foodapp.domain.models.Meal

interface MainUseCase {
    suspend fun getFreshRecipe(): Result<List<Meal>>
    suspend fun getMealById(id: Int): Result<Meal>
}