package com.github.taasonei.navigation_study.digit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.github.taasonei.navigation_study.R
import com.github.taasonei.navigation_study.databinding.FragmentDigitGeneratorBinding
import com.github.taasonei.navigation_study.digit.presentation.DigitGeneratorViewModel
import kotlinx.coroutines.launch

class DigitGeneratorFragment : Fragment() {

    private var _binding: FragmentDigitGeneratorBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<DigitGeneratorViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDigitGeneratorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.generateDigitDescription.text =
            getString(R.string.generated_digit_title, "")
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            generateDigitButton.setOnClickListener {
                viewModel.generateDigit()
            }

            returnDigitButton.setOnClickListener {
                findNavController()
                    .previousBackStackEntry
                    ?.savedStateHandle
                    ?.set(
                        DigitResultFragment.KEY_DIGIT,
                        viewModel.digit.value
                    )

                findNavController().popBackStack()
            }

            lifecycleScope.launch {
                repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.digit.collect {
                        generatedDigit.text = it.toString()
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}