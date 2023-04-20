package com.tech.abbas.trendingrepos.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import com.tech.abbas.trendingrepos.RepoListScreen
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

    @Before
    fun repoListScreenTest() {
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

        composeTestRule.onNodeWithTag(REPO_LIST).assertDoesNotExist()

    }

    companion object RepoListScreen {
        const val TOOLBAR_TAG = "toolbar"
        const val MENU_ICON = "menuIcon"
        const val REPO_LIST = "repoList"

    }
}
