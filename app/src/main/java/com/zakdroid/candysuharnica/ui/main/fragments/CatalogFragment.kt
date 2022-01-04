package com.zakdroid.candysuharnica.ui.main.fragments

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.data.model.CatalogResponse
import com.zakdroid.candysuharnica.databinding.FragmentCatalogBinding
import com.zakdroid.candysuharnica.ui.main.adapters.AdapterRecyclerViewCatalog
import com.zakdroid.candysuharnica.ui.main.viewModels.CatalogViewModel


class CatalogFragment : Fragment() {

    private lateinit var viewModel: CatalogViewModel
    private lateinit var binding: FragmentCatalogBinding
    private lateinit var adapter: AdapterRecyclerViewCatalog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        adapter = AdapterRecyclerViewCatalog()
        viewModel.responseLiveData.observe(this, {
            adapter.catalogItems = it.catalogItems
        })
        binding = FragmentCatalogBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        val layoutManager = GridLayoutManager(requireContext(),2)
        binding.recyclerViewCatalog.layoutManager = layoutManager
        binding.recyclerViewCatalog.adapter = adapter

        return binding.root
    }


    private fun getResponseUsingCoroutines() {
        viewModel.responseLiveData.observe(this, {
            adapter.catalogItems = it.catalogItems
        })
    }

    private fun print(response: CatalogResponse) {
        response.catalogItems?.let { products ->
            products.forEach{ product ->
                product.name?.let {
                    Toast.makeText(context,it,Toast.LENGTH_SHORT).show()
                }
            }
        }

        response.exception?.let { exception ->
            exception.message?.let {
                Log.e(ContentValues.TAG, it)
            }
        }
    }


}