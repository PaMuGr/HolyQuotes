package com.example.quoteapp.utils

import android.content.Context
import android.content.Intent

fun shareQuote(context: Context, quote: String, language: String) {

    val shareMessage = when (language) {
        "en" -> "\"$quote\"\n\n- Shared from HolyQuotes"
        else -> "\"$quote\"\n\n- Compartido desde HolyQuotes"
    }

    val chooserTitle = when (language) {
        "en" -> "Share Verse"
        else -> "Compartir Versículo"
    }

    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, shareMessage)
    }
    val chooserIntent = Intent.createChooser(shareIntent, chooserTitle)
    chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(chooserIntent)
}