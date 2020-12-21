package com.example.afinal

data class Json(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)