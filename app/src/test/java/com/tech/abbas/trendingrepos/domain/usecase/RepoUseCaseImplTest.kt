package com.tech.abbas.trendingrepos.domain.usecase

import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.util.Result
import com.tech.abbas.trendingrepos.presentation.mock.GithubReposProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
internal class RepoUseCaseImplTest {

    private lateinit var repoUseCase: IRepoUseCase

    @Mock
    lateinit var repoRepository: IRepoRepository


    @Before
    fun createRepoUseCase() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(StandardTestDispatcher())

        repoUseCase = RepoUseCaseImpl(repoRepository)
    }

    @Test
    fun loadRepoListWithSuccess() = runTest {

        val flow = flow {
            emit(Result.Success(GithubReposProvider.getGithubRepoList()))
        }
        whenever(
            repoRepository.getRepoList()
        ).thenReturn(
            flow
        )

        repoUseCase.getRepoList().test {

            val repo = awaitItem() as Result.Success
            Assertions.assertEquals(repo.data.size,GithubReposProvider.getGithubRepoList().size)
            awaitComplete()
        }

        verify(repoRepository).getRepoList()
    }

    @Test
    fun loadRepoListWithError() = runTest {

        val flow = flow {
            emit(Result.Error(IllegalArgumentException()))
        }
        whenever(
            repoRepository.getRepoList()
        ).thenReturn(
            flow
        )

        repoUseCase.getRepoList().test {
            val error = awaitItem() as Result.Error
            assertThat(error.exception, instanceOf(IllegalArgumentException::class.java))

            awaitComplete()
        }
        verify(repoRepository).getRepoList()


    }

}