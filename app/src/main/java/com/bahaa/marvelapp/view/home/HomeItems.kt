package com.bahaa.marvelapp.view.home

import com.bahaa.marvelapp.model.response.Result

sealed class HomeItems(val type: Int) {
    class CharactersType(val items: List<Result>?) : HomeItems(0)
    class SeeAllType : HomeItems(1)
    class ComicsType(val items: List<Result>?) : HomeItems(2)
}