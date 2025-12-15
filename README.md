# Slide Puzzle Game

A classic 4x4 slide puzzle game implemented in Java. The goal of the game is to reorder the scrambled tiles to form the original image by sliding tiles into the empty space.

## Features

* **4x4 Grid:** Implements the standard 15-puzzle format.
* **Graphical User Interface (GUI):** Built using Java Swing.
* **Tile Movement:** Allows the user to interactively click tiles to move them into the adjacent empty spot.
* **Randomized Shuffling:** The puzzle is randomly scrambled at the start of the game.
* **Win Condition Check:** Automatically detects when the puzzle has been successfully solved.
* **Visual Tiles:** Uses individual image assets (`tile_x_y.png`) to display the puzzle's picture.

## Getting Started
These instructions will help you set up and run the project on your local machine.

### Prerequisites
You will need the Java Development Kit (JDK) installed on your system to compile and run the application.

### Installation and Execution
1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/248JO/slide-puzzle.git](https://github.com/248JO/slide-puzzle.git)
    cd slide-puzzle
    ```

2.  **Compile the Java files:**
    Assuming all `.java` files and `.png` assets are in the root directory:
    ```bash
    javac *.java
    ```

3.  **Run the application:**
    The main class that starts the game is `SlidePuzzleProgram.java`.
    ```bash
    java SlidePuzzleProgram
    ```

## Project Structure

The repository contains the following key files:

| File Name | Description |
| :--- | :--- |
| `SlidePuzzleProgram.java` | The main class containing the `main` method for the application. |
| `SlidePuzzleFrame.java` | Manages the main game window, GUI layout, and core game logic (e.g., shuffling, checking for a win). |
| `TileButton.java` | A custom button component used to represent each interactive tile in the puzzle. |
| `SlidePuzzleFrameTest.java` | Unit tests for the main game frame and logic. |
| `TileButtonTest.java` | Unit tests for the custom tile button component. |
| `tile_x_y.png` | Image assets that are displayed on the puzzle tiles. |

## Built With

* **Java**
* **Java Swing/AWT** - For the graphical user interface.
