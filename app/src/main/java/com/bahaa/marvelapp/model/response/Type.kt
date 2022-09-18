package com.bahaa.marvelapp.model.response

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("available")
    val available: Int?,
    @SerializedName("collectionURI")
    val collectionURI: String?,
    @SerializedName("items")
    val items: List<FirstItem?>?,
    @SerializedName("returned")
    val returned: Int?
)