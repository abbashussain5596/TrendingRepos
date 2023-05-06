package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.presentation.ui.base.BaseTest
import com.tech.abbas.trendingrepos.presentation.ui.base.extension.waitUntilExists
import com.tech.abbas.trendingrepos.presentation.viewModel.RepoListViewModel
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@HiltAndroidTest
@RunWith(MockitoJUnitRunner::class)
internal class RepoEndToEndTest: BaseTest() {

    @Mock
    lateinit var repoScreenViewModel: RepoListViewModel

    @Before
    fun initMockServer(){
        startMockServer()
        composeTestRule.setContent {
            RepoListScreen(repoScreenViewModel)
        }

    }

    @Test
    fun repoListSuccessFlowTest(){
        initSuccessMockServerDispatcher()
        composeTestRule.onNodeWithTag(RepoListScreenKtTest.NETWORK_ERROR).assertDoesNotExist()
        composeTestRule.onNodeWithTag(RepoListScreenKtTest.REPO_LIST).assertDoesNotExist()
        val loaderCount =
            composeTestRule.onAllNodes(hasTestTag(RepoListScreenKtTest.LOADING)).fetchSemanticsNodes().size
        assert(loaderCount == 9)
        composeTestRule.waitUntilExists(hasTestTag(RepoListScreenKtTest.REPO_LIST))

    }
}