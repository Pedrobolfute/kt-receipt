package com.example.appderestaurante_kotlin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appderestaurante_kotlin.adapter.FoodAdapter
import com.example.appderestaurante_kotlin.model.Food
import com.example.appderestaurante_kotlin.model.RecipeStore
import com.example.appderestaurante_kotlin.util.JsonHelper
import com.google.android.material.textfield.TextInputEditText

class SeeReceiptActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private val foodList = mutableListOf<Food>()
    private val filteredFoodList = mutableListOf<Food>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_see_receipt)

        JsonHelper.loadRecipes(this)

        recyclerView = findViewById(R.id.recyclerViewRecipes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        adapter = FoodAdapter(this, filteredFoodList)
        recyclerView.adapter = adapter

        val searchEditText: EditText = findViewById(R.id.etSearch)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        updateFoodList()
    }

    private fun updateFoodList() {
        foodList.clear()
        foodList.addAll(getFoodList())
        filter("")
    }

    private fun filter(query: String) {
        val filteredList = if (query.isEmpty()) {
            foodList
        } else {
            foodList.filter {
                it.foodName!!.contains(query, ignoreCase = true)
            }
        }
        filteredFoodList.clear()
        filteredFoodList.addAll(filteredList)
        adapter.notifyDataSetChanged()
    }

    private fun getFoodList(): List<Food> {
        val foodList = mutableListOf<Food>()
        for (i in RecipeStore.receiptNames.indices) {
            val name = RecipeStore.receiptNames[i]
            val ingredients = RecipeStore.receiptIngredients[i]
            val preparation = RecipeStore.receiptPreparations[i]
            val foodDescription = preparation.take(50)
            foodList.add(
                Food(
                    id = i,
                    imgFood = R.drawable.cooking,
                    foodName = name,
                    foodDescription = foodDescription,
                    price = ""
                )
            )
        }
        return foodList
    }
}
