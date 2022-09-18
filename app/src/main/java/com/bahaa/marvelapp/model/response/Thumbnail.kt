package com.bahaa.marvelapp.model.response


import com.google.gson.annotations.SerializedName

data class Thumbnail(
    @SerializedName("extension")
    val extension: String?,
    @SerializedName("path")
    val path: String?
){
    fun imageUrl(): String = "$path.$extension"
}