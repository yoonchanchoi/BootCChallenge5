package com.example.bootcchallenge5.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MetaResponse(
    @SerializedName("total_count")
    @Expose
    val totalCount: Int = 0,

    @SerializedName("pageable_count")
    @Expose
    val pageableCount: Int = 0,

    @SerializedName("is_end")
    @Expose
    val isEnd: Boolean = false,
)
