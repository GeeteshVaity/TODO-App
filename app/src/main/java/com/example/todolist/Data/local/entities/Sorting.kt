package com.example.todolist.Data.local.entities

import com.example.todolist.Data.local.entities.Sorting

class Sorting(val label: String)

val sortTypes = listOf(
    Sorting("Default"),
    Sorting("Name"),
    Sorting("Date"),
    Sorting("Priority"),
    Sorting("Completed"),
    Sorting("Pending"),
)



