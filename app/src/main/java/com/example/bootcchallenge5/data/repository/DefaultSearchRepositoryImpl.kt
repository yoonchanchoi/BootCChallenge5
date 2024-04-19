package com.example.bootcchallenge5.data.repository

import com.example.bootcchallenge5.data.remote.SearchDataSource
import com.example.bootcchallenge5.presentation.search.model.SearchEntity
import com.example.bootcchallenge5.data.model.toEntity
import javax.inject.Inject

class DefaultSearchRepositoryImpl @Inject constructor(
    private val searchDataSource: SearchDataSource
) : DefaultSearchRepository {


    override suspend fun requestSearch(
        query: String
    ): SearchEntity =
        searchDataSource.requestSearch(query, sort="accuracy", page=1, size=80).toEntity()
}