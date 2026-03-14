package dev.lucassantana.apoiosolidario.navigation

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import dev.lucassantana.apoiosolidario.screens.HomeScreen
import dev.lucassantana.apoiosolidario.screens.InitialScreen
import dev.lucassantana.apoiosolidario.screens.LoginScreen
import dev.lucassantana.apoiosolidario.screens.SignupScreen

@Composable
fun NavigationRoutes(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Destino.InitialScreen.route
    ){
        composable(Destino.InitialScreen.route){
            InitialScreen(navController)
        }
        composable (
            route = Destino.HomeScreen.route,
            deepLinks = listOf(
                navDeepLink {
                    uriPattern = "https://apoiosolidario.dev.lucassantana/email/{email}"
                    action = Intent.ACTION_VIEW
                }
            ),
            arguments = listOf(navArgument("email") {
                type = NavType.StringType
            })
        ){backStackEntry ->
            var email = backStackEntry.arguments?.getString("email")
            HomeScreen(navController, email)
        }
        composable (Destino.SignupScreen.route){
            SignupScreen(navController)
        }
        composable (Destino.LoginScreen.route){
            LoginScreen(navController)
        }

    }
}