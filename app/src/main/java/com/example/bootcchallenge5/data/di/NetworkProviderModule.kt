package com.example.bootcchallenge5.data.di

import com.example.bootcchallenge5.data.HeadersInterceptor
import com.example.bootcchallenge5.data.remote.SearchDataSource
import com.example.bootcchallenge5.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkProviderModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(
        headersInterceptor: HeadersInterceptor
    ): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor()
        logInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .addInterceptor(headersInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): SearchDataSource {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build().create(SearchDataSource::class.java)
    }
}