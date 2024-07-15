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
    }

}