package com.example.pokedexcompose.data

import com.example.pokedexcompose.R


object FakePokemonDataSource {
    val dummyPokemon = listOf(
        Pokemon(
            1,
            R.drawable.pokemon_1,
            "Bulbasaur",
            "Grass"

        ),
        Pokemon(
            2,
            R.drawable.pokemon_2,
            "Ivysaur",
            "Grass"
        ),
        Pokemon(
            3,
            R.drawable.pokemon_3,
            "Venusaur",
            "Grass"
        ),
        Pokemon(
            4,
            R.drawable.pokemon_4,
            "Charmender",
            "Fire"
        )
    )
}