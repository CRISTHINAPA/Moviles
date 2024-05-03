package com.example.casa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.room.Room
import com.example.casa.data.CasaDatabase
import com.example.casa.data.CasaRepository
import com.example.casa.main.CasaScreen
import com.example.casa.main.MainScreen
import com.example.casa.main.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val db=Room.databaseBuilder(this,CasaDatabase::class.java, "casa_db").build()
        val dao= db.dao
        val repository= CasaRepository(dao)
        val viewmodel = MainViewModel(repository)

        setContent {
            val navController= rememberNavController()
            NavHost(navController = navController, startDestination = "main" ){
                composable("main" ){

                    MainScreen(navController,viewmodel)

                }
                composable(route="detail"+"/{text}/{text2}/{text3}/{text4}", arguments =  listOf(navArgument(name = "text")
                {type= NavType.StringType },
                    (navArgument(name="text2")
                    { type= NavType.StringType }),
                    (navArgument(name="text3"){
                        type= NavType.StringType }
                            ),
                    (navArgument(name="text4"){
                        type= NavType.StringType }
                            )
                )
                )
                {
                    DetailScreen(navController, it.arguments?.getString("text"),
                        it.arguments?.getString("text2"), it.arguments?.getString("text3"), it.arguments?.getString("text4"))
                }

                composable("lista"){
                    CasaScreen(viewModel = viewmodel, navController =navController )
                }
            }

        }
    }
}