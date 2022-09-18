package com.bahaa.marvelapp.model

sealed class State<out T> {
    object OnLoading : State<Nothing>()
    data class OnSuccess<T>(val data: T?) : State<T>()
    data class OnFailure(val message: String?) : State<Nothing>()

    fun toData() = if (this is OnSuccess) data else null
}