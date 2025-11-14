package com.example.quoteapp.model

data class Quote(
    val id: Int,
    val text: String,
    val author: String,
    val verse: String
) {
    val displayText: String
        get() = "$text - $verse"
}