package com.example.bootcchallenge5.data.remote

import com.example.bootcchallenge5.data.model.ImageDocumentResponse
import com.example.bootcchallenge5.data.model.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchDataSource {

    @GET("/v2/search/image")
    suspend fun requestSearch(
        @Query("query") query: String,
        @Query("sort") sort: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): SearchResponse
}