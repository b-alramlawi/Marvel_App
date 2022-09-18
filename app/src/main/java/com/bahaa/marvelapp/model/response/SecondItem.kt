package com.bahaa.marvelapp.model.response


import com.google.gson.annotations.SerializedName

data class SecondItem(
    @SerializedName("name")
    val name: String?,
    @SerializedName("resourceURI")
    val resourceURI: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("role")
    val role: String?
)