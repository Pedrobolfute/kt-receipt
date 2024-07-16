package com.example.appderestaurante_kotlin.util

import android.content.Context
import com.example.appderestaurante_kotlin.model.RecipeStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.FileReader
import java.io.FileWriter

object JsonHelper {
    private const val FILE_NAME = "recipes.json"

    fun saveRecipes(context: Context) {
        val file = File(context.filesDir, FILE_NAME)
        val gson = Gson()
        val recipesMap = mapOf(
            "names" to RecipeStore.receiptNames,
            "ingredients" to RecipeStore.receiptIngredients,
            "preparations" to RecipeStore.receiptPreparations
        )
        val jsonString = gson.toJson(recipesMap)
        FileWriter(file).use { it.write(jsonString) }
    }

    fun loadRecipes(context: Context) {
        val file = File(context.filesDir, FILE_NAME)
        if (file.exists()) {
            val gson = Gson()
            val type = object : TypeToken<Map<String, List<String>>>() {}.type
            val jsonString = FileReader(file).use { it.readText() }
            val recipesMap: Map<String, List<String>> = gson.fromJson(jsonString, type)
            RecipeStore.receiptNames.clear()
            RecipeStore.receiptNames.addAll(recipesMap["names"] ?: listOf())
            RecipeStore.receiptIngredients.clear()
            RecipeStore.receiptIngredients.addAll(recipesMap["ingredients"] ?: listOf())
            RecipeStore.receiptPreparations.clear()
            RecipeStore.receiptPreparations.addAll(recipesMap["preparations"] ?: listOf())
        }
    }

    fun removeRecipe(context: Context, index: Int) {
        if (index in RecipeStore.receiptNames.indices) {
            RecipeStore.receiptNames.removeAt(index)
            RecipeStore.receiptIngredients.removeAt(index)
            RecipeStore.receiptPreparations.removeAt(index)
            saveRecipes(context)
        }
    }
}
