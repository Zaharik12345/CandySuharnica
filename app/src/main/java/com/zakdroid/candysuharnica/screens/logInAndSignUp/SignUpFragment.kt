package com.zakdroid.candysuharnica.screens.logInAndSignUp

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.databinding.FragmentSignUpBinding

class SignUpFragment: Fragment() {
    private lateinit var viewModel: SignUpViewModel
    private lateinit var binding: FragmentSignUpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SignUpViewModel::class.java)
        viewModel.setNavController(findNavController())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding  = FragmentSignUpBinding.inflate(inflater,container,false)

        binding.bSignUp.setOnClickListener {
            viewModel.register(
                binding.etMail.text.toString(),
                binding.etPassword.text.toString()
            )
        }
        binding.clickableTvSignIn.setOnClickListener {
            viewModel.goToSignIn()
        }
        return binding.root
    }

}
