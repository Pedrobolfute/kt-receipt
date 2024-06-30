package com.example.appderestaurante_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.appderestaurante_kotlin.model.RecipeStore

class ViewRecipeActivity : AppCompatActivity() {

    private var recipeId: Int = -1
    private lateinit var txtRecipeTitle: TextView
    private lateinit var txtReceiptIngredientsInfo: TextView
    private lateinit var txtReceiptIngredientsDescriptionInfo: TextView
    private lateinit var btnEditReceipt: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food_item_unit)

        txtRecipeTitle = findViewById(R.id.txtFoodTitle)
        txtReceiptIngredientsInfo = findViewById(R.id.txtReceiptIngredientsInfo)
        txtReceiptIngredientsDescriptionInfo = findViewById(R.id.txtReceiptIngredientsDescriptionInfo)
        btnEditReceipt = findViewById(R.id.btnEditReceipt)

        recipeId = intent.getIntExtra("RECIPE_ID", -1)
        if (recipeId != -1) {
            updateRecipeDetails()
        }

        btnEditReceipt.setOnClickListener {
            val editIntent = Intent(this, EditRecipeActivity::class.java)
            editIntent.putExtra("RECIPE_ID", recipeId)
            startActivityForResult(editIntent, 1)
        }
    }

    private fun updateRecipeDetails() {
        if (recipeId != -1) {
            val recipeName = RecipeStore.receiptNames[recipeId]
            val recipeIngredients = RecipeStore.receiptIngredients[recipeId]
            val recipePreparation = RecipeStore.receiptPreparations[recipeId]

            txtRecipeTitle.text = recipeName
            txtReceiptIngredientsInfo.text = recipeIngredients
            txtReceiptIngredientsDescriptionInfo.text = recipePreparation
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            updateRecipeDetails() // Update the details after editing
        }
    }
}
