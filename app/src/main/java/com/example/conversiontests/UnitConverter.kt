package com.example.conversiontests

import javax.inject.Inject

class UnitConverter @Inject constructor() {

    fun celsiusToFahrenheit(c: Double): Double = c * 9/5 + 32
    fun fahrenheitToCelsius(f: Double): Double = (f - 32) * 5/9

    fun milesToKilometers(m: Double): Double = m * 1.60934

    fun kilometersToMiles(km: Double): Double = km * 0.62137119

    fun kilogramsToPounds(kg: Double): Double = kg * 2.20462
    fun poundsToKilograms(lb: Double): Double = lb / 2.20462
}