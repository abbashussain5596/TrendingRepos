package com.tech.abbas.trendingrepos.presentation.viewModel

import android.app.Application
import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.verify
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
import org.junit.Before
import org.junit.jupiter.api.Assertions
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
internal class RepoListViewModelTest {

    private lateinit var repoViewModel: RepoListViewModel

    @Mock
    lateinit var application: Application

    @Mock
    lateinit var repoUseCase: IRepoUseCase

    @Before
    fun setupViewModel() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(StandardTestDispatcher())

        repoViewModel = RepoListViewModel(application,repoUseCase)
    }

    @Test
    fun verifyRepoListSuccess() = runTest {

        val flow = flow {
            emit(Result.Loading)
            emit(Result.Success(GithubReposProvider.getGithubRepoList()))
        }
        whenever(
            repoUseCase.getRepoList()
        ).thenReturn(
            flow
        )

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

    @Test
    fun verifyRepoListError() = runTest {
        val flow = flow {
            emit(Result.Loading)
            emit(Result.Error())
        }
        whenever(
            repoUseCase.getRepoList()
        ).thenReturn(
            flow
        )

        repoViewModel.uiState.test {

            Assertions.assertEquals(ReposUIState.Idle, awaitItem())
            Assertions.assertEquals(ReposUIState.Loading, awaitItem())
            Assertions.assertTrue(awaitItem() is ReposUIState.Error)

        }
    }

}