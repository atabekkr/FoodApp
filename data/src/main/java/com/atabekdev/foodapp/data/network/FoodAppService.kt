package com.atabekdev.foodapp.data.network

import com.atabekdev.foodapp.data.models.FreshRecipeResponse
import retrofit2.Response
import retrofit2.http.GET

interface FoodAppService {

    @GET("json/v1/1/search.php?s=k")
    suspend fun getFreshRecipes(): Response<FreshRecipeResponse>

}