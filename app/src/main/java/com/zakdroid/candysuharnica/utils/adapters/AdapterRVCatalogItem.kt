package com.zakdroid.candysuharnica.utils.adapters

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.AnimatedVectorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.zakdroid.candysuharnica.App
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.data.dbRoom.AppDatabase
import com.zakdroid.candysuharnica.data.dbRoom.basket.BasketDbEntity
import com.zakdroid.candysuharnica.data.dbRoom.basket.BasketItem
import com.zakdroid.candysuharnica.data.dbRoom.catalog.CatalogItem
import com.zakdroid.candysuharnica.databinding.ItemCatalogBinding
import com.zakdroid.candysuharnica.screens.catalog.CatalogFragmentDirections

class AdapterRVCatalog : RecyclerView.Adapter<CatalogViewHolder>(), View.OnClickListener {

    var catalogItems: List<CatalogItem> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    private lateinit var catalogFragment: Fragment

    private lateinit var context: Context

    private lateinit var binding: ItemCatalogBinding

    private var db: AppDatabase = App.instance?.getDatabase() ?: throw Exception("error")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatalogViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemCatalogBinding.inflate(inflater, parent, false)

        context = parent.context
        catalogFragment = parent.findFragment()
        binding.ivIcon.scaleType = ImageView.ScaleType.CENTER_CROP

        return CatalogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatalogViewHolder, position: Int) {

        val catalogListItem = catalogItems[position]
        bindView(holder, catalogListItem)
    }


    override fun getItemCount(): Int = catalogItems.size

    override fun onClick(v: View) {

        val catalogItem = v.tag as CatalogItem

        when (v.id) {
            R.id.ll_smile_and_likes -> {

                with(catalogItems.firstOrNull { it.id == catalogItem.id }) {
                    if (this != null)
                        isLiked = !isLiked
                }
                notifyItemChanged(catalogItem.id)

            }
            R.id.mcv_root -> {
                val direction = CatalogFragmentDirections.actionCatalogFragmentToItemDetailFragment(
                    catalogItem
                )
                val navController = NavHostFragment.findNavController(catalogFragment)
                navController.navigate(direction)
            }
            R.id.ib_basket -> {
                val basket = v as ImageButton
                basket.setImageResource(R.drawable.add_to_basket_anim)
                val animTransformBasket = basket.drawable as AnimatedVectorDrawable
                animTransformBasket.start()

                addToBasket(catalogItem)
            }
            else -> {

            }
        }
    }

    private fun addToBasket(catalogItem: CatalogItem) {

        val basketItems = db.basketDao().getAll().map { it.toBasketItem() }
        for (item in basketItems) {
            if (item.productId == catalogItem.id) {
                val basket = BasketDbEntity(
                    id = item.id,
                    productId = item.productId,
                    count = item.count + 1,
                    amountPrice = item.amountPrice + catalogItem.price,
                    name = catalogItem.name,
                    imgURL = catalogItem.imgUrl[0],
                    amountWeight = item.amountWeight + catalogItem.weight
                )
                db.basketDao().update(basket)
            } else {
                val basket = BasketDbEntity(
                    id = 0,
                    productId = catalogItem.id,
                    count = 1,
                    amountPrice = catalogItem.price,
                    name = catalogItem.name,
                    imgURL = catalogItem.imgUrl[0],
                    amountWeight = catalogItem.weight
                )
                db.basketDao().insert(basket)
            }
        }
        if (basketItems.isEmpty()) db.basketDao().insert(
            BasketDbEntity.fromBasketItem(
                BasketItem(
                    id = 0,
                    productId = catalogItem.id,
                    count = 1,
                    amountPrice = catalogItem.price,
                    name = catalogItem.name,
                    imgURL = catalogItem.imgUrl[0],
                    amountWeight = catalogItem.weight
                )
            )
        )
    }

    private fun bindView(holder: CatalogViewHolder, catalogListItem: CatalogItem) {
        with(holder.binding) {

            llSmileAndLikes.tag = catalogListItem
            mcvRoot.tag = catalogListItem
            ibBasket.tag = catalogListItem

            ivIcon.load(catalogListItem.imgUrl[0]) {
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

            tvWeight.text = catalogListItem.weight.toString().plus(" г")
            tvName.text = catalogListItem.name
            val likes = catalogListItem.likes.toDouble()

            llSmileAndLikes.setOnClickListener(this@AdapterRVCatalog)
            ibBasket.setOnClickListener(this@AdapterRVCatalog)
            root.setOnClickListener(this@AdapterRVCatalog)

            //if catalogItem has sale
            if (catalogListItem.price != catalogListItem.priceSale) {

                tvPriceSale.visibility = View.VISIBLE
                vCross.visibility = View.VISIBLE

                tvPrice.text = catalogListItem.priceSale.toString().plus(" BYN")
                tvPriceSale.text = catalogListItem.price.toString().plus(" BYN")

                val colorLime = ContextCompat.getColor(
                    context,
                    R.color.lime
                )
                mcvRoot.setBackgroundColor(colorLime)
                ibBasket.setBackgroundColor(colorLime)

            } else {
                tvPrice.text = catalogListItem.price.toString().plus(" BYN")

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

            if (catalogListItem.isLiked) {
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
        }
    }
}

class CatalogViewHolder(
    val binding: ItemCatalogBinding
) : RecyclerView.ViewHolder(binding.root)

