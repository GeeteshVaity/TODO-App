package com.example.todolist.Components

import android.R.attr.label
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.Data.local.entities.Sorting
import com.example.todolist.Data.local.entities.sortTypes

@Composable
fun SortingChip(
    sortBy: com.example.todolist.Data.local.entities.Sorting,
    selected: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .clip(androidx.compose.foundation.shape.CircleShape)
            .background(
                if (selected)
                    MaterialTheme.colorScheme.inversePrimary
                else
                    MaterialTheme.colorScheme.secondaryContainer
            )
            .clickable { onClick() } // 🔑 CLICK LIVES HERE
            .padding(horizontal = 14.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = sortBy.label,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = if (selected)
                MaterialTheme.colorScheme.onPrimaryContainer
            else
                MaterialTheme.colorScheme.onSurface
        )
    }
}
