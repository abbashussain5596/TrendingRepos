package com.tech.abbas.trendingrepos.data.repository

import app.cash.turbine.test
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tech.abbas.trendingrepos.data.remote.dto.GithubRepoResponseDTO
import com.tech.abbas.trendingrepos.data.remote.service.RepoService
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.util.Result
import com.tech.abbas.trendingrepos.util.TestJsonReader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.mockito.Mock
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.mockito.MockitoAnnotations

@OptIn(ExperimentalCoroutinesApi::class)
internal class RepoRepositoryImplTest {

    @Mock
    lateinit var repoService: RepoService

    private lateinit var repository: IRepoRepository

    @Before
    fun setupRepo() {
        MockitoAnnotations.openMocks(this)
        Dispatchers.setMain(StandardTestDispatcher())
        repository = RepoRepositoryImpl(repoService)
    }

    @Test
    fun loadReposWithValidResponse() = runTest {

        val repoResponse =
            TestJsonReader.createObjectFromFile<GithubRepoResponseDTO>("json/RepoApiResponse.json")

        whenever(
            repoService.getRepoList()
        ).thenReturn(
            repoResponse
        )

        val repoStream = repository.getRepoList()

        repoStream.test {
            Assertions.assertEquals(Result.Loading,awaitItem())

            val repos = awaitItem() as Result.Success

            Assertions.assertEquals(repoResponse.items.size,repos.data.size)

            awaitComplete()
        }

        verify(repoService).getRepoList()


    }

}