package com.atabekdev.foodapp.presenter.ui.mapper

import com.atabekdev.foodapp.domain.mapper.base.MyMapper
import com.atabekdev.foodapp.domain.models.Meal
import com.atabekdev.foodapp.presenter.models.MealUI
import javax.inject.Inject

class MealUIMapper @Inject constructor() : MyMapper<Meal, MealUI> {
    override fun mapFromEntity(from: Meal) = from.run {
        MealUI(
            idMeal,
            strArea,
            nameOfMeal,
            strCategory,
            instruction
        )
    }
}