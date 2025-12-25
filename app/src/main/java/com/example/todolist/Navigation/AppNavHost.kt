package com.example.todolist.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.todolist.Screens.AddTask
import com.example.todolist.Screens.EditTask
import com.example.todolist.Screens.MainScreen

@Composable
fun AppNavHost(modifier : Modifier) {
    val navController = rememberNavController()

    NavHost(navController=navController,startDestination = "main") {
        composable("main") {MainScreen(navController = navController) }
        composable(route = "edit_task/{taskId}", arguments = listOf(navArgument("taskId") { type = NavType.IntType })) { EditTask(navController = navController) }
        composable("add_task") { AddTask(navController = navController) }
    }

}
