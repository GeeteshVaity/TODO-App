package com.example.todolist.ui.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolist.Data.local.entities.Priority
import com.example.todolist.Data.local.entities.Task
import com.example.todolist.Data.local.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class TaskViewModel @Inject constructor(
    private val repository: TaskRepository
) : ViewModel() {

    // 📋 All tasks (list screen)
    val tasks = repository.getAllTask()

    // ✏️ Selected task (edit screen)
    private val _selectedTask = MutableStateFlow<Task?>(null)
    val selectedTask: StateFlow<Task?> = _selectedTask.asStateFlow()

    // ➕ Add task
    fun addTask(
        name: String,
        date: String,
        priority: Priority
    ) {
        viewModelScope.launch {
            repository.addTask(name, date, priority)
        }
    }

    // ✏️ Update task
    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    // 📥 Load task by id
    fun loadTask(id: Int) {
        viewModelScope.launch {
            repository.getTaskById(id)
                .collectLatest { task ->
                    _selectedTask.value = task
                }
        }
    }

    // 🗑 Delete task
    fun deleteTask(task: Task) {
        viewModelScope.launch {
            repository.deleteTask(task)
        }
    }
}
