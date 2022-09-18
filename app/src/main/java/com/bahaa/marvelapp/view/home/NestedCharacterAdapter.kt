package com.bahaa.marvelapp.view.home

import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.model.response.Result
import com.bahaa.marvelapp.view.base.BaseRecyclerViewAdapter

class NestedCharacterAdapter(
    characterItem: List<Result>,
    listener: HomeInteractionListener
) : BaseRecyclerViewAdapter<Result>(characterItem, listener) {

    override val layoutId: Int = R.layout.item_character

}