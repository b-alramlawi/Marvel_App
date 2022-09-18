package com.bahaa.marvelapp.model.network

import com.bahaa.marvelapp.model.response.BaseResponse
import com.bahaa.marvelapp.model.response.Result
import io.reactivex.rxjava3.core.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MarvelService {

    @GET("characters")
    fun getCharacter(): Single<Response<BaseResponse<Result>>>

    @GET("characters/{characterId}")
    fun getCharacterDetails(
        @Path("characterId") characterId: Int
    ): Single<Response<BaseResponse<Result>>>

    @GET("comics")
    fun getComics(): Single<Response<BaseResponse<Result>>>

    @GET("comics/{comicsId}")
    fun getComicsDetails(
        @Path("comicsId") comicsId: Int
    ): Single<Response<BaseResponse<Result>>>

}