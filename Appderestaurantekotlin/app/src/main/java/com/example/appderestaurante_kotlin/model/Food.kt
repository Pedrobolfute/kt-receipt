package com.example.appderestaurante_kotlin.model

data class Food (
    val id: Int?,
    val imgFood: Int? = null,
    val foodName: String? = null,
    val foodDescription: String? = null,
    val price: String? = null
)

