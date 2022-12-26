package com.example.pokedexcompose.data

import androidx.annotation.DrawableRes

data class Pokemon(
    val id: Int,
    @DrawableRes
    val image: Int,
    val name: String,
    val type: String
)
