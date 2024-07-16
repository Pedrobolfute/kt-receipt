package com.example.appderestaurante_kotlin

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appderestaurante_kotlin.model.RecipeStore
import com.example.appderestaurante_kotlin.util.JsonHelper

class EditRecipeActivity : AppCompatActivity() {

    private lateinit var edtRecipeName: EditText
    private lateinit var edtRecipeIngredients: EditText
    private lateinit var edtRecipePrepare: EditText
    private lateinit var btnEditReceipt: Button

    private var recipeId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_receipt)

        edtRecipeName = findViewById(R.id.receiptName)
        edtRecipeIngredients = findViewById(R.id.receiptIngredients)
        edtRecipePrepare = findViewById(R.id.receiptPrepare)
        btnEditReceipt = findViewById(R.id.btnAddReceipt)

        recipeId = intent.getIntExtra("RECIPE_ID", -1)
        if (recipeId != -1) {
            val recipeName = RecipeStore.receiptNames[recipeId]
            val recipeIngredients = RecipeStore.receiptIngredients[recipeId]
            val recipePreparation = RecipeStore.receiptPreparations[recipeId]

            edtRecipeName.setText(recipeName)
            edtRecipeIngredients.setText(recipeIngredients)
            edtRecipePrepare.setText(recipePreparation)
        }

        btnEditReceipt.setOnClickListener {
            saveRecipeChanges()
        }
    }

    private fun saveRecipeChanges() {
        val recipeName = edtRecipeName.text.toString().trim()
        val recipeIngredients = edtRecipeIngredients.text.toString().trim()
        val recipePreparation = edtRecipePrepare.text.toString().trim()

        if (recipeName.isEmpty() || recipeIngredients.isEmpty() || recipePreparation.isEmpty()) {
            Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show()
            return
        }

        if (recipeId != -1) {
            RecipeStore.receiptNames[recipeId] = recipeName
            RecipeStore.receiptIngredients[recipeId] = recipeIngredients
            RecipeStore.receiptPreparations[recipeId] = recipePreparation

            JsonHelper.saveRecipes(this)
            setResult(Activity.RESULT_OK) // Indicate success
            finish() // Finish the activity and go back
        }
    }
}
