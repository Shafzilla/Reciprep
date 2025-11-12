package com.example.reciprep.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "recipes")
data class Recipe(
    @PrimaryKey(autoGenerate = true) val recipeId: Int = 0,
    val name: String,
    val ingredients: String,
    val steps: String,
    val prepTime: Int,
    val cookTime: Int,
    val servings: Int,
    val photoPath: String) {
}