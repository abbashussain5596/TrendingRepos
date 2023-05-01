package com.tech.abbas.trendingrepos.domain.usecase

import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RepoUseCaseImpl @Inject constructor(
    private val repository:IRepoRepository
): IRepoUseCase {
    override suspend fun getRepoList(): Flow<Result<List<GithubRepo>>> {
        return repository.getRepoList()
    }
}