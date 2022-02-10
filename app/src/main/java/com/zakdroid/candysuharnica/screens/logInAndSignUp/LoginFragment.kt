package com.zakdroid.candysuharnica.screens.logInAndSignUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.databinding.FragmentLoginBinding
import com.zakdroid.candysuharnica.screens.catalog.CatalogViewModel

class LoginFragment: Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        viewModel.setNavController(findNavController())
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding  = FragmentLoginBinding.inflate(inflater, container, false)

        binding.bSignUp.setOnClickListener {
            viewModel.login(
                binding.etLogin.text.toString(),
                binding.etPassword.text.toString())
        }
        binding.clickableTvSignUp.setOnClickListener {
            viewModel.goToSignUp()
        }

        return binding.root
    }

}