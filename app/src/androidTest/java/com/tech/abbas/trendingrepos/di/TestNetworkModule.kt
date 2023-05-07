package com.tech.abbas.trendingrepos.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.tech.abbas.trendingrepos.constant.AppConstants
import com.tech.abbas.trendingrepos.data.remote.service.RepoService
import com.tech.abbas.trendingrepos.data.repository.RepoRepositoryImpl
import com.tech.abbas.trendingrepos.domain.repository.IRepoRepository
import com.tech.abbas.trendingrepos.domain.usecase.IRepoUseCase
import com.tech.abbas.trendingrepos.domain.usecase.RepoUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [NetworkModule::class]
)
internal object TestNetworkModule {
    private const val BASE_URL = "http://localhost:8080"

    @Provides
    internal fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    fun provideRetrofit(moshi: Moshi, httpLoggingInterceptor: HttpLoggingInterceptor): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

    @Provides
    fun provideLoginService(retrofit: Retrofit): RepoService =
        retrofit.create(RepoService::class.java)

    @Provides
    fun provideIRepoUseCase(repository: IRepoRepository): IRepoUseCase {
        return RepoUseCaseImpl(repository)
    }

    @Provides
    fun provideIRepoRepository(repoService: RepoService): IRepoRepository {
        return RepoRepositoryImpl(repoService)
    }
}