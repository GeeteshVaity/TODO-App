package com.example.todolist.Data.local.dao

import kotlinx.coroutines.flow.Flow

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.todolist.Data.local.entities.Task

@Dao
interface TaskDAO {

    @Query("SELECT * FROM task")
    fun getAllTask(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY name ASC")
    fun sortByName(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY date ASC")
    fun sortByDate(): Flow<List<Task>>

    @Query("SELECT * FROM task ORDER BY priority ASC")
    fun sortByPriority(): Flow<List<Task>>

    @Query("SELECT * FROM task where status = 1")
    fun completed(): Flow<List<Task>>

    @Query("SELECT * FROM task where status = 0")
    fun incompleted(): Flow<List<Task>>



    @Insert
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("SELECT * FROM task WHERE id = :id")
    fun getTaskById(id: Int): Flow<Task?>



}
