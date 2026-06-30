# Hangman Game

An interactive **Java Swing-based Hangman game** demonstrating GUI development and game logic implementation.

## Features

✅ Interactive graphical user interface

✅ Real-time game state visualization

✅ Dynamic word selection

✅ Guess tracking with feedback

✅ Health/attempt counter

✅ Win/lose detection

✅ Replay functionality

## Technologies

- Java
- Swing GUI Framework
- Event Handling
- Graphics & Custom Rendering

## Quick Start

```bash
javac -d bin src/hangman/*.java
java -cp bin hangman.Run
```

## Project Structure

src/hangman/
├── Run.java           # Entry point

├── MainWindow.java    # Main game window

├── WordPanel.java     # Word display

├── HealthPanel.java   # Health counter

├── ButtonPanel.java   # Letter buttons

└── GameLogic.java     # Game mechanics

## How to Play

1. System selects a random word

2. Guess letters one at a time
   
3. Correct guesses reveal letter positions
   
4. Wrong guesses decrease health
   
5. Win when all letters revealed
    
6. Lose when health reaches 0

## Skills Demonstrated

- Java Swing GUI development
- Event-driven programming
- Component architecture
- User interface design
