package com.github.taasonei.navigation_study.color.ui.recycler

import androidx.recyclerview.widget.DiffUtil
import com.github.taasonei.navigation_study.color.data.ColorData

internal class ColorDiffUtils : DiffUtil.ItemCallback<ColorData>() {

    override fun areItemsTheSame(oldItem: ColorData, newItem: ColorData): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: ColorData, newItem: ColorData): Boolean {
        return oldItem == newItem
    }
}
