package com.github.taasonei.navigation_study.color.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
internal data class ColorData(
    val name: String,
    val color: String,
) : Parcelable

internal object ColorGenerator {
    private val colorList = listOf(
        ColorData(
            name = "Розовый",
            color = "#FF1493"
        ),
        ColorData(
            name = "Малиновый",
            color = "#DC143C"
        ),
        ColorData(
            name = "Красный",
            color = "#FF0000"
        ),
        ColorData(
            name = "Оранжево-красный",
            color = "#FF4500"
        ),
        ColorData(
            name = "Оранжевый",
            color = "#FFA500"
        ),
        ColorData(
            name = "Желтый",
            color = "#FFFF00"
        ),
        ColorData(
            name = "Лаймовый",
            color = "#00FF00"
        ),
        ColorData(
            name = "Зеленый",
            color = "#008000"
        ),
        ColorData(
            name = "Бирюзовый",
            color = "#40E0D0"
        ),
        ColorData(
            name = "Голубой",
            color = "#1E90FF"
        ),
        ColorData(
            name = "Синий",
            color = "#0000FF"
        ),
        ColorData(
            name = "Фиолетовый",
            color = "#483D8B"
        ),
    )

    fun getColorData() = colorList
    fun getRandomColor() = colorList.random()
}
