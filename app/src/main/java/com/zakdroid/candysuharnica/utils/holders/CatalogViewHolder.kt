package com.zakdroid.candysuharnica.utils.holders

import android.graphics.Color
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import coil.load
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.databinding.ItemCatalogBinding
import com.zakdroid.candysuharnica.model.dbRoom.catalog.CatalogItem

class CatalogViewHolder(
   binding: ItemCatalogBinding,
   val onLike: (CatalogItem) -> Unit,
   val onAddItem: (CatalogItem) -> Unit,
   val onOpenDetail: (CatalogItem) -> Unit,
) : BaseViewHolder<ItemCatalogBinding,CatalogItem>(binding){



   init {
      with(binding) {
         llSmileAndLikes.setOnClickListener {
            onLike(item)
         }
         ibBasket.setOnClickListener {
            onAddItem(item)
         }
         root.setOnClickListener {
            onOpenDetail(item)
         }
      }
   }


   override fun onBind(item: CatalogItem) {
      with(binding) {

         ivIcon.load(item.imgUrl[0]) {
            crossfade(true)
            crossfade(2000)
            placeholder(R.drawable.animate_rotate)
            target(onStart = { placeholder ->
               ivIcon.scaleType = ImageView.ScaleType.CENTER_INSIDE
               ivIcon.setImageDrawable(placeholder)
            },
               onSuccess = { result ->
                  ivIcon.scaleType = ImageView.ScaleType.CENTER_CROP
                  ivIcon.setImageDrawable(result)
               })
         }

         tvWeight.text = item.weight.toString().plus(" г")
         tvName.text = item.name
         val likes = item.likes.toDouble()


/////////////////////////////////////////////////////////////////////////////////////////////
         //if catalogItem has sale
         if (item.price != item.priceSale) {

            tvPriceSale.visibility = View.VISIBLE
            vCross.visibility = View.VISIBLE

            tvPrice.text = item.priceSale.toString().plus(" BYN")
            tvPriceSale.text = item.price.toString().plus(" BYN")

            val colorLime = ContextCompat.getColor(
               context,
               R.color.lime
            )
            mcvRoot.setBackgroundColor(colorLime)
            ibBasket.setBackgroundColor(colorLime)
         } else {
            tvPrice.text = item.price.toString().plus(" BYN")

            tvPriceSale.visibility = View.INVISIBLE
            vCross.visibility = View.INVISIBLE

            mcvRoot.setBackgroundColor(Color.WHITE)
            ibBasket.setBackgroundColor(Color.WHITE)
         }
         //set likes, if count > 999 then show 1.2 k for example
         tvLikes.text = when {
            likes > 999 -> String.format("%.1f", likes / 1000)
               .plus(" k") //rounding numbers
            else -> String.format("%.0f", likes)
         }
         //set likes color, if isLiked -> LimeColor
         if (item.isLiked) {
            val colorDarkLime = ContextCompat.getColor(
               context,
               R.color.darkLime
            )
            ivSmileLikes.setColorFilter(colorDarkLime)
            tvLikes.setTextColor(colorDarkLime)
         } else {
            val colorGrey = ContextCompat.getColor(
               context,
               R.color.grey
            )
            ivSmileLikes.setColorFilter(colorGrey)
            tvLikes.setTextColor(colorGrey)
         }

         if(db.basketDao().getItemFromId(item.id)!=null){
            ibBasket.setImageResource(R.drawable.icon_basket_active)
         }
      }
      }
   }
}