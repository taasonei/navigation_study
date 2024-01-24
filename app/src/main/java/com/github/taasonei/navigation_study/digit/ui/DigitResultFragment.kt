package com.github.taasonei.navigation_study.digit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.github.taasonei.navigation_study.R
import com.github.taasonei.navigation_study.databinding.FragmentDigitResultBinding

class DigitResultFragment : Fragment() {

    private var _binding: FragmentDigitResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentDigitResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        binding.digitMainDescription.text = getString(R.string.empty_digit_title)
    }

    private fun initListeners() {
        binding.digitMainGenerateButton.setOnClickListener {
            findNavController().navigate(
                R.id.action_digitResultFragment_to_digitGeneratorFragment
            )
        }

        findNavController()
            .currentBackStackEntry
            ?.savedStateHandle
            ?.getLiveData<Int>(KEY_DIGIT)
            ?.observe(viewLifecycleOwner) { digit ->
                binding.digitMainDescription.text = getString(R.string.generated_digit_title, digit.toString())
            }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        const val KEY_DIGIT = "digit"
    }
}