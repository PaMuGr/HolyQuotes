package com.example.quoteapp.utils

import android.content.Context
import android.content.Intent

fun shareQuote(context: Context, quote: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, "🌟 Versículo Bíblico:\n\n\"$quote\"\n\n- Compartido desde App Bíblica")
    }
    context.startActivity(Intent.createChooser(intent, "Compartir Versículo"))
}