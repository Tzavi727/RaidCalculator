# Rust Raid Calculator (Console Version)

A simple, yet robust, console-based calculator written in Java to help Rust players calculate the material costs for raiding structures and crafting explosives.

---

## Features

This project was developed as a personal study of Java and Object-Oriented Programming concepts. It includes the following features:

*   **Raid Cost Calculation:**
    *   Calculates the exact amount of explosives (Satchels, C4, Rockets) needed to destroy different types of doors (Wooden, Sheet Metal, Armored).
*   **Crafting Cost Calculation:**
    *   Calculates the total amount of Sulfur and Charcoal required to craft a specific quantity of any explosive item.
*   **User-Friendly Console Interface:**
    *   A menu-driven interface that guides the user through the options.
    *   Robust input validation to prevent crashes from invalid user entries.
*   **Object-Oriented Design:**
    *   Code is structured into logical classes (`Doors`, `ExplosiveValues`, `Calc`) to demonstrate good software architecture principles.

---

## Technologies Used

*   **Language:** Java
*   **Development Environment:** Visual Studio Code
*   **Key Java Concepts Applied:**
    *   Object-Oriented Programming (Classes, Objects, Enums)
    *   Control Flow (while loops, switch statements)
    *   Exception Handling (try-catch)
    *   Console I/O (Scanner)

---

## How to Run

1.  **Prerequisites:** You need to have the Java Development Kit (JDK) installed on your machine.
2.  **Clone the repository:**
    ```bash
    git clone https://github.com/Tzavi727/Console-Raid-Calculator-Java.git
    ```
3.  **Navigate to the source folder and compile:**
    ```bash
    cd SeuRepositorio/src
    javac *.java
    ```
4.  **Run the application:**
    ```bash
    java RustRaidCalculator 
    ```
*(Note: Running directly from an IDE like VS Code or IntelliJ is the recommended way.)*