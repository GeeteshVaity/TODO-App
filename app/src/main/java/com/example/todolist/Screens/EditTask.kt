package com.example.todolist.Screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.todolist.Components.PriorityDropdown
import com.example.todolist.Data.local.entities.Priority
import com.example.todolist.Data.local.entities.Task
import com.example.todolist.ui.ViewModel.TaskViewModel

@Composable
fun EditTask(
    navController: NavController,
    viewModel: TaskViewModel = hiltViewModel()
) {

    val taskId = navController.currentBackStackEntry
        ?.arguments
        ?.getInt("taskId")

    LaunchedEffect(taskId) {
        taskId?.let { viewModel.loadTask(it) }
    }

    val task by viewModel.selectedTask.collectAsState()

    task?.let { existingTask ->

        var name by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }
        var selectedPriority by remember { mutableStateOf(Priority.MEDIUM) }
        var expanded by remember { mutableStateOf(false) }
        var showDatePicker by remember { mutableStateOf(false) }

        LaunchedEffect(existingTask.id) {
            name = existingTask.name
            date = existingTask.date
            selectedPriority = existingTask.priority
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // ✏️ Task name
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Task") },
                shape = MaterialTheme.shapes.medium,
                textStyle = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 📅 Date field (FUNCTION UNCHANGED)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { showDatePicker = true }
            ) {
                OutlinedTextField(
                    value = date,
                    onValueChange = {},
                    label = { Text("Date") },
                    readOnly = true,
                    shape = MaterialTheme.shapes.medium,
                    textStyle = MaterialTheme.typography.bodyLarge,
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Pick date",
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable {
                                showDatePicker = true
                            }
                        )
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { showDatePicker = true }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 🔽 Priority dropdown (already modern)
            PriorityDropdown(
                selectedPriority = selectedPriority,
                onPrioritySelected = { selectedPriority = it }
            )

            Spacer(modifier = Modifier.height(28.dp))

            // 💾 Actions
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Button(
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = MaterialTheme.shapes.large,
                    onClick = {
                        val updatedTask = Task(
                            id = existingTask.id,
                            name = name,
                            date = date,
                            priority = selectedPriority
                        )

                        viewModel.updateTask(updatedTask)
                        navController.popBackStack()
                    }
                ) {
                    Text(
                        text = "Save Changes",
                        style = MaterialTheme.typography.labelLarge
                    )
                }

                OutlinedButton(
                    modifier = Modifier
                        .weight(1f)
                        .height(52.dp),
                    shape = MaterialTheme.shapes.large,
                    onClick = { navController.popBackStack() }
                ) {
                    Text(
                        text = "Cancel",
                        style = MaterialTheme.typography.labelLarge
                    )
                }
            }
        }

        // 📅 Date picker dialog (UNCHANGED)
        if (showDatePicker) {
            DatePickerDialogExample(
                onDateSelected = {
                    date = it
                    showDatePicker = false
                },
                onDismiss = {
                    showDatePicker = false
                }
            )
        }
    }
}
