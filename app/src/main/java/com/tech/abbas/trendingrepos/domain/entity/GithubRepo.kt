package com.tech.abbas.trendingrepos.domain.entity

data class GithubRepo(
    val id: Int,
    val avatarUrl: String,
    val name: String,
    val repoName: String,
    val description: String,
    val language: String,
    val starsCount: Int,
)