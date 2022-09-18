package com.bahaa.marvelapp.view.favorite

import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.model.database.FavoritePost
import com.bahaa.marvelapp.view.base.BaseInteractionListener
import com.bahaa.marvelapp.view.base.BaseRecyclerViewAdapter

class FavoriteAdapter(
    private val favoritePost: List<FavoritePost>,
    private val listener: FavoriteInteractionListener
) : BaseRecyclerViewAdapter<FavoritePost>(favoritePost, listener) {
    override val layoutId: Int = R.layout.item_favorite_post
}

interface FavoriteInteractionListener : BaseInteractionListener {
    fun onDeletePost(favoritePost: FavoritePost)
}