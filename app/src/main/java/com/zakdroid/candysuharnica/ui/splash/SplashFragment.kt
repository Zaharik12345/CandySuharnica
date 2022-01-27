package com.zakdroid.candysuharnica.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zakdroid.candysuharnica.data.model.CatalogItem
import com.zakdroid.candysuharnica.databinding.FragmentSplashBinding
import com.zakdroid.candysuharnica.ui.main.viewModels.CatalogViewModel
import com.zakdroid.candysuharnica.utils.viewModelCreator

class SplashFragment : Fragment() {

    private lateinit var binding: FragmentSplashBinding

    private lateinit var viewModel: CatalogViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)

        // just some animations example
        //renderAnimations()
        viewModel.responseLiveData.observe(this, {
            fillDB(it.catalogItems!!)
        })

       // viewModel.launchMainScreenEvent.observeEvent(viewLifecycleOwner) { launchMainScreen(it) }

    }

    private fun fillDB(catalogItems: List<CatalogItem>){

    }

    /*private fun launchMainScreen(isSignedIn: Boolean) {
        val intent = Intent(requireContext(), MainActivity::class.java)

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)

        val args = MainActivityArgs(isSignedIn)
        intent.putExtras(args.toBundle())
        startActivity(intent)
    }

    private fun renderAnimations() {
        binding.loadingIndicator.alpha = 0f
        binding.loadingIndicator.animate()
            .alpha(0.7f)
            .setDuration(1000)
            .start()

        binding.pleaseWaitTextView.alpha = 0f
        binding.pleaseWaitTextView.animate()
            .alpha(1f)
            .setStartDelay(500)
            .setDuration(1000)
            .start()

    }*/
}