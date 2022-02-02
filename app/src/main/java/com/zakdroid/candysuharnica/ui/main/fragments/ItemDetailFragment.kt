package com.zakdroid.candysuharnica.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.zakdroid.candysuharnica.databinding.FragmentDetailCatalogItemBinding

class ItemDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailCatalogItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCatalogItemBinding.inflate(inflater, container, false)

        setViewOnLayout(binding)
        return binding.root
    }

    private fun setViewOnLayout(binding: FragmentDetailCatalogItemBinding) {
        val catalogItem = navArgs<ItemDetailFragmentArgs>().value.item
        binding.tvLikes.text = catalogItem.likes
        binding.tvTitleInActionBar.text = catalogItem.name
        binding.tvTitleInCardView.text = catalogItem.name
        binding.tvWeight.text = catalogItem.weight.plus(" г")
        binding.tvPrice.text = catalogItem.price.plus(" BYN")
        binding.tvDescription.text = catalogItem.about

     }

}