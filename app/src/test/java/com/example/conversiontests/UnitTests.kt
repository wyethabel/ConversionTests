package com.example.conversiontests

import org.junit.Assert.assertEquals
import org.junit.Test

class UnitConverterTest {

    private val converter = UnitConverter()

    @Test
    fun testCelsiusToFahrenheit() {
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.001)
    }

    @Test
    fun testFahrenheitToCelsius() {
        assertEquals(100.0, converter.fahrenheitToCelsius(212.0), 0.001)
    }

    @Test
    fun testMilesToKilometers() {
        assertEquals(1.60934, converter.milesToKilometers(1.0), 0.001)
    }

    @Test
    fun testKilogramsToPounds() {
        assertEquals(2.20462, converter.kilogramsToPounds(1.0), 0.001)
    }
}