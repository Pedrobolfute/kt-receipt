package com.example.appderestaurante_kotlin
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appderestaurante_kotlin.model.RecipeStore
import com.example.appderestaurante_kotlin.util.JsonHelper

class AddReceiptActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_receipt)

        val receiptName: EditText = findViewById(R.id.receiptName)
        val receiptIngredients: EditText = findViewById(R.id.receiptIngredients)
        val receiptPrepare: EditText = findViewById(R.id.receiptPrepare)
        val btnAddReceipt: Button = findViewById(R.id.btnAddReceipt)

        btnAddReceipt.setOnClickListener{
            val name = receiptName.text.toString()
            val ingredients = receiptIngredients.text.toString()
            val preparation = receiptPrepare.text.toString()

            if(name.isNotEmpty() && ingredients.isNotEmpty() && preparation.isNotEmpty()){
                RecipeStore.receiptNames.add(name)
                RecipeStore.receiptIngredients.add(ingredients)
                RecipeStore.receiptPreparations.add(preparation)

                JsonHelper.saveRecipes(this)

                receiptName.text.clear()
                receiptIngredients.text.clear()
                receiptPrepare.text.clear()

                Toast.makeText(this, "Receita adicionada!", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

