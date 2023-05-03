package com.tech.abbas.trendingrepos.data.repository

import com.tech.abbas.trendingrepos.data.remote.service.RepoService
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.util.Result
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class RepoRepositoryImpl @Inject constructor(
    private val service:RepoService
):IRepoRepository {
    override fun getRepoList(): Flow<Result<List<GithubRepo>>> {
        TODO("Not yet implemented")
    }
}