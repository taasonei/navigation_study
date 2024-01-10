package com.github.taasonei.navigation_study.color.ui

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.taasonei.navigation_study.color.data.ColorData
import com.github.taasonei.navigation_study.databinding.FragmentColorDetailsBinding

class ColorDetailsFragment : Fragment() {

    private var _binding: FragmentColorDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentColorDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val colorData = if (Build.VERSION.SDK_INT > Build.VERSION_CODES.S_V2) {
            arguments?.getParcelable<ColorData>(ColorListFragment.COLOR_DATA, ColorData::class.java)
        } else {
            arguments?.getParcelable<ColorData>(ColorListFragment.COLOR_DATA)
        }

        colorData?.let { colorData ->
            binding.detailsColorName.text = colorData.name
            binding.root.setBackgroundColor(Color.parseColor(colorData.color))
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
