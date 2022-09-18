package com.bahaa.marvelapp.view.home

import com.bahaa.marvelapp.view.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onListener(id: Int)
    fun seeAllListener()
    fun savePost(id: Int)
}