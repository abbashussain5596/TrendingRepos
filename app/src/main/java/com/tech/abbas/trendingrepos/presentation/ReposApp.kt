package com.tech.abbas.trendingrepos.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.abbas.trendingrepos.presentation.ScreenNavigation.REPOS_LIST_SCREEN
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreen

@Composable
fun ReposApp() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = REPOS_LIST_SCREEN) {

        composable(route = REPOS_LIST_SCREEN) {
            RepoListScreen()
        }
    }

}

object ScreenNavigation {
    const val REPOS_LIST_SCREEN = "repo_list_screen"
}