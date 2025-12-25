package com.example.todolist.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PriorityChip(priority: com.example.todolist.Data.local.entities.Priority) {
    val (bg, text) = when (priority) {
        com.example.todolist.Data.local.entities.Priority.HIGH ->
            MaterialTheme.colorScheme.errorContainer to "HIGH"
        com.example.todolist.Data.local.entities.Priority.MEDIUM ->
            MaterialTheme.colorScheme.tertiaryContainer to "MEDIUM"
        com.example.todolist.Data.local.entities.Priority.LOW ->
            MaterialTheme.colorScheme.secondaryContainer to "LOW"
    }

    Text(
        text = text,
        fontSize = 12.sp,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onSurface,
        modifier = Modifier
            .background(bg, shape = MaterialTheme.shapes.small)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    )
}
