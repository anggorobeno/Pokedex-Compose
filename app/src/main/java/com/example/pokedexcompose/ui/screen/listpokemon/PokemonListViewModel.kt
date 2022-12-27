package com.example.pokedexcompose.ui.screen.listpokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.data.PokemonRepository
import com.example.pokedexcompose.data.Pokemons
import com.example.pokedexcompose.ui.common.UiState
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class PokemonListViewModel(private val repository: PokemonRepository) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Pokemons>>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Pokemons>>>
        get() = _uiState

    init {
        getAllPokemon()
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            repository.getAllPokemon()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect {
                    _uiState.value = UiState.Success(it)
                }
        }
    }
}