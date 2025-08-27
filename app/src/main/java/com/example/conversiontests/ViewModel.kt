package com.example.conversiontests

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State

@HiltViewModel
class ConverterViewModel @Inject constructor(
    private val converter: UnitConverter
) : ViewModel() {

    private val _result = mutableStateOf("")
    val result: State<String> = _result

    fun convertTemperature(value: Double, toFahrenheit: Boolean) {
        _result.value = if (toFahrenheit)
            converter.celsiusToFahrenheit(value).toString()
        else
            converter.fahrenheitToCelsius(value).toString()
    }

    fun convertDistance(value: Double, toKm: Boolean) {
        _result.value = if (toKm)
            converter.milesToKilometers(value).toString()
        else
            converter.kilometersToMiles(value).toString()
    }

    fun convertWeight(value: Double, toLb: Boolean) {
        _result.value = if (toLb)
            converter.kilogramsToPounds(value).toString()
        else
            converter.poundsToKilograms(value).toString()
    }
}