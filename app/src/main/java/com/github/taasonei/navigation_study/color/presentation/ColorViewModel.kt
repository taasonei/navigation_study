package com.github.taasonei.navigation_study.color.presentation

import androidx.lifecycle.ViewModel
import com.github.taasonei.navigation_study.color.data.ColorData
import com.github.taasonei.navigation_study.color.data.ColorGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

internal class ColorViewModel : ViewModel() {

    private val _colorState = MutableStateFlow(ColorGenerator.getColorData())
    val colorState: StateFlow<List<ColorData>> = _colorState.asStateFlow()
}
