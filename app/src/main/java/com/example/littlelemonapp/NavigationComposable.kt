package com.example.littlelemonapp

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi

@ExperimentalGlideComposeApi
@Composable
fun NavigationComposable(context: Context, navController: NavHostController) {
    val sharedPreferences = context.getSharedPreferences("Little Lemon", Context.MODE_PRIVATE)
    val isLoggedIn = sharedPreferences.getBoolean("userRegistered", false)
    NavHost(
        navController = navController,
        startDestination =
        if (isLoggedIn) {
            Home.route
            } else {
            Onboarding.route
        }) {
        composable(Onboarding.route) {
            Onboarding(context, navController)
        }
        composable(Home.route) {
            Home(navController = navController)
        }
        composable(Profile.route) {
            Profile(context, navController)
        }
    }
}