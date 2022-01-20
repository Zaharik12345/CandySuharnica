package com.zakdroid.candysuharnica.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zakdroid.candysuharnica.databinding.FragmentDetailCatalogItemBinding

class ItemDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailCatalogItemBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCatalogItemBinding.inflate(inflater, container, false)

        return binding.root
    }

}