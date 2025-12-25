package com.example.todolist.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextFieldDefaults.contentPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.todolist.Components.SortingChip

import com.example.todolist.Components.TaskCard
import com.example.todolist.Data.local.entities.sortTypes
import com.example.todolist.ui.ViewModel.TaskViewModel
import kotlin.collections.emptyList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController,
    viewModel: TaskViewModel = hiltViewModel()
) {
    var selectedSort by remember { mutableStateOf("Default") }
    val tasks by viewModel.tasks.collectAsState(initial = emptyList())
    val sortedTasks = when (selectedSort) {
        "Name" -> tasks.sortedBy { it.name.lowercase() }
        "Date" -> tasks.sortedBy { it.date }
        "Priority" -> tasks.sortedBy { it.priority }
        "Completed" -> tasks.filter { it.status }
        "Pending" -> tasks.filter { it.status.not() }
        else -> tasks
    }
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "My ToDo List",
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add_task") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Task")
            }
        }
    ) { innerPadding ->

        if (tasks.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No tasks yet ✨\nTap + to add one",
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        } else {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding) // 🔑 APPLIED ONCE
            ) {

                // 🔽 SORT BAR (NOW VISIBLE)
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp)
                ) {
                    items(sortTypes) { sortBy ->
                        SortingChip(
                            sortBy = sortBy,
                            selected = selectedSort == sortBy.label,
                            onClick = {
                                selectedSort = sortBy.label
                            }
                        )

                    }

                }

                // 📋 TASK LIST
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(
                        horizontal = 16.dp,
                        vertical = 12.dp
                    ),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(
                        items = sortedTasks,
                        key = { it.id }
                    ) { task ->
                        TaskCard(
                            task = task,
                            onEditClick = {
                                navController.navigate("edit_task/${task.id}")
                            },
                            onDeleteClick = {
                                viewModel.deleteTask(task)
                            },
                            onStatusChange = { completed ->
                                viewModel.updateTask(
                                    task.copy(status = completed)
                                )
                            }
                        )

                    }
                }
            }
        }
    }

}


@Composable
@PreviewLightDark
fun MainScreenPreview() {
    MainScreen(navController = rememberNavController())
}