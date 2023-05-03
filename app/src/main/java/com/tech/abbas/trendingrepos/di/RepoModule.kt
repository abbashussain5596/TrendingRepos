package com.tech.abbas.trendingrepos.di

import com.tech.abbas.trendingrepos.data.remote.service.RepoService
import com.tech.abbas.trendingrepos.data.repository.RepoRepositoryImpl
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.usecase.IRepoUseCase
import com.tech.abbas.trendingrepos.domain.usecase.RepoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object RepoModule {

    @Provides
    fun provideLoginService(retrofit: Retrofit): RepoService =
        retrofit.create(RepoService::class.java)

    @Provides
    fun provideIRepoUseCase(repository: IRepoRepository): IRepoUseCase {
        return RepoUseCaseImpl(repository)
    }

    @Provides
    fun provideIRepoRepository(repoService: RepoService):IRepoRepository{
        return RepoRepositoryImpl(repoService)
    }

}