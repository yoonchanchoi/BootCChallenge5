package com.example.bootcchallenge5.presentation.search.model

import java.util.Date

data class ImageDocumentEntity(
    val collection: String = "",
    val thumbnailUrl: String = "",
    val imageUrl: String = "",
    val width: Int = 0,
    val height: Int = 0,
    val displaySitename: String = "",
    val docUrl: String = "",
    val datetime: Date? = null
)