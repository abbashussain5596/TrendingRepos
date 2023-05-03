package com.tech.abbas.trendingrepos.data.mapper

import com.tech.abbas.trendingrepos.data.remote.dto.Repos
import com.tech.abbas.trendingrepos.domain.entity.GithubRepo

internal fun List<Repos>.toGithubRepo() = map {
    GithubRepo(
        id = it.id,
        avatarUrl = it.owner.avatarUrl,
        name = it.owner.login,
        repoName = it.name,
        description = it.description,
        language = it.language,
        starsCount = it.stargazersCount
    )
}
