package com.github.taasonei.navigation_study.digit.presentation

import androidx.lifecycle.ViewModel
import com.github.taasonei.navigation_study.digit.data.DigitGenerator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DigitGeneratorViewModel : ViewModel() {

    private val _digit = MutableStateFlow(DigitGenerator.generate())
    val digit: StateFlow<Int> = _digit.asStateFlow()

    fun generateDigit() {
        _digit.value = DigitGenerator.generate()
    }
}
