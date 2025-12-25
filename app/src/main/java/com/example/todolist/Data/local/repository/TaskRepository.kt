package com.example.todolist.Data.local.repository

import com.example.todolist.Data.local.dao.TaskDAO
import com.example.todolist.Data.local.entities.Priority
import com.example.todolist.Data.local.entities.Task
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TaskRepository @Inject constructor(
    private val dao: TaskDAO
) {

    // 📋 All tasks
    fun getAllTask(): Flow<List<Task>> {
        return dao.getAllTask()
    }
    fun getTasksSortedByName() = dao.sortByName()
    fun getTasksSortedByDate() = dao.sortByDate()
    fun getTasksSortedByPriority() = dao.sortByPriority()
    fun completed() = dao.completed()
    fun incompleted() = dao.incompleted()



    // ➕ Add task
    suspend fun addTask(
        name: String,
        date: String,
        priority: Priority
    ) {
        dao.insertTask(
            Task(
                name = name,
                date = date,
                priority = priority
            )
        )
    }

    // ✏️ Update task
    suspend fun updateTask(task: Task) {
        dao.updateTask(task)
    }

    // 📥 Get task by id (FLOW — VERY IMPORTANT)
    fun getTaskById(id: Int): Flow<Task?> {
        return dao.getTaskById(id)
    }

    // 🗑 Delete task
    suspend fun deleteTask(task: Task) {
        dao.deleteTask(task)
    }

}
