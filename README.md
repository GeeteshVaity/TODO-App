# ToDo List App 📝

A modern, feature-rich Android ToDo application built with **Kotlin** and **Jetpack Compose**. This app follows the **MVVM architecture** and uses **Room Database** for local data persistence, allowing users to efficiently manage their daily tasks with priorities, sorting, and due dates.

## 📱 Features

* **Task Management**:
    * **Create**: Add new tasks with a title, due date, and priority level.
    * **Edit**: Update existing task details easily.
    * **Delete**: Remove unwanted tasks.
    * **Complete**: Mark tasks as done/pending with a simple checkbox.
* **Prioritization**: Assign priorities (Low, Medium, High) to tasks with visual color coding.
* **Sorting & Filtering**:
    * Sort by Name, Date, or Priority.
    * Filter by Completed or Pending status.
* **Modern UI**: Built completely with Jetpack Compose using Material Design 3 (Material3) components.
* **Offline Support**: All data is stored locally on the device using Room.

## 🛠 Tech Stack

* **Language**: [Kotlin](https://kotlinlang.org/)
* **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material3)
* **Architecture**: MVVM (Model-View-ViewModel)
* **Dependency Injection**: [Dagger Hilt](https://dagger.dev/hilt/)
* **Local Database**: [Room](https://developer.android.com/training/data-storage/room)
* **Navigation**: [Compose Navigation](https://developer.android.com/guide/navigation/navigation-compose)
* **Asynchronous Programming**: [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) & [Flow](https://kotlinlang.org/docs/flow.html)

## 📂 Project Structure

The project is structured around the **Clean Architecture** principles:

```text
com.example.todolist
├── Components          # Reusable UI components (TaskCard, PriorityChip, etc.)
├── Data
│   └── local           # Room Database setup
│       ├── dao         # Data Access Objects (TaskDAO)
│       ├── entities    # Database Tables (Task, Priority, Sorting)
│       └── repository  # Single source of truth for data (TaskRepository)
├── Navigation          # Navigation graph (AppNavHost)
├── Screens             # Composable screens (MainScreen, AddTask, EditTask)
├── ui
│   ├── theme           # App theme, colors, and typography
│   └── ViewModel       # State management (TaskViewModel)
├── AppModule.kt        # Hilt Dependency Injection module
└── MainActivity.kt     # Application entry point

```

## 🚀 Getting Started

### Prerequisites

* Android Studio (latest stable version recommended)
* JDK 17 or higher

### Installation

1. **Clone the repository:**
```bash
git clone [https://github.com/geeteshvaity/todo-app.git](https://github.com/geeteshvaity/todo-app.git)

```


2. **Open in Android Studio:**
* Open Android Studio -> File -> Open -> Select the cloned project folder.


3. **Sync Project:**
* Let Gradle sync the dependencies (Internet connection required).


4. **Run the App:**
* Connect an Android device or start an Emulator.
* Click the **Run** button (green play icon) or press `Shift + F10`.



## 📸 Screenshots

| Task List | Add Task | Empty Task Screen | Sort Options |
| :---: | :---: | :---: | :---: |
| ![Task List](https://github.com/user-attachments/assets/98e0f302-e23f-4366-a198-77905536f467) | ![Add Task](https://github.com/user-attachments/assets/00440b1d-05df-4af9-81f2-a8b1d6dce00a) | ![Empty Screen](https://github.com/user-attachments/assets/61cfbd56-6c14-43c1-a418-575ffb6033bb) | ![Sort Options](https://github.com/user-attachments/assets/b7aa8a7f-3b9b-4e96-95e5-1c57b0124e1f) |

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](https://www.google.com/search?q=LICENSE) file for details.

```
