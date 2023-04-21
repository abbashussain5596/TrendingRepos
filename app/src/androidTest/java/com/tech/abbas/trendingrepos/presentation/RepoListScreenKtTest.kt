package com.tech.abbas.trendingrepos.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreen
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel
import com.tech.abbas.trendingrepos.presentation.viewModel.ReposUIState
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepoListScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Mock
    lateinit var repoScreenViewModel: RepoListViewModel

    private val githubRepos = GithubReposProvider.getGithubRepoList()

    fun setup(){
        composeTestRule.setContent {
            RepoListScreen(repoScreenViewModel)
        }
    }

    @Test
    fun whenScreenStartsToolbarCorrectlyVisible() {
        composeTestRule.onNodeWithTag(TOOLBAR_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(MENU_ICON).assertIsDisplayed()
    }

    @Test
    fun whenScreenIsOnIdleState() {
        `when`(repoScreenViewModel.uiState).thenReturn(
            (mutableStateOf(ReposUIState.Idle))
        )
        setup()
        composeTestRule.onNodeWithTag(REPO_LIST).assertDoesNotExist()

    }

    @Test
    fun whenScreenIsOnErrorState(){
        `when`(repoScreenViewModel.uiState).thenReturn(
            (mutableStateOf(ReposUIState.Error))
        )
        setup()
        composeTestRule.onNodeWithTag(NETWORK_ERROR).assertExists()
        composeTestRule.onNodeWithTag(REPO_LIST).assertDoesNotExist()

    }

    @Test
    fun whenScreenIsOnSuccessState(){
        `when`(repoScreenViewModel.uiState).thenReturn(
            (mutableStateOf(ReposUIState.Success(githubRepos)))
        )
        setup()
        composeTestRule.onNodeWithTag(NETWORK_ERROR).assertDoesNotExist()
        composeTestRule.onNodeWithTag(REPO_LIST).assertExists()

    }


    companion object RepoListScreen {
        const val TOOLBAR_TAG = "toolbar"
        const val MENU_ICON = "menuIcon"
        const val REPO_LIST = "repoList"
        const val NETWORK_ERROR = "networkError"

    }
}
