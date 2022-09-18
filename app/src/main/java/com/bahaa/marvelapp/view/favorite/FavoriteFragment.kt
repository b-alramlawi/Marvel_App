package com.bahaa.marvelapp.view.favorite

import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.databinding.FragmentFavoriteBinding
import com.bahaa.marvelapp.view.base.BaseFragment

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding, FavoriteViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_favorite
    override val viewModelClass: Class<FavoriteViewModel> = FavoriteViewModel::class.java

    override fun setup() {
        binding.recyclerFavoritePost.adapter = FavoriteAdapter(mutableListOf(), viewModel)
    }

}