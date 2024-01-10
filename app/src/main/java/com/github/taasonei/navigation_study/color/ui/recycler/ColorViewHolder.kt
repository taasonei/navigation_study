package com.github.taasonei.navigation_study.color.ui.recycler

import androidx.recyclerview.widget.RecyclerView
import com.github.taasonei.navigation_study.color.data.ColorData
import com.github.taasonei.navigation_study.databinding.ColorItemBinding

internal class ColorViewHolder(
    private val binding: ColorItemBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(colorData: ColorData, onClick: (ColorData) -> Unit) {
        binding.colorButton.apply {
            text = colorData.name
            setOnClickListener { onClick(colorData) }
        }
    }
}