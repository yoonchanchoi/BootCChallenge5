package com.example.bootcchallenge5.data.repository

import com.example.bootcchallenge5.data.model.SearchResponse
import com.example.bootcchallenge5.presentation.search.model.SearchEntity

interface DefaultSearchRepository {

    //일반 api
    suspend fun requestSearch(query: String): SearchEntity

}

