package com.zakdroid.candysuharnica.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.databinding.FragmentSplashBinding
import com.zakdroid.candysuharnica.ui.main.MainActivity

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    private lateinit var viewModel: SplashViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        viewModel = ViewModelProvider(this).get(SplashViewModel::class.java)

        viewModel.responseLiveData.observe(viewLifecycleOwner) {
            viewModel.fillDB(it)
            renderAnimations()
        }

    }


    private fun launchMainScreen() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }


    private fun renderAnimations() {
        binding.imgViewLogo.animate()
            .alpha(1f)
            .setDuration(1000)
            .withEndAction { launchMainScreen() }
    }
}