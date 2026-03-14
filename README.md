# Java Arkanoid Game 🎮

A breakout-style arcade game developed in **Java** using **Object-Oriented Programming (OOP)** principles.

The game is inspired by the classic **Arkanoid / Breakout** arcade game where the player controls a paddle to bounce a ball and destroy blocks across multiple levels.

---

# Gameplay

*(GIF of the gameplay will be added here)*

---

# Features

- Multiple playable levels
- Paddle controlled by keyboard input
- Ball physics and collision detection
- Block destruction mechanics
- Score tracking system
- Pause functionality
- Win and Game Over screens
- Modular object-oriented design

---

# Controls

| Key | Action |
|----|----|
| ← | Move paddle left |
| → | Move paddle right |
| P | Pause the game |
| Space | Continue after pause |

---

# Technologies

- Java
- Object-Oriented Programming (OOP)
- Game animation loop
- Collision detection system

---

# Project Structure
src/

Animation.java
AnimationRunner.java

Ball.java
Velocity.java

Block.java
BlockRemover.java
BallRemover.java

GameFlow.java
GameLevel.java

Level1.java
Level2.java
Level3.java
Level4.java

Paddle.java

ScoreIndicator.java
ScoreTrackingListener.java

HitListener.java
HitNotifier.java

Counter.java

Point.java
Rectangle.java
Line.java

PauseScreen.java
GameOverScreen.java
YouWinScreen.java

Main.java

---

# Game Architecture

The project is built using a modular **object-oriented architecture**:

- **Sprite system** – responsible for objects that appear in the game
- **Collidable system** – handles collision detection
- **Animation framework** – manages game loops and screen transitions
- **Listeners** – used for game events such as score updates and block removal

This design allows the game to be easily extended with additional levels or mechanics.

---

# How to Run

1. Clone the repository
git clone https://github.com/arielswissa95/java-arkanoid-game.git

2. Open the project in an IDE such as **IntelliJ IDEA**

3. Run:
Main.java


---

# Future Improvements

- Add sound effects
- Add graphical improvements
- Add more levels
- Improve UI screens
- Add high score system

---

# Author

**Ariel Swissa**

Software and Computer Engineering Student 
GitHub:  
https://github.com/arielswissa95
