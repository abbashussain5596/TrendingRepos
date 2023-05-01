package com.tech.abbas.trendingrepos.domain.repository

import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.util.Result
import kotlinx.coroutines.flow.Flow

internal interface IRepoRepository {
    fun getRepoList(): Flow<Result<List<GithubRepo>>>
}