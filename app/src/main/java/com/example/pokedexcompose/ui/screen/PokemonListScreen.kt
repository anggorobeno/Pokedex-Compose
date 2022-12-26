package com.example.pokedexcompose.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.pokedexcompose.data.Pokemons
import com.example.pokedexcompose.ui.component.PokemonItem
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedexcompose.ViewModelFactory
import com.example.pokedexcompose.di.Injection
import com.example.pokedexcompose.ui.common.UiState
import com.example.pokedexcompose.utils.AppUtils.showToast

@Composable
fun PokemonListScreen(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = viewModel(factory = ViewModelFactory(Injection.provideRepo()))
) {
    val context = LocalContext.current

    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { state ->
        when (state) {
            is UiState.Loading -> {
                context.showToast("Loading data")
            }
            is UiState.Error -> {

            }
            is UiState.Success -> {
                PokemonContent(pokemonList = state.data)
            }
        }
    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PokemonContent(
    pokemonList: List<Pokemons>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(pokemonList) { data ->
            PokemonItem(
                image = data.pokemon.image,
                name = data.pokemon.name,
                type = data.pokemon.type,
            )
        }
    }
}