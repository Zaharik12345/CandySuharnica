package com.zakdroid.candysuharnica.ui.main.fragments.LogInAndSignUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zakdroid.candysuharnica.R

class LogInFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login,container,false)
    }

    companion object{
        @JvmStatic
        fun newInstance() = LogInFragment()
    }
}