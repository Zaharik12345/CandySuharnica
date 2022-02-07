package com.zakdroid.candysuharnica.ui.main.fragments.LogInAndSignUp

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zakdroid.candysuharnica.R

class SignUpFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up,container,false)
    }

    companion object{
        @JvmStatic
        fun newInstance() = SignUpFragment()
    }
}
