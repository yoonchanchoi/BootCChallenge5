package com.example.bootcchallenge5.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class SearchResponse(

    @SerializedName("meta")
    @Expose
    val meta: MetaResponse? = null,

    @SerializedName("documents")
    @Expose
    val documents: List<ImageDocumentResponse>? = null

)
