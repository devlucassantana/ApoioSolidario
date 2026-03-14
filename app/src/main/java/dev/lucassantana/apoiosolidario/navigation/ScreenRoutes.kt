package dev.lucassantana.apoiosolidario.navigation

sealed class Destino(val route: String){
    object InitialScreen: Destino("initial")
    object SignupScreen: Destino("signup")
    object LoginScreen: Destino("login")

    object HomeScreen: Destino("home/{email}"){
        fun createRoute(email: String): String {
            return "home/$email"
        }

    }

}