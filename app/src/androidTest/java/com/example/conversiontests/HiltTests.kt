package com.example.conversiontests

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class HiltIntegrationTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var converter: UnitConverter

    @Test
    fun testInjection() {
        hiltRule.inject()
        assertNotNull(converter)
        assertEquals(212.0, converter.celsiusToFahrenheit(100.0), 0.001)
    }
}