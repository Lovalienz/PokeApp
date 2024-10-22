package com.poke.pokemonapp.ui.navigation

import android.window.SplashScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.poke.pokemonapp.ui.screens.characters.CharactersScreen
import com.poke.pokemonapp.ui.screens.splash.SplashScreen

@Composable
fun MainNavigation() {
    // Controlador de la navegación
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationGraph.SPLASH) {
        // SplashScreen Composable
        composable(NavigationGraph.SPLASH) {
            SplashScreen (onNavigation = {
                navController.navigate(NavigationGraph.CHARACTERS) {
                    popUpTo(NavigationGraph.SPLASH) { inclusive = true } // Elimina el Splash de la pila
                }
            })
        }
        // HomeScreen Composable
        composable(NavigationGraph.CHARACTERS) {
            CharactersScreen()
        }
    }
}