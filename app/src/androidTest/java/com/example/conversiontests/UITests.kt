package com.example.conversiontests

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testConversionFlow() {
        hiltRule.inject()
        composeTestRule.onNodeWithText("Value").performTextInput("100")
        composeTestRule.onNodeWithText("Convert").performClick()
        composeTestRule.onNodeWithText("Result: 212.0").assertExists()
    }
}