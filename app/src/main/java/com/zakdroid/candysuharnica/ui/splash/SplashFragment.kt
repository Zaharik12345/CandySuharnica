package com.zakdroid.candysuharnica.ui.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.zakdroid.candysuharnica.R
import com.zakdroid.candysuharnica.databinding.FragmentSplashBinding
import com.zakdroid.candysuharnica.ui.main.MainActivity
import com.zakdroid.candysuharnica.ui.main.viewModels.CatalogViewModel

class SplashFragment : Fragment(R.layout.fragment_splash) {

    private lateinit var binding: FragmentSplashBinding

    private lateinit var viewModel: CatalogViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSplashBinding.bind(view)
        viewModel = ViewModelProvider(this).get(CatalogViewModel::class.java)
        // just some animations example
        renderAnimations()
        viewModel.responseLiveData.observe(this, {
            launchMainScreen()
        })

       // viewModel.launchMainScreenEvent.observeEvent(viewLifecycleOwner) { launchMainScreen(it) }

    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashBinding.inflate(inflater, container, false)
        //viewModel.responseLiveData.observe(this, { })
        return binding.root
    }
*/

    private fun launchMainScreen() {
        val intent = Intent(requireContext(), MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

    private fun renderAnimations() {
        binding.imgViewLogo.alpha = 0f
        binding.imgViewLogo.animate()
            .alpha(0.7f)
            .setDuration(1000)
            .start()

    }
}