package com.bahaa.marvelapp.view.seeAll

import androidx.navigation.Navigation
import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.databinding.FragmentSeeAllBinding
import com.bahaa.marvelapp.view.base.BaseFragment
import com.bahaa.marvelapp.view.home.HomeViewModel
import com.bahaa.marvelapp.util.EventObserve
import com.bahaa.marvelapp.util.showToast

class SeeAllFragment : BaseFragment<FragmentSeeAllBinding, HomeViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_see_all
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override fun setup() {
        binding.recyclerSeeAll.adapter = SeeAllAdapter(mutableListOf(), viewModel)

        navigateToDetailsFragment()
        savePostMessage()
    }

    private fun navigateToDetailsFragment() {
        viewModel.navigateToDetailsFragment.observe(this, EventObserve {
            Navigation.findNavController(binding.root)
                .navigate(SeeAllFragmentDirections.actionSeeAllFragmentToDetailsFragment(it))
        })
    }

    private fun savePostMessage() {
        viewModel.isSavedPost.observe(this, EventObserve {
            if (it) {
                context?.showToast("Saved this post")
            }
        })
    }

}