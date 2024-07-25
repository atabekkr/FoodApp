package com.atabekdev.foodapp.data.network

import com.atabekdev.foodapp.data.models.FreshRecipeResponse
import com.atabekdev.foodapp.data.models.MealResponse
import com.atabekdev.foodapp.domain.models.Meal
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodAppService {

    @GET("json/v1/1/search.php?s=k")
    suspend fun getFreshRecipes(): Response<FreshRecipeResponse>

    @GET("json/v1/1/lookup.php?i")
    suspend fun getMealById(@Query("i") id: Int): Response<FreshRecipeResponse>

}