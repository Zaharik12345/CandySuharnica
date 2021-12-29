package com.zakdroid.candysuharnica.ui.main.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.ui.main.viewModels.CatalogViewModel


class CatalogFragment : Fragment() {

    private lateinit var viewModel: CatalogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_catalog, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BasketFragment()
    }
}