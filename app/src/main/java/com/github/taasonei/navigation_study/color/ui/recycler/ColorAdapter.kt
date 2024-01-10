package com.github.taasonei.navigation_study.color.ui.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.github.taasonei.navigation_study.color.data.ColorData
import com.github.taasonei.navigation_study.databinding.ColorItemBinding

internal class ColorAdapter(
    private val onClick: (ColorData) -> Unit
) : ListAdapter<ColorData, ColorViewHolder>(ColorDiffUtils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorViewHolder {
        return ColorViewHolder(
            ColorItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ColorViewHolder, position: Int) {
        holder.bind(
            colorData = getItem(position),
            onClick = onClick,
        )
    }
}
