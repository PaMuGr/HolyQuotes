package com.example.quoteapp.utils

import android.content.Context
import android.content.Intent

fun shareQuote(context: Context, quote: String) {
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, "🌟 Versículo Bíblico:\n\n\"$quote\"\n\n- Compartido desde App Bíblica")
    }
    val chooserIntent = Intent.createChooser(shareIntent, "Compartir Versículo")
    chooserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(chooserIntent)
}