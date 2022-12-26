package com.example.pokedexcompose.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class PokemonRepository {
    private val pokemonList = mutableListOf<Pokemons>()

    init {
        if (pokemonList.isEmpty()) {
            FakePokemonDataSource.dummyPokemon.forEach { pokemon ->
                pokemonList.add(Pokemons(pokemon, false))
            }
        }
    }

    fun getAllPokemon(): Flow<List<Pokemons>> {
        return flowOf(pokemonList)
    }

    companion object {
        @Volatile
        private var instance: PokemonRepository? = null

        fun getInstance(): PokemonRepository =
            instance ?: synchronized(this) {
                PokemonRepository().apply {
                    instance = this
                }
            }
    }
}
