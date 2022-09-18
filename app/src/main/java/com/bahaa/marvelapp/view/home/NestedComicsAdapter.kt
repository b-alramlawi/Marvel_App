package com.bahaa.marvelapp.view.home

import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.model.response.Result
import com.bahaa.marvelapp.view.base.BaseRecyclerViewAdapter


class NestedComicsAdapter(
    val comicsItem: List<Result>,
    val listener: HomeInteractionListener
) : BaseRecyclerViewAdapter<Result>(comicsItem, listener) {

    override val layoutId: Int = R.layout.item_comics

    override fun getItemCount() = 8

}