package com.bahaa.marvelapp.view.home

import androidx.navigation.Navigation.findNavController
import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.databinding.FragmentHomeBinding
import com.bahaa.marvelapp.view.base.BaseFragment
import com.bahaa.marvelapp.util.EventObserve

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_home
    override val viewModelClass: Class<HomeViewModel> = HomeViewModel::class.java

    override fun setup() {
        binding.recyclerHome.adapter = HomeAdapter(mutableListOf(HomeItems.SeeAllType()), viewModel)

        navigateToFavoriteFragment()
        observeDataToNestedAdapter()
        navigateToDetailsFragment()
        navigateToSeeAllFragment()

    }


    private fun observeDataToNestedAdapter() {
        (binding.recyclerHome.adapter as HomeAdapter?)?.let { homeAdapter ->

            viewModel.character.observe(this@HomeFragment) { character ->
                character.toData()?.data.let {
                    homeAdapter.setItems(HomeItems.CharactersType(it?.results))
                }
            }

            viewModel.comics.observe(this@HomeFragment) { comics ->
                comics.toData()?.data.let {
                    homeAdapter.setItems(HomeItems.ComicsType(it?.results?.reversed()))
                }
            }
        }
    }

    private fun navigateToFavoriteFragment() {
        viewModel.navigateToFavoriteFragment.observe(this, EventObserve {
            findNavController(binding.root)
                .navigate(HomeFragmentDirections.actionHomeFragmentToFavoriteFragment())
        })
    }

    private fun navigateToDetailsFragment() {
        viewModel.navigateToDetailsFragment.observe(this, EventObserve {
            findNavController(binding.root)
                .navigate(HomeFragmentDirections.actionHomeFragmentToDetailsFragment(it))
        })
    }

    private fun navigateToSeeAllFragment() {
        viewModel.navigateToSeeAllFragment.observe(this, EventObserve {
            if (it) {
                findNavController(binding.root)
                    .navigate(HomeFragmentDirections.actionHomeFragmentToSeeAllFragment())
            }
        })
    }


}