package com.zakdroid.candysuharnica.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zakdroid.candysuharnica.data.model.CatalogItem
import com.zakdroid.candysuharnica.databinding.CatalogItemBinding

class AdapterRecyclerViewCatalog: RecyclerView.Adapter<CatalogViewHolder>() {

    var catalogItems: List<CatalogItem>? = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CatalogItemBinding.inflate(inflater, parent, false)

        //binding.moreImageViewButton.setOnClickListener(this)

        return CatalogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {
        val catalogListItem = catalogItems?.get(position)

        with(holder.binding){
            avatar.load(catalogListItem!!.imgUrl)
            price.text = catalogListItem.price
            name.text = catalogListItem.name
            weight.text = catalogListItem.weight
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

