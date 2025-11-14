package com.example.quoteapp.repository

import com.example.quoteapp.data.QuotesData
import com.example.quoteapp.model.Quote

class QuoteRepository {

    fun getAllQuotes(): List<Quote> {
        return QuotesData.quotes.mapIndexed { index, quoteText ->
            // For your current format where quotes are already complete strings
            Quote(
                id = index + 1,
                text = quoteText,
                author = extractAuthor(quoteText),
                verse = extractVerse(quoteText)
            )
        }
    }

    private fun extractAuthor(quoteText: String): String {
        return if (quoteText.contains(" - ")) {
            val parts = quoteText.split(" - ")
            if (parts.size > 1) {
                val versePart = parts[1]
                versePart.split(" ")[0] // Get the first word (book name)
            } else {
                "Unknown"
            }
        } else {
            "Unknown"
        }
    }

    private fun extractVerse(quoteText: String): String {
        return if (quoteText.contains(" - ")) {
            val parts = quoteText.split(" - ")
            if (parts.size > 1) parts[1] else "Unknown"
        } else {
            "Unknown"
        }
    }

    fun getRandomQuote(): Quote {
        val quotes = getAllQuotes()
        return quotes.random()
    }

    fun getQuoteById(id: Int): Quote? {
        return getAllQuotes().find { it.id == id }
    }

    // Helper function to get quotes as simple strings (for your current UI)
    fun getAllQuoteTexts(): List<String> {
        return QuotesData.quotes
    }
}