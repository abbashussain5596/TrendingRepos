package com.tech.abbas.trendingrepos.data.remote.service

import com.tech.abbas.trendingrepos.data.remote.dto.GithubRepoResponseDTO
import retrofit2.http.GET

interface RepoService {

    @GET("/search/repositories?q=language=+sort:stars")
    suspend fun getRepoList(): GithubRepoResponseDTO

}