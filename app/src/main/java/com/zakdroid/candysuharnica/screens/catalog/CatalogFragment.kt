package com.zakdroid.candysuharnica.screens.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.zakdroid.candysuharnica.databinding.FragmentCatalogBinding
import com.zakdroid.candysuharnica.utils.adapters.AdapterRVCatalog


class CatalogFragment : Fragment() {

    private lateinit var viewModel: CatalogViewModel
    private lateinit var binding: FragmentCatalogBinding
    private lateinit var adapter: AdapterRVCatalog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCatalogBinding.inflate(inflater, container, false)

        adapter = AdapterRVCatalog()
        adapter.catalogItems = viewModel.getList()

        val layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerViewCatalog.layoutManager = layoutManager
        binding.recyclerViewCatalog.adapter = adapter

        return binding.root
    }


}