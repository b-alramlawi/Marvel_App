package com.bahaa.marvelapp.view.favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bahaa.marvelapp.model.MarvelRepository
import com.bahaa.marvelapp.model.database.FavoritePost
import com.bahaa.marvelapp.view.base.BaseViewModel
import com.bahaa.marvelapp.util.addTo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class FavoriteViewModel : BaseViewModel(), FavoriteInteractionListener {

    private val repository = MarvelRepository()

    private val _favoriteFavoritePost = MutableLiveData<List<FavoritePost>>()
    val favoritePost: LiveData<List<FavoritePost>>
        get() = _favoriteFavoritePost

    init {
        getAllPosts()
    }

    private fun getAllPosts() {
        repository.getAllPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::onGetPosts, this::onPostsFail).addTo(disposable)

    }

    private fun onGetPosts(favoritePost: List<FavoritePost>) {
        _favoriteFavoritePost.postValue(favoritePost)
        this.favoritePost.value?.joinToString { it.name }?.let { Log.i("bha", it) }

    }

    private fun onPostsFail(error: Throwable) {
        error.message.toString()
    }

    override fun onDeletePost(favoritePost: FavoritePost) {
        repository.deletePost(favoritePost)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe().addTo(disposable)
    }
}