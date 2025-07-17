## Android Notes App Using Clean Architeture, MVVM, Room Local Database, Dagger Hilt Dependency Injection
This is a sample Notes application built using Kotlin and following the principles of Clean Architecture.

## Project Structure

The project is divided into three main layers:

*   **Data Layer**: Responsible for providing data to the application. It includes implementations of repositories, data sources (local and remote), and data mapping logic.
*   **Domain Layer**: Contains the core business logic of the application. It defines use cases and repository interfaces.
*   **Presentation Layer**: The UI layer of the application. It uses ViewModels to interact with the domain layer and display data to the user.

## Building the Project

To build the project, you can use the following Gradle command:

```bash
./gradlew build
```

## Technologies Used

*   **Kotlin**: The primary programming language.
*   **Jetpack Compose**: For building the UI.
*   **Dagger-Hilt**: For dependency injection.
*   **Room**: For local database storage.
*   **Coroutines**: For asynchronous programming.
