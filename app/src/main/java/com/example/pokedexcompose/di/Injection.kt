package com.example.pokedexcompose.di

import com.example.pokedexcompose.data.PokemonRepository

object Injection {
    fun provideRepo(): PokemonRepository {
        return PokemonRepository.getInstance()
    }
}