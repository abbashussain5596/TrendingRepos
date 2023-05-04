package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel
import com.tech.abbas.trendingrepos.presentation.viewModel.ReposUIState
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
internal class RepoListScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Mock
    lateinit var repoScreenViewModel: RepoListViewModel

    private val githubRepos = GithubReposProvider.getGithubRepoList()

    fun setup() {
        composeTestRule.setContent {
            RepoListScreen(repoScreenViewModel)
        }
    }

    @Test
    fun whenScreenStartsToolbarCorrectlyVisible() {
        `when`(repoScreenViewModel.uiState).thenReturn(
            (MutableStateFlow(ReposUIState.Idle))
        )
        `when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
            (MutableStateFlow(listOf()))
        )
        setup()
        composeTestRule.onNodeWithTag(TOOLBAR_TAG).assertIsDisplayed()
        composeTestRule.onNodeWithTag(MENU_ICON).assertIsDisplayed()
    }

    @Test
    fun whenScreenIsOnIdleState() {
        `when`(repoScreenViewModel.uiState).thenReturn(
            (MutableStateFlow(ReposUIState.Idle))
        )
        `when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
            (MutableStateFlow(listOf()))
        )
        setup()
        composeTestRule.onNodeWithTag(REPO_LIST).assertDoesNotExist()

    }

    @Test
    fun whenScreenIsOnErrorState() {
        `when`(repoScreenViewModel.uiState).thenReturn(
            (MutableStateFlow(ReposUIState.Error))
        )
        `when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
            (MutableStateFlow(listOf()))
        )
        setup()
        composeTestRule.onNodeWithTag(NETWORK_ERROR).assertExists()
        composeTestRule.onNodeWithTag(REPO_LIST).assertDoesNotExist()

    }

    @Test
    fun whenScreenIsOnSuccessState() {
        `when`(repoScreenViewModel.uiState).thenReturn(
            (MutableStateFlow(ReposUIState.Success(githubRepos)))
        )
        `when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
            (MutableStateFlow(listOf()))
        )
        setup()
        composeTestRule.onNodeWithTag(NETWORK_ERROR).assertDoesNotExist()
        composeTestRule.onNodeWithTag(REPO_LIST).assertExists()

    }

    @Test
    fun whenScreenIsOnLoadingState() {
        `when`(repoScreenViewModel.uiState).thenReturn(
            (MutableStateFlow(ReposUIState.Loading))
        )
        `when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
            (MutableStateFlow(listOf()))
        )
        setup()
        composeTestRule.onNodeWithTag(NETWORK_ERROR).assertDoesNotExist()
        composeTestRule.onNodeWithTag(REPO_LIST).assertDoesNotExist()
        val loaderCount =
            composeTestRule.onAllNodes(hasTestTag(LOADING)).fetchSemanticsNodes().size
        assert(loaderCount == 9)


    }

    companion object RepoListScreen {
        const val TOOLBAR_TAG = "toolbar"
        const val MENU_ICON = "menuIcon"
        const val REPO_LIST = "repoList"
        const val LOADING = "loading"
        const val NETWORK_ERROR = "networkError"
        const val ERROR_ANIM = "errorAnim"
        const val ERROR_TEXT = "errorText"
        const val ERROR_DESC = "errorDesc"
        const val RETRY_BUTTON = "retryButton"

    }
}
