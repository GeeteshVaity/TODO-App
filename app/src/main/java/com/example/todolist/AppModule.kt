package com.example.todolist

import android.content.Context
import androidx.room.Room
import com.example.todolist.Data.local.TaskDatabase
import com.example.todolist.Data.local.dao.TaskDAO
import com.example.todolist.Data.local.repository.TaskRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): TaskDatabase =
        Room.databaseBuilder(
            context,
            TaskDatabase::class.java,
            "task_db"
        ).build()

    @Provides
    fun provideDao(db: TaskDatabase): TaskDAO = db.dao()

    @Provides
    fun provideRepository(dao: TaskDAO): TaskRepository =
        TaskRepository(dao)
}

