package com.example.reciprep.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDAO {

    @Query("SELECT * FROM recipes")
    fun getAll(): Flow<List<Recipe>>

    @Query("SELECT COUNT(*) FROM recipes")
    fun countAllRecipesSync(): Int

    @Insert
    suspend fun insert(recipe: Recipe)

    @Delete
    suspend fun delete(recipe: Recipe)

}