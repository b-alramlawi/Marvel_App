package com.bahaa.marvelapp.view.details

import androidx.navigation.fragment.navArgs
import com.bahaa.marvelapp.R
import com.bahaa.marvelapp.databinding.FragmentDetailsBinding
import com.bahaa.marvelapp.view.base.BaseFragment

class DetailsFragment : BaseFragment<FragmentDetailsBinding, DetailsViewModel>() {
    override val layoutIdFragment: Int = R.layout.fragment_details
    override val viewModelClass: Class<DetailsViewModel> = DetailsViewModel::class.java

    private val arguments: DetailsFragmentArgs by navArgs()

    override fun setup() {
        viewModel.getDetails(arguments.id)

    }

}