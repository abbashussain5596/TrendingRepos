package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.tech.abbas.trendingrepos.base.BaseTest
import com.tech.abbas.trendingrepos.base.extension.waitUntilExists
import com.tech.abbas.trendingrepos.di.NetworkModule
import com.tech.abbas.trendingrepos.di.RepoModule
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.LOADING
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.REPO_LIST
import com.tech.abbas.trendingrepos.presentation.ui.RepoListScreenKtTest.RepoListScreen.RETRY_BUTTON
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel
import com.tech.abbas.trendingrepos.presentation.viewModel.ReposUIState
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@HiltAndroidTest
@UninstallModules(NetworkModule::class,RepoModule::class)
@RunWith(MockitoJUnitRunner::class)
internal class RepoEndToEndTest : BaseTest() {

    @Mock
    lateinit var repoScreenViewModel: RepoListViewModel

    @Before
    fun initMockServer() {
        startMockServer()
        Mockito.`when`(repoScreenViewModel.uiState).thenReturn(
            (MutableStateFlow(ReposUIState.Error))
        )
        Mockito.`when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
            (MutableStateFlow(listOf()))
        )
        composeTestRule.setContent {
            RepoListScreen(repoScreenViewModel)
        }

    }

//    @Test
//    fun repoListSuccessFlowTest() {
//        Mockito.`when`(repoScreenViewModel.uiState).thenReturn(
//            (MutableStateFlow(ReposUIState.Idle))
//        )
//        Mockito.`when`(repoScreenViewModel.expandedCardIdsList).thenReturn(
//            (MutableStateFlow(listOf()))
//        )
//        initSuccessMockServerDispatcher()
//        composeTestRule.onNodeWithTag(RepoListScreenKtTest.NETWORK_ERROR).assertDoesNotExist()
////        composeTestRule.onNodeWithTag(RepoListScreenKtTest.REPO_LIST).assertDoesNotExist()
//        composeTestRule.onNodeWithTag(RepoListScreenKtTest.REPO_LIST).assertIsDisplayed()
//
//    }
    //TODO: Add End to End with Mock Servers
    @Test
    fun whenRepoListIsInErrorStateAndClickOnRetry() {

        initSuccessMockServerDispatcher()

        composeTestRule.onNodeWithTag(RETRY_BUTTON)
            .performClick()

        val loaderCount =
            composeTestRule.onAllNodes(hasTestTag(LOADING)).fetchSemanticsNodes().size
        assert(loaderCount == 9)

        composeTestRule.waitUntilExists(hasTestTag(REPO_LIST))

    }

}