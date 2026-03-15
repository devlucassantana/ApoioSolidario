package dev.lucassantana.apoiosolidario.navigation

sealed class Destino(val route: String){
    object InitialScreen: Destino("initial")
    object SignupScreen: Destino("signup")
    object LoginScreen: Destino("login")
    object ProfileScreen: Destino("profile/{email}"){
        fun createRoute(email: String): String {
            return "profile/$email"
        }
    }

    object HomeScreen: Destino("home/{email}"){
        fun createRoute(email: String): String {
            return "home/$email"
        }

    }

    object DonationsScreen: Destino("donation")

}