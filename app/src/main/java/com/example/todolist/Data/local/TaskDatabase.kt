package com.example.todolist.Data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todolist.Data.local.dao.TaskDAO
import com.example.todolist.Data.local.entities.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun dao() : TaskDAO
}

