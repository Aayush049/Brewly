package com.androidlearning.brewly.domain.model

// Represents the data required for a single coffee product.
data class Product(
    val id: Int,             // Unique identifier for the product
    val name: String,        // Product name
    val description: String, // Short description of the product
    val price: Double,       // Product price
    val imageRes: Int        // Android resource ID of the product image
)