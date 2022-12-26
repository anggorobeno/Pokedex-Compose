package com.example.pokedexcompose.utils

import android.content.Context
import android.widget.Toast

object AppUtils {
    fun Context.showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}