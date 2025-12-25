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

| Task List | Add Task | Sorting Options |
| --- | --- | --- |
| *(Add screenshot here)* | *(Add screenshot here)* | *(Add screenshot here)* |

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

### **How to use this file:**
1.  Create a file named `README.md` in the root directory of your project (where `build.gradle.kts` and `settings.gradle.kts` are located).
2.  Paste the content above into that file.
3.  (Optional) Take screenshots of your running app and replace the `*(Add screenshot here)*` placeholders with actual image paths if you host them on GitHub.

```
