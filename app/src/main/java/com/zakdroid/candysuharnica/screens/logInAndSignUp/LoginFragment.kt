package com.zakdroid.candysuharnica.screens.logInAndSignUp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.zakdroid.candysuharnica.databinding.FragmentLoginBinding

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
    ): View {

        binding  = FragmentLoginBinding.inflate(inflater, container, false)

        binding.bSignUp.setOnClickListener {
            with(binding){
                when {
                    etMail.text.isNullOrBlank() -> etMail.error = "Введите почту"
                    etPassword.text.isNullOrBlank() -> etPassword.error = "Введите пароль"
                    else -> viewModel.login(
                        binding.etMail.text.toString(),
                        binding.etPassword.text.toString(),
                        requireContext())
                }
            }

        }
        binding.clickableTvSignUp.setOnClickListener {
            viewModel.goToSignUp()
        }

        return binding.root
    }

}