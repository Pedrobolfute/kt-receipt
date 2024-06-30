package com.example.appderestaurante_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appderestaurante_kotlin.adapter.FoodAdapter
import com.example.appderestaurante_kotlin.model.Food

import com.example.appderestaurante_kotlin.R.id.RecyclerViewFood
import com.example.appderestaurante_kotlin.model.RecipeStore


class SeeReceiptActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_receipt)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewRecipes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        val foodList = getFoodList()
        val adapter = FoodAdapter(this, foodList.toMutableList())
        recyclerView.adapter = adapter
    }

    private fun getFoodList(): List<Food>{

        val foodList = mutableListOf<Food>()
        for(i in RecipeStore.receiptNames.indices){
            val name = RecipeStore.receiptNames[i]
            val ingredients = RecipeStore.receiptIngredients[i]
            val preparation = RecipeStore.receiptPreparations[i]
            val foodDescription = preparation.take(50)
            foodList.add(Food(
                id = i,
                imgFood = R.drawable.cooking,
                foodName = name,
                foodDescription = foodDescription,
                price = ""
            ))
        }
        return foodList
    }
}