package com.example.pokedexcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokedexcompose.ui.navigation.NavigationItem
import com.example.pokedexcompose.ui.navigation.Screen
import com.example.pokedexcompose.ui.screen.PokemonListScreen
import com.example.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokedexApp(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController()
) {
    val navBackStackEntry by navHostController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        bottomBar = {
            BottomBar(navHostController = navHostController)
        },
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navHostController, startDestination = Screen.PokemonList().route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.PokemonList().route) {
                PokemonListScreen()
            }
        }
    }

}

@Composable
fun BottomBar(navHostController: NavHostController, modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier,
    ) {
        val navBackStackEntry by navHostController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = stringResource(id = R.string.menu_list),
                icon = Icons.Default.Home,
                screen = Screen.PokemonList()
            ),
            NavigationItem(
                title = stringResource(id = R.string.menu_list),
                icon = Icons.Default.Star,
                screen = Screen.DetailPokemon()
            )
        )

        navigationItems.map { item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.title
                    )
                },
                label = { Text(item.title) },
                selected = currentRoute == item.screen.route,
                onClick = {
                    navHostController.navigate(item.screen.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }

    }

}

@Composable
@Preview(showBackground = true)
fun MainAppPreview() {
    PokedexComposeTheme() {
        PokedexApp()
    }
}