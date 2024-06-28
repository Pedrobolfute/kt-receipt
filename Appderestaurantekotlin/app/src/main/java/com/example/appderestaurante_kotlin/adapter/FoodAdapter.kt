package com.example.appderestaurante_kotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appderestaurante_kotlin.databinding.FoodItemBinding
import com.example.appderestaurante_kotlin.model.Food

class FoodAdapter (private val context: Context, private val foodList: List<Food>):
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val listItem = FoodItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return FoodViewHolder(listItem)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        food.imgFood?.let {holder.imgFood.setImageResource(it)}
//        holder.imgFood.setBackgroundResource(foodList[position].imgFood!!)
        holder.txtFoodName.text = food.foodName
        holder.txtFoodDescription.text = food.foodDescription
    }

    inner class FoodViewHolder(binding: FoodItemBinding): RecyclerView.ViewHolder(binding.root) {
        val imgFood = binding.imgFood
        val txtFoodName = binding.txtFoodName
        val txtFoodDescription = binding.txtFoodDescription
//        val txtPrice = binding.txtPrice
    }
}

//16 min
//https://www.youtube.com/watch?v=yC13iAYPsoo&t=852s