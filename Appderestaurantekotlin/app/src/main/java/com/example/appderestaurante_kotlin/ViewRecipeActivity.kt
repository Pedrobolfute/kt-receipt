
package com.example.appderestaurante_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appderestaurante_kotlin.model.RecipeStore

class ViewRecipeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_item_unit)

        val txtRecipeTitle: TextView = findViewById(R.id.txtFoodTitle)
        val txtReceiptIngredientsInfo: TextView = findViewById(R.id.txtReceiptIngredientsInfo)
        val txtReceiptIngredientsDescriptionInfo: TextView = findViewById(R.id.txtReceiptIngredientsDescriptionInfo)

        val recipeId = intent.getIntExtra("RECIPE_ID", -1)
        if (recipeId != -1) {
            val recipeName = RecipeStore.receiptNames[recipeId]
            val recipeIngredients = RecipeStore.receiptIngredients[recipeId]
            val recipePreparation = RecipeStore.receiptPreparations[recipeId]

            txtRecipeTitle.text = recipeName
            txtReceiptIngredientsInfo.text = recipeIngredients
            txtReceiptIngredientsDescriptionInfo.text = recipePreparation
        }
    }
}
