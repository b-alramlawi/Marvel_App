package com.bahaa.marvelapp.model.network

import com.bahaa.marvelapp.util.Constants.BASE_URL
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MarvelApi {
    private val client = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val marvelService: MarvelService = retrofit.create(MarvelService::class.java)

}