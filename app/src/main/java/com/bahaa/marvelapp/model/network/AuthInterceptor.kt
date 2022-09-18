package com.bahaa.marvelapp.model.network

import com.bahaa.marvelapp.util.md5
import okhttp3.Interceptor
import okhttp3.Response


class AuthInterceptor : Interceptor {

    private val ts = System.currentTimeMillis().toString()
    private val apiKey = "82e10e3bfce15efbd21249c5c3a99c39"
    private val privateKey = "0206ae9d0afa83f58e61e2a400e621c2d7ff05f7"
    private val hash = "$ts$privateKey$apiKey".md5()

    override fun intercept(chain: Interceptor.Chain): Response {
        val marvelUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(TS, ts)
            .addQueryParameter(API_KEY, apiKey)
            .addQueryParameter(HASH, hash)
            .build()

        return chain.proceed(chain.request().newBuilder().url(marvelUrl).build())
    }

    companion object {
        const val API_KEY = "apikey"
        const val TS = "ts"
        const val HASH = "hash"

    }
}