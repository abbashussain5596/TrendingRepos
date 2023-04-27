package com.tech.abbas.trendingrepos.di

import com.tech.abbas.trendingrepos.domain.usecase.IRepoUseCase
import com.tech.abbas.trendingrepos.domain.usecase.RepoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object UseCaseModule {

    @Provides
    fun provideIRepoUseCase(): IRepoUseCase {
        return RepoUseCaseImpl()
    }

}