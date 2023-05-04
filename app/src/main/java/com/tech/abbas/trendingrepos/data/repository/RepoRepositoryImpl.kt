package com.tech.abbas.trendingrepos.data.repository

import com.tech.abbas.trendingrepos.data.mapper.toGithubRepo
import com.tech.abbas.trendingrepos.data.remote.service.RepoService
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.util.Result
import com.tech.abbas.trendingrepos.domain.util.asResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

internal class RepoRepositoryImpl @Inject constructor(
    private val service:RepoService
):IRepoRepository {
    override fun getRepoList(): Flow<Result<List<GithubRepo>>> = flow {
        val githubRepos = service.getRepoList()
        emit(githubRepos.items.toGithubRepo())
    }.asResult()
}