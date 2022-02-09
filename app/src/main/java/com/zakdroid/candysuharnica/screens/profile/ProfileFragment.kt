package com.zakdroid.candysuharnica.screens.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.screens.basket.BasketFragment


class ProfileFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = BasketFragment()
    }
}