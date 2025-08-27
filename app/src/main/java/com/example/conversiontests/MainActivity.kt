package com.example.conversiontests

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.viewmodel.compose.viewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnitConverterAppUI()
        }
    }
}

@Composable
fun UnitConverterAppUI(vm: ConverterViewModel = viewModel()) {
    var input by remember { mutableStateOf("") }
    var conversionType by remember { mutableStateOf("C->F") }
    var dropdownExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {

        // Input field
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text("Value") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Dropdown
        Box {
            Button(onClick = { dropdownExpanded = true }) {
                Text(conversionType)
            }

            DropdownMenu(
                expanded = dropdownExpanded,
                onDismissRequest = { dropdownExpanded = false }
            ) {
                val options = listOf("C->F", "F->C", "m->km", "km->m", "kg->lb", "lb->kg")
                options.forEach { option ->
                    DropdownMenuItem(onClick = {
                        conversionType = option
                        dropdownExpanded = false
                    }) {
                        Text(option)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Convert button
        Button(onClick = {
            val value = input.toDoubleOrNull() ?: 0.0
            when (conversionType) {
                "C->F" -> vm.convertTemperature(value, true)
                "F->C" -> vm.convertTemperature(value, false)
                "m->km" -> vm.convertDistance(value, true)
                "km->m" -> vm.convertDistance(value, false)
                "kg->lb" -> vm.convertWeight(value, true)
                "lb->kg" -> vm.convertWeight(value, false)
            }
        }) {
            Text("Convert")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Result
        Text(
            text = "Result: ${vm.result.value}",
            style = MaterialTheme.typography.h6
        )
    }
}