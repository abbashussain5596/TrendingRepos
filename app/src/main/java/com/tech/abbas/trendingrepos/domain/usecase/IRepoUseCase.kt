package com.tech.abbas.trendingrepos.domain.usecase

import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.util.Result
import kotlinx.coroutines.flow.Flow

internal interface IRepoUseCase {
    suspend fun getRepoList(): Flow<Result<List<GithubRepo>>>
}