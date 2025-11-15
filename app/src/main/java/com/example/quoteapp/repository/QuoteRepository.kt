package com.example.quoteapp.repository

import com.example.quoteapp.data.QuotesDataEn
import com.example.quoteapp.data.QuotesDataEs

class QuoteRepository {

    fun getQuotes(language: String): List<String> {
        return when (language) {
            "en" -> QuotesDataEn.quotes
            "es" -> QuotesDataEs.quotes
            else -> QuotesDataEs.quotes // Default to Spanish
        }
    }
}