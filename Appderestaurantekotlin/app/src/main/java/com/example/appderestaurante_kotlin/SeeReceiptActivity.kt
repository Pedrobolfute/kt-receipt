package com.example.appderestaurante_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appderestaurante_kotlin.adapter.FoodAdapter
import com.example.appderestaurante_kotlin.model.Food
import com.example.appderestaurante_kotlin.model.RecipeStore

class SeeReceiptActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private val foodList = mutableListOf<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_receipt)

        recyclerView = findViewById(R.id.recyclerViewRecipes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        adapter = FoodAdapter(this, foodList)
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        updateFoodList()
    }

    private fun updateFoodList() {
        foodList.clear()
        foodList.addAll(getFoodList())
        adapter.notifyDataSetChanged()
    }

    private fun getFoodList(): List<Food> {
        val foodList = mutableListOf<Food>()
        for (i in RecipeStore.receiptNames.indices) {
            val name = RecipeStore.receiptNames[i]
            val ingredients = RecipeStore.receiptIngredients[i]
            val preparation = RecipeStore.receiptPreparations[i]
            foodList.add(
                Food(
                    id = i,
                    imgFood = R.drawable.cooking,
                    foodName = name,
                    foodDescription = preparation,
                    ingredients = ingredients
                )
            )
        }
        return foodList
    }
}
