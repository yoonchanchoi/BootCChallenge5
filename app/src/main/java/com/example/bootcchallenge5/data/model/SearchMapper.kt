package com.example.bootcchallenge5.data.model

import com.example.bootcchallenge5.presentation.search.model.ImageDocumentEntity
import com.example.bootcchallenge5.presentation.search.model.MetaEntity
import com.example.bootcchallenge5.presentation.search.model.SearchEntity

fun SearchResponse.toEntity() = SearchEntity(
    meta = meta?.toEntity(),
    documents = documents?.map {
        it.toEntity()
    }
)

fun MetaResponse.toEntity() = MetaEntity(
    totalCount = totalCount,
    pageableCount = pageableCount,
    isEnd = isEnd,
)

fun ImageDocumentResponse.toEntity() = ImageDocumentEntity(
    collection = collection,
    thumbnailUrl = thumbnailUrl,
    imageUrl = imageUrl,
    width = width,
    height = height,
    displaySitename = displaySitename,
    docUrl = docUrl,
    datetime = datetime,
)