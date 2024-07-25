package com.atabekdev.foodapp.domain.repository

import com.atabekdev.foodapp.domain.models.Meal

interface MainRepository {

    suspend fun getFreshRecipes(): Result<List<Meal>>

}