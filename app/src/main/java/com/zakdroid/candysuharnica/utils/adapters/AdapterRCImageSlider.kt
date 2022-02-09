package com.zakdroid.candysuharnica.utils.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zakdroid.candysuharnica.databinding.ItemSliderHolderBinding

class AdapterRCImageSlider(
    val list: List<String>
) : RecyclerView.Adapter<ImageSliderHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageSliderHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemSliderHolderBinding.inflate(inflater, parent, false)

        return ImageSliderHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageSliderHolder, position: Int) {
        holder.binding.image.load(list[position])
    }

    override fun getItemCount(): Int = list.size
}
class ImageSliderHolder(
    val binding: ItemSliderHolderBinding
):RecyclerView.ViewHolder(binding.root)