package com.bahaa.marvelapp.view.seeAll

import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.view.base.BaseRecyclerViewAdapter
import com.bahaa.marvelapp.view.home.HomeInteractionListener
import com.bahaa.marvelapp.model.response.Result

class SeeAllAdapter(
    val comicsItem: List<Result>,
    val listener: HomeInteractionListener
) : BaseRecyclerViewAdapter<Result>(comicsItem, listener) {

    override val layoutId: Int = R.layout.item_see_all_comics

}