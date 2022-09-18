package com.bahaa.marvelapp.view.home

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.bahaa.marvelapp.BR
import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.view.base.BaseRecyclerViewAdapter

class HomeAdapter(
    private var listItems: MutableList<HomeItems>,
    private val listener: HomeInteractionListener
) : BaseRecyclerViewAdapter<Any>(listItems, listener) {

    override var layoutId: Int = 0

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(newItems: HomeItems) {
        listItems.apply {
            add(newItems)
            sortBy { it.type }
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        layoutId = getViewType(viewType)
        return super.onCreateViewHolder(parent, viewType)
    }

    private fun getViewType(viewType: Int) = when (viewType) {
        0 -> R.layout.item_header_characters
        1 -> R.layout.item_comics_part
        else -> R.layout.item_header_comics
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        bind(holder as ItemViewHolder, position)
    }

    private fun bind(itemViewModel: ItemViewHolder, position: Int) {
        when (val currentItem = listItems[position]) {
            is HomeItems.CharactersType -> {
                itemViewModel.binding.setVariable(
                    BR.adapter,
                    currentItem.items?.let { NestedCharacterAdapter(it, listener) }
                )
            }
            is HomeItems.SeeAllType -> {
                itemViewModel.binding.setVariable(BR.listener, listener)
            }
            is HomeItems.ComicsType -> {
                itemViewModel.binding.setVariable(
                    BR.adapter,
                    currentItem.items?.let { NestedComicsAdapter(it, listener) }
                )
            }
        }
    }

    override fun getItemViewType(position: Int): Int =
        when (listItems[position]) {
            is HomeItems.CharactersType -> 0
            is HomeItems.SeeAllType -> 1
            is HomeItems.ComicsType -> 2
        }

}