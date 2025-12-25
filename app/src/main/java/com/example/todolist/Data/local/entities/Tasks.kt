package com.example.todolist.Data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Task")
data class Task (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,

    val name : String,
    val date: String,
    val priority: Priority,
    var status:Boolean = false) {

}

/*val Tasks = mutableListOf<Task>(
    Task("Grocery Shopping", "15.12.25", "Medium", true),
    Task("Project Deadline", "18.12.25", "High", false),
    Task("Dinner with Friends", "20.12.25", "Low", true),
    Task("Gym Session", "16.12.25", "Medium", true),
    Task("Meeting with Client", "19.12.25", "High", false),
    Task("Buy Gift", "25.12.25", "Low", true),
    Task("Team Lunch", "22.12.25", "Medium", true),
    Task("Finish Report", "30.12.25", "High", false),
    Task("Movie Night", "23.12.25", "Low", true),
    Task("Yoga Class", "17.12.25", "Medium", true),
    Task("Call Mom", "14.12.25", "Low", true),
    Task("Buy Tickets", "26.12.25", "Medium", false),
    Task("Party Prep", "31.12.25", "High", true),
    Task("Breakfast Meeting", "21.12.25", "Medium", false),
    Task("Giving Presentation", "24.12.25", "High", true),
    Task("Pick up Laundry", "13.12.25", "Low", true),
    Task("Doctor's Appointment", "27.12.25", "Medium", false),
    Task("Study Session", "28.12.25", "High", true),
    Task("Travel Prep", "29.12.25", "Medium", true),
    Task("Dentist Visit", "11.12.25", "Low", false)
    )*/