package com.atabekdev.foodapp.presenter.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atabekdev.foodapp.domain.mapper.base.MyMapper
import com.atabekdev.foodapp.domain.models.Meal
import com.atabekdev.foodapp.domain.usecase.MainUseCase
import com.atabekdev.foodapp.presenter.models.MealUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase,
    private val mapper: MyMapper<Meal, MealUI>,
) : ViewModel() {

    private var _mealsResult = MutableLiveData<Result<List<MealUI>>>()
    val mealsResult: LiveData<Result<List<MealUI>>> get() = _mealsResult

    fun getFreshRecipes() {
        viewModelScope.launch {
            val meals = useCase.getFreshRecipe().map { listOfMeal ->
                listOfMeal.map {
                    mapper.mapFromEntity(it)
                }
            }
            _mealsResult.value = meals
        }
    }

}