package com.example.appderestaurante_kotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ViewRecipeActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_item_unit)

        val txtRecipeTitle: TextView = findViewById(R.id.txtFoodTitle)
        val txtReceiptIngredientsInfo: TextView = findViewById(R.id.txtReceiptIngredientsInfo)
        val txtReceiptIngredientsDescriptionInfo: TextView = findViewById(R.id.txtReceiptIngredientsDescriptionInfo)

        val recipeName = intent.getStringExtra("RECIPE_NAME")
        val recipeDescription = intent.getStringExtra("RECIPE_DESCRIPTION")
        val recipePrice = intent.getStringExtra("RECIPE_PRICE")


        txtRecipeTitle.text = recipeName
        txtReceiptIngredientsDescriptionInfo.text = recipeDescription
        txtReceiptIngredientsInfo.text = recipePrice
    }
}