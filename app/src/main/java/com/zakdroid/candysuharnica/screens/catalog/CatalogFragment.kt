package com.zakdroid.candysuharnica.screens.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.material.chip.Chip
import com.google.android.material.shape.ShapeAppearanceModel
import com.zakdroid.candysuharnica.R
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

        setChips()

        adapter = AdapterRVCatalog()
        adapter.catalogItems = viewModel.getListFromType(START_WORD)

        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewCatalog.layoutManager = layoutManager
        binding.recyclerViewCatalog.adapter = adapter

        return binding.root
    }

    private fun setChips() {
        val listType = viewModel.getListType()
        createChip(START_WORD)
        listType.forEach {
            createChip(it)
        }
        binding.chipGroup.setOnCheckedChangeListener { group, checkedId ->
            val checkedChip = group[checkedId]
            val typeChip = (checkedChip as Chip).text.toString()
            adapter.catalogItems = viewModel.getListFromType(typeChip)
        }
    }

    private fun createChip(str: String) {
        val chip = Chip(requireContext())
        chip.text = str
        chip.shapeAppearanceModel = ShapeAppearanceModel().withCornerSize(5f)
        chip.chipStrokeWidth = 5f
        chip.isCheckable = true
        chip.isCheckedIconVisible = false
        if (str == START_WORD) chip.isChecked = true
        val colorStateListBackground =
            ContextCompat.getColorStateList(requireContext(), R.color.chip_background_color)
        chip.chipBackgroundColor = colorStateListBackground
        val colorStateListText =
            ContextCompat.getColorStateList(requireContext(), R.color.chip_background_text)
        chip.chipStrokeColor = colorStateListText
        chip.setTextColor(colorStateListText)
        binding.chipGroup.addView(chip)
    }

    companion object {
        const val START_WORD = "Все"
    }
}