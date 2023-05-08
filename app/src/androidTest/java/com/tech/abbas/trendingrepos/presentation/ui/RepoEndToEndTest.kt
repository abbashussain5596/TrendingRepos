package com.tech.abbas.trendingrepos.presentation.ui

import androidx.compose.ui.test.onNodeWithTag
import com.tech.abbas.trendingrepos.base.BaseTest
import com.tech.abbas.trendingrepos.di.NetworkModule
import com.tech.abbas.trendingrepos.di.RepoModule
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

    //TODO: Add End to End test with Mock Servers
    @Test
    fun repoListSuccessFlowTest() {
        initSuccessMockServerDispatcher()
    }


}