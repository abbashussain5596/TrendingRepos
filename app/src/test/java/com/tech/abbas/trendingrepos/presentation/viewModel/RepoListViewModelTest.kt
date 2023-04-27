package com.tech.abbas.trendingrepos.presentation.viewModel

import android.app.Application
import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.whenever
import com.tech.abbas.trendingrepos.domain.usecase.IRepoUseCase
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import com.tech.abbas.trendingrepos.domain.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock

@OptIn(ExperimentalCoroutinesApi::class)
internal class RepoListViewModelTest {

    private lateinit var repoViewModel: RepoListViewModel

    @Mock
    lateinit var application: Application

    @Mock
    lateinit var repoUseCase: IRepoUseCase

    @BeforeEach
    fun setupViewModel() {
        repoViewModel = RepoListViewModel(application,repoUseCase)
    }

    @Test
    fun getRepoListSuccess() = runTest {

        val flow = flow {
            emit(Result.Loading)
            delay(10)
            emit(Result.Success(GithubReposProvider.getGithubRepoList()))
        }
        whenever(
            repoUseCase.getRepoList()
        ).thenReturn(
            flow
        )

        repoViewModel.getRepoList()

        Dispatchers.setMain(StandardTestDispatcher())

        repoViewModel.uiState.test {
            Assertions.assertEquals(ReposUIState.Idle, awaitItem())
            Assertions.assertEquals(ReposUIState.Loading, awaitItem())
            Assertions.assertTrue(awaitItem() is ReposUIState.Success)
            Assertions.assertEquals(
                (repoViewModel.uiState.value as ReposUIState.Success).data,
                GithubReposProvider.getGithubRepoList()
            )

        }

    }

}