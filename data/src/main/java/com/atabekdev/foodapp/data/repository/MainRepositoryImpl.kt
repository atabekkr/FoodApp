package com.atabekdev.foodapp.data.repository

import android.util.Log
import com.atabekdev.foodapp.data.models.MealResponse
import com.atabekdev.foodapp.data.network.FoodAppService
import com.atabekdev.foodapp.domain.mapper.base.MyMapper
import com.atabekdev.foodapp.domain.models.Meal
import com.atabekdev.foodapp.domain.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: FoodAppService,
    private val mapper: MyMapper<MealResponse, Meal>,
) : MainRepository {
    override suspend fun getFreshRecipes(): Result<List<Meal>> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = api.getFreshRecipes()
            val responseBody = response.body()?.meals
            if (response.isSuccessful && responseBody != null) {
                val meals = responseBody.map { mapper.mapFromEntity(it) }
                Result.success(meals)
            } else {
                val message = response.message()
                Result.failure(Exception(message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getMealById(id: Int): Result<Meal> = withContext(Dispatchers.IO) {
        return@withContext try {
            val response = api.getMealById(id)
            val responseBody = response.body()?.meals?.getOrNull(0)
            if (response.isSuccessful && responseBody != null) {
                val meal = mapper.mapFromEntity(responseBody)
                Result.success(meal)
            } else {
                val message = response.message()
                Result.failure(Exception(message))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


}