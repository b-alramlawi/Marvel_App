package com.bahaa.marvelapp.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bahaa.marvelapp.model.MarvelRepository
import com.bahaa.marvelapp.model.State
import com.bahaa.marvelapp.model.database.FavoritePost
import com.bahaa.marvelapp.model.response.BaseResponse
import com.bahaa.marvelapp.view.base.BaseViewModel
import com.bahaa.marvelapp.util.Event
import com.bahaa.marvelapp.model.response.Result
import com.bahaa.marvelapp.util.addTo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class HomeViewModel : BaseViewModel(), HomeInteractionListener {
    private val repository = MarvelRepository()

    val character = MutableLiveData<State<BaseResponse<Result>>>()
    val comics = MutableLiveData<State<BaseResponse<Result>>>()
    private val localComics = MutableLiveData<List<Result>>()

    private val _navigateToDetailsFragment = MutableLiveData<Event<Int>>()
    val navigateToDetailsFragment: LiveData<Event<Int>>
        get() = _navigateToDetailsFragment

    private val _navigateToFavoriteFragment = MutableLiveData<Event<Boolean>>()
    val navigateToFavoriteFragment: LiveData<Event<Boolean>>
        get() = _navigateToFavoriteFragment

    private val _navigateToSeeAllFragment = MutableLiveData<Event<Boolean>>()
    val navigateToSeeAllFragment: LiveData<Event<Boolean>>
        get() = _navigateToSeeAllFragment

    private val _isSavedPost = MutableLiveData<Event<Boolean>>()
    val isSavedPost: LiveData<Event<Boolean>>
        get() = _isSavedPost

    init {
        makeRequest()
    }

    fun makeRequest() {
        getCharacters()
        getComics()
    }

    fun navigateToFavoriteFragment() {
        _navigateToFavoriteFragment.postValue(Event(true))
    }

    private fun getCharacters() {
        character.postValue(State.OnLoading)
        repository.getCharacter()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onCharacterSuccess, ::onFailure).addTo(disposable)
    }

    private fun getComics() {
        comics.postValue(State.OnLoading)
        repository.getComics()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onComicsSuccess, ::onFailure).addTo(disposable)
    }

    private fun onCharacterSuccess(data: State<BaseResponse<Result>>) {
        State.OnSuccess(data.toData())
        character.postValue(data)
    }

    private fun onComicsSuccess(data: State<BaseResponse<Result>>) {
        State.OnSuccess(data.toData())
        comics.postValue(data)
    }

    private fun onFailure(error: Throwable) {
        comics.postValue(State.OnFailure(error.message.toString()))
    }

    override fun onListener(id: Int) {
        _navigateToDetailsFragment.postValue(Event(id))
    }

    override fun seeAllListener() {
        _navigateToSeeAllFragment.postValue(Event(true))
    }

    override fun savePost(id: Int) {
        getDetails(id)
        addPost()
    }

    private fun addPost() {
        localComics.value?.let {
            FavoritePost(
                0,
                it.joinToString { it.thumbnail?.imageUrl().toString() },
                localComics.value!!.joinToString { it.comicsTitle.toString() }
            )
        }?.let {
            repository.insertPost(
                it
            ).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe().addTo(disposable)
        }

        _isSavedPost.postValue(Event(true))
    }

    private fun getDetails(id: Int) {
        repository.getComicsDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSaveSuccess, ::onFailure).addTo(disposable)

    }

    private fun onSaveSuccess(data: State<BaseResponse<Result>>) {
        localComics.postValue(data.toData()?.data?.results!!)
    }


}