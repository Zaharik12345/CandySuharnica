package com.zakdroid.candysuharnica.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogItem
import com.zakdroid.candysuharnica.databinding.FragmentDetailCatalogItemBinding
import com.zakdroid.candysuharnica.ui.main.adapters.AdapterRCImageSlider
import com.zakdroid.candysuharnica.ui.main.adapters.AdapterRVOneLineString2Grid

class ItemDetailFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentDetailCatalogItemBinding
    private lateinit var catalogItem: CatalogItem


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailCatalogItemBinding.inflate(inflater, container, false)
        catalogItem = navArgs<ItemDetailFragmentArgs>().value.item
        setViewOnLayout(binding)
        return binding.root
    }

    private fun setViewOnLayout(binding: FragmentDetailCatalogItemBinding) {


        with(binding) {
            tvLikes.text = catalogItem.likes.toString()
            tvTitleInActionBar.text = catalogItem.name
            tvTitleInCardView.text = catalogItem.name
            tvWeight.text = catalogItem.weight.toString().plus(" г")
            tvPrice.text = catalogItem.price.toString().plus(" BYN")
            tvDescription.text = catalogItem.about

            rvImage.layoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
            rvImage.adapter = AdapterRCImageSlider(catalogItem.imgUrl)
            rvComposition.adapter = AdapterRVOneLineString2Grid(catalogItem.product_composition)
            rvNutritional.adapter = AdapterRVOneLineString2Grid(catalogItem.nutritional_value)

            ibArrowBack.setOnClickListener(this@ItemDetailFragment)
            llSmileAndLikes.setOnClickListener(this@ItemDetailFragment)
        }
    }

    private fun onGoBackButtonPressed() {
        findNavController().popBackStack()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.ib_arrow_back -> onGoBackButtonPressed()
            R.id.ib_share -> {

            }
            R.id.ll_smile_and_likes -> {

            }
        }
    }

}