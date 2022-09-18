package com.bahaa.marvelapp.view.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bahaa.marvelapp.model.MarvelRepository
import com.bahaa.marvelapp.model.State
import com.bahaa.marvelapp.model.response.BaseResponse
import com.bahaa.marvelapp.view.base.BaseViewModel
import com.bahaa.marvelapp.util.addTo
import com.bahaa.marvelapp.model.response.Result
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class DetailsViewModel : BaseViewModel() {

    private val repository = MarvelRepository()

    private val _imageUrl = MutableLiveData<String?>()
    val imageUrl: LiveData<String?>
        get() = _imageUrl

    private val _name = MutableLiveData<String?>()
    val name: LiveData<String?>
        get() = _name

    fun getDetails(id: Int) {
        repository.getCharacterDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure).addTo(disposable)

        repository.getComicsDetails(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::onFailure).addTo(disposable)

    }

    private fun onSuccess(details: State<BaseResponse<Result>>) {
        State.OnSuccess(details.toData())

        _imageUrl.postValue(
            details.toData()?.data?.results?.joinToString {
                it.thumbnail?.imageUrl()
                    ?: ""
            }
        )
        _name.postValue(
            details.toData()?.data?.results?.joinToString {
                it.description.toString()
            }
        )

    }

    private fun onFailure(error: Throwable) {
        State.OnFailure(error.message)
    }

}