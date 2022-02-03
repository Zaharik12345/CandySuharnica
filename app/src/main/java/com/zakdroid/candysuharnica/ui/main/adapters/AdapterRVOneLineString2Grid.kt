package com.zakdroid.candysuharnica.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.zakdroid.candysuharnica.databinding.ItemOneLineStringBinding

class AdapterRVOneLineString2Grid(
    private val list: List<String>
): RecyclerView.Adapter<OneLineStringViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneLineStringViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOneLineStringBinding.inflate(inflater, parent, false)
        return OneLineStringViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OneLineStringViewHolder, position: Int) {
       holder.binding.tvString.text = list[position]
    }

    override fun getItemCount(): Int = list.size

}

class OneLineStringViewHolder(
    val binding: ItemOneLineStringBinding
) : RecyclerView.ViewHolder(binding.root)