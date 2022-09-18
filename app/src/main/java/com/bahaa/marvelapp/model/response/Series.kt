package com.bahaa.marvelapp.model.response

import com.google.gson.annotations.SerializedName

data class Series(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<FirstItem>?,
    @SerializedName("returned")
    val returned: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?
)