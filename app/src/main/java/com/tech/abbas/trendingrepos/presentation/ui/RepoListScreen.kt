package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.hilt.navigation.compose.hiltViewModel
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreen.LOADING
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreen.NETWORK_ERROR
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreen.REPO_LIST
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel
import com.tech.abbas.trendingrepos.presentation.viewModel.ReposUIState

@Composable
internal fun RepoListScreen(
    viewModel: RepoListViewModel = hiltViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val expandedCardIds by viewModel.expandedCardIdsList.collectAsState()


    Column {
        Toolbar()
        when (uiState) {
            is ReposUIState.Error -> {
                ErrorScreen(Modifier.testTag(NETWORK_ERROR)
                ) { viewModel.getRepoList() }
            }
            ReposUIState.Idle -> {}
            ReposUIState.Loading -> {
                LoadingScreen(Modifier.testTag(LOADING))
            }
            is ReposUIState.Success -> {
                RepoSuccessScreen(
                    Modifier.testTag(REPO_LIST),
                    (uiState as ReposUIState.Success).data,
                    expandedCardIds,
                    viewModel
                )
            }
        }
    }
}

object RepoListScreen {
    const val TOOLBAR_TAG = "toolbar"
    const val MENU_ICON = "menuIcon"
    const val REPO_LIST = "repoList"
    const val LOADING = "loading"
    const val NETWORK_ERROR = "networkError"

}