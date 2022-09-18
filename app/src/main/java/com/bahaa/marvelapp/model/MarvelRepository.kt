package com.bahaa.marvelapp.model

import com.bahaa.marvelapp.model.database.FavoritePost
import com.bahaa.marvelapp.model.database.FavoritePostDatabase
import com.bahaa.marvelapp.model.network.MarvelApi
import com.bahaa.marvelapp.model.response.BaseResponse
import com.bahaa.marvelapp.model.response.Result
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class MarvelRepository {
    private val dao = FavoritePostDatabase.getInstanceWithoutContext().postDao()

    fun insertPost(favoritePost: FavoritePost): Completable = dao.insert(favoritePost)

    fun deletePost(favoritePost: FavoritePost): Completable = dao.delete(favoritePost)

    fun getAllPosts(): Observable<List<FavoritePost>> = dao.getAllPosts()


    fun getCharacter(): Single<State<BaseResponse<Result>>> {
        return wrapResponse(MarvelApi.marvelService.getCharacter())
    }

    fun getCharacterDetails(id: Int): Single<State<BaseResponse<Result>>> {
        return wrapResponse(MarvelApi.marvelService.getCharacterDetails(id))
    }

    fun getComics(): Single<State<BaseResponse<Result>>> {
        return wrapResponse(MarvelApi.marvelService.getComics())
    }

    fun getComicsDetails(id: Int): Single<State<BaseResponse<Result>>> {
        return wrapResponse(MarvelApi.marvelService.getComicsDetails(id))
    }

    private fun <T> wrapResponse(response: Single<Response<T>>): Single<State<T>> {
        return response.map {
            if (it.isSuccessful) {
                State.OnSuccess(it.body())
            } else {
                State.OnFailure(it.message())
            }
        }
    }
}