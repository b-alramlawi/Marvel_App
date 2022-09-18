package com.bahaa.marvelapp.view.base

import androidx.recyclerview.widget.DiffUtil

class MarvelDiffUtils<T>(
    private val marvelOldList: List<T>,
    private val marvelNewList: List<T>
) : DiffUtil.Callback() {

    override fun getOldListSize() = marvelOldList.size

    override fun getNewListSize() = marvelNewList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        marvelOldList[oldItemPosition] == marvelNewList[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = true
}