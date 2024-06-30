package com.example.appderestaurante_kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appderestaurante_kotlin.adapter.FoodAdapter
import com.example.appderestaurante_kotlin.databinding.ActivityMainBinding
import com.example.appderestaurante_kotlin.model.Food



class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var foodAdapter: FoodAdapter
    private val foodList: MutableList<Food> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        val recyclerViewFood: RecyclerView = binding.RecyclerViewFood
        recyclerViewFood.layoutManager = LinearLayoutManager(this)
        recyclerViewFood.setHasFixedSize(true)
        foodAdapter = FoodAdapter(this, foodList)
        recyclerViewFood.adapter = foodAdapter
        getFood()

        setContentView(R.layout.initial_page)

        val btnAddReceipt: Button = findViewById(R.id.btnAddReceipt)
        btnAddReceipt.setOnClickListener {
            val intent = Intent(this, AddReceiptActivity::class.java)
            startActivity(intent)
        }

        val btnSeeReceipts: Button = findViewById(R.id.btnSeeReceipts)
        btnSeeReceipts.setOnClickListener{
            val intent = Intent(this, SeeReceiptActivity::class.java)
            startActivity(intent)
        }

        val btnEditReceipt : Button = findViewById(R.id.btnEditReceipt)
        btnEditReceipt.setOnClickListener{
            val intent = Intent(this, EditReceiptActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getFood(){
        val food1 = Food(
            imgFood = R.drawable.food1,
            foodName = "Food Name 1",
            foodDescription = "frefreo erfnrei frefoierf freiofre frefie",
            price = "$ 120.00",
            id = null
        )
        foodList.add(food1)

        val food2 = Food(
            imgFood = R.drawable.food2,
            foodName = "Food Name 2",
            foodDescription = "frefreo erfnrei frefoierf freiofre frefie",
            price = "$ 80.00",
            id = null
        )
        foodList.add(food2)

        val food3 = Food(
            imgFood = R.drawable.food3,
            foodName = "Food Name 3",
            foodDescription = "frefreo erfnrei frefoierf freiofre frefie",
            price = "$ 75.00",
            id = null
        )
        foodList.add(food3)

        val food4 = Food(
            imgFood = R.drawable.food4,
            foodName = "Food Name 4",
            foodDescription = "frefreo erfnrei frefoierf freiofre frefie",
            price = "$ 45.00",
            id = null
        )
        foodList.add(food4)

        val food5 = Food(
            imgFood = R.drawable.food5,
            foodName = "Food Name 5",
            foodDescription = "frefreo erfnrei frefoierf freiofre frefie",
            price = "$ 50.00",
            id = null
        )
        foodList.add(food5)
    }

}