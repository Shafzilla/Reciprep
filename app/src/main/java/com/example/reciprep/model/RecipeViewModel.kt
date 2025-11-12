package com.example.reciprep.model

import androidx.lifecycle.ViewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.reciprep.data.AppDatabase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import com.example.reciprep.data.Recipe
import com.example.reciprep.data.RecipeDAO
import kotlin.text.isEmpty
import kotlin.text.trim


class RecipeViewModel(private val recipeDao: RecipeDAO) : ViewModel() {

    val allRecipes: Flow<List<Recipe>> = recipeDao.getAll()

    fun addRecipe(
        name: String,
        ingredients: String,
        steps: String,
        prepTime: Int,
        cookTime: Int,
        servings: Int,
        photoPath: String
    ) {
        if (name.isEmpty() || ingredients.isEmpty() || steps.isEmpty()) {
            return
        }
        val recipe = Recipe(
            name = name.trim(),
            ingredients = ingredients.trim(),
            steps = steps.trim(),
            prepTime = prepTime,
            cookTime = cookTime,
            servings = servings,
            photoPath = photoPath.trim()
        )
        viewModelScope.launch {
            recipeDao.insert(recipe)
        }
    }

    fun deleteRecipe(recipe: Recipe) {
        viewModelScope.launch {
            recipeDao.delete(recipe)
        }
    }

    companion object {

        fun factory(db: AppDatabase) = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return RecipeViewModel(db.recipeDao()) as T
            }
        }
    }



}