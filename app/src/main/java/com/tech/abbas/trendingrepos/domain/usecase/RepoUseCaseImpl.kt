package com.tech.abbas.trendingrepos.domain.usecase

import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RepoUseCaseImpl @Inject constructor(): IRepoUseCase {
    override suspend fun getRepoList(): Flow<Result<List<GithubRepo>>> {
        TODO("Not yet implemented")
    }
}