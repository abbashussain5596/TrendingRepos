package com.tech.abbas.trendingrepos.presentation.mock

import com.tech.abbas.trendingrepos.domain.entity.GithubRepo

object GithubReposProvider {
    val githubRepo = GithubRepo(
        101,
        "https://avatars.githubusercontent.com/u/12101536?v=4",
        "some-username",
        "some-repoName",
        "some-desc",
        "some-language",
        100
    )

    fun getGithubRepoList():List<GithubRepo> =
        listOf(
            githubRepo,
            githubRepo,
            githubRepo,
            githubRepo,
            githubRepo
        )

}