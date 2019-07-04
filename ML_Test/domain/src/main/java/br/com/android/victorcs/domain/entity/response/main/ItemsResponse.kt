package br.com.android.victorcs.domain.entity.response.main

import com.google.gson.annotations.SerializedName

data class ItemsResponse(
    @SerializedName("site_id")
    var siteId: String?,
    @SerializedName("query")
    var query: String?,
    @SerializedName("results")
    var results: List<Result>? = null
)