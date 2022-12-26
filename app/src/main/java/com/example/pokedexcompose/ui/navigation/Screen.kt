package com.example.pokedexcompose.ui.navigation

sealed class Screen(val route: String) {
    class PokemonList : Screen("list")
    class DetailPokemon : Screen("detail")

}
