package com.atabekdev.foodapp.data.mapper

import com.atabekdev.foodapp.data.models.MealResponse
import com.atabekdev.foodapp.domain.mapper.base.MyMapper
import com.atabekdev.foodapp.domain.models.Meal
import javax.inject.Inject

class MealMapper @Inject constructor() : MyMapper<MealResponse, Meal> {
    override fun mapFromEntity(from: MealResponse) = from.run {
        Meal(
            idMeal,
            strArea,
            nameOfMeal = strMeal,
            strCategory
        )
    }
}