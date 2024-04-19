package com.example.bootcchallenge5.presentation.search.model

data class SearchEntity(
    val meta: MetaEntity? = null,
    val documents: List<ImageDocumentEntity>? = null
)
