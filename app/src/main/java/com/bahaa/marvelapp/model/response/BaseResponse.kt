package com.bahaa.marvelapp.model.response

import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @SerializedName("attributionHTML")
    val attributionHTML: String?,
    @SerializedName("attributionText")
    val attributionText: String?,
    @SerializedName("code")
    val code: Int?,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("data")
    val data: Data<T>?,
    @SerializedName("etag")
    val tag: String?,
    @SerializedName("status")
    val status: String?
)