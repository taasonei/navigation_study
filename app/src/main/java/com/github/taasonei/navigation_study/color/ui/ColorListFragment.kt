package com.github.taasonei.navigation_study.color.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.github.taasonei.navigation_study.R
import com.github.taasonei.navigation_study.color.presentation.ColorViewModel
import com.github.taasonei.navigation_study.color.ui.recycler.ColorAdapter
import com.github.taasonei.navigation_study.databinding.FragmentColorListBinding
import kotlinx.coroutines.launch

class ColorListFragment : Fragment() {

    private val viewModel: ColorViewModel by viewModels()

    private var _binding: FragmentColorListBinding? = null
    private val binding get() = _binding!!

    private var adapter: ColorAdapter? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentColorListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAdapter()
        observeColorState()
    }

    private fun setupAdapter() {
        adapter = ColorAdapter(
            onClick = { colorData ->
                Navigation
                    .findNavController(requireActivity(), R.id.mainContainer)
                    .navigate(
                        R.id.global_action_colorDetailsFragment,
                        bundleOf(COLOR_DATA to colorData)
                    )
            }
        )
        adapter?.stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        binding.colorRecycler.adapter = adapter
    }

    private fun observeColorState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.colorState.collect { colorState ->
                    adapter?.submitList(colorState)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        adapter = null
    }

    companion object {
        const val COLOR_DATA = "color_data"
    }
}
