package com.zakdroid.candysuharnica.utils.holders

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.zakdroid.candysuharnica.model.dbRoom.Item

abstract class BaseViewHolder<out V : ViewBinding, I : Item>(
    open val binding: V
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var item: I

    open fun onBind(item: I) {
        this.item = item
    }

    open fun onBind(item: I, payloads: List<Any>) {
        this.item = item
    }
}