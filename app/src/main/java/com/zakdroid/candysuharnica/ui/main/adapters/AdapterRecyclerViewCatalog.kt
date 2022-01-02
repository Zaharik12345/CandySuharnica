package com.zakdroid.candysuharnica.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.data.model.CatalogItem
import com.zakdroid.candysuharnica.databinding.CatalogItemBinding

class AdapterRecyclerViewCatalog: RecyclerView.Adapter<CatalogViewHolder>() {

    var catalogItems: List<CatalogItem>? = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }
    private lateinit var context: Context


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CatalogItemBinding.inflate(inflater, parent, false)

        context = parent.context
        //binding.moreImageViewButton.setOnClickListener(this)

        return CatalogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val catalogListItem = catalogItems?.get(position)

        with(holder.binding){
            ivIcon.load(catalogListItem!!.imgUrl)
            tvPrice.text = catalogListItem.price.plus(" BYN")
            tvName.text = catalogListItem.name
            tvWeight.text = catalogListItem.weight.plus(" г")

            //if catalogItem has sale
            if (catalogListItem.price != catalogListItem.priceSale){
                tvPriceSale.visibility = View.VISIBLE
                tvPriceSale.text = catalogListItem.priceSale.plus(" BYN")
                vCross.visibility = View.VISIBLE
                mcvRoot.setBackgroundColor(ContextCompat.getColor(context, R.color.lime)) //doesn't work? i don't know
                bBasket.setBackgroundColor(ContextCompat.getColor(context, R.color.lime))
            }
        }



    }

    override fun getItemCount(): Int = catalogItems!!.size

    /*override fun onClick(v: View) {
        val catalogItem = v.tag as CatalogItem
        when (v.id) {
            R.id.moreImageViewButton -> {
                showPopupMenu(v)
            }
            else -> {
                actionListener.onUserDetails(user)
            }
        }
    }*/

}

class CatalogViewHolder(
    val binding: CatalogItemBinding
) : RecyclerView.ViewHolder(binding.root)

