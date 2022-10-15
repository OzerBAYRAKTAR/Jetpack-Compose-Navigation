package com.ozerbayraktar.jetpackcomposenavigation.view.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ozerbayraktar.jetpackcomposenavigation.data.Dogs
import com.ozerbayraktar.jetpackcomposenavigation.view.ui.DetailScreen
import com.ozerbayraktar.jetpackcomposenavigation.view.ui.MainScreen
import com.ozerbayraktar.jetpackcomposenavigation.view.screens.Screen
import com.ozerbayraktar.jetpackcomposenavigation.view.ui.theme.JetPackComposeNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeNavigationTheme {
                val navController= rememberNavController()
                NavHost(
                    navController =navController,
                    startDestination = Screen.MainScreen.route,
                ){
                    composable(
                        route = Screen.MainScreen.route
                    ) {
                        MainScreen(navController = navController)
                    }
                    composable(
                        Screen.DetailScreen.route+
                                "/{dogId}/{dogTitle}/{dogSex}/{dogAge}/{dogDescription}/{dogImageId}",
                        arguments = listOf(
                            navArgument("dogId") {
                                type = NavType.StringType
                            },
                            navArgument("dogTitle") {
                                type = NavType.StringType
                            },
                            navArgument("dogSex") {
                                type = NavType.StringType
                            },
                            navArgument("dogAge") {
                                type = NavType.IntType
                            },
                            navArgument("dogDescription") {
                                type = NavType.StringType
                            },
                            navArgument("dogImageId") {
                                type = NavType.IntType

                            },
                        )

                    ) {
                        val dogId = remember {
                            it.arguments?.getString("dogId")
                        }
                        val dogTitle = remember {
                            it.arguments?.getString("dogTitle")
                        }
                        val dogSex = remember {
                            it.arguments?.getString("dogSex")
                        }
                        val dogAge = remember {
                            it.arguments?.getInt("dogAge")
                        }
                        val dogDescription = remember {
                            it.arguments?.getString("dogDescription")
                        }
                        val dogImageId = remember {
                            it.arguments?.getInt("dogImageId")
                        }
                        DetailScreen(
                            dogs=Dogs(id, title =dogTitle?:"",dogSex?:"",dogAge!!,dogDescription!!,dogImageId!!),
                            id = dogId?:"",
                            title = dogTitle?:"",
                            sex = dogSex?:"",
                            age =dogAge!!,
                            description = dogDescription?:"",
                            imageId = dogImageId!!,
                            navController = navController
                        )

                    }

                }

                }
            }
        }
    }



