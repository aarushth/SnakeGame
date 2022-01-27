# SnakeGame
## Introduction
This is project that implements the classic snake game, where the player starts with a small moving snake that they can control to move around and eat pellets. Eating pellets increases the snake's size as well as speed, and when the snake crashes into itself, or the wall, it dies, the game is over and the player is given the option to restart.
## How to run
Note: you must have eclipse or other java IDE's installed to be able to run this game.  
Download all the files into your eclispe-workspace, or wherever you save your projects, then in Eclipse, click create new project and create a new project with the same name as this file "SnakeGame". Then, open the Main class and click run
## Classes
### Main
This doesn't do much, just instantiates the GameEngine class, which is the main control.
### Window
This is an Overriden version of the JFrame class, that allows the GameEngine class to update its contents, and also recieve keypresses from it.
### Board
This class handles all of the logic of the game, figuring out when the snake has to grow, speed up, where the pellet is, and if it crashes.
### GameEngine
This class holds the loop of the game, updating the whole game every 15m. It pulls key inputs from the Window class, and feeds it to the Board class.
### SnakeView
This class just takes the values of the snake from the Board class and renders it on the frame that Window creates.
### PelletView
Similar to SnakeView, this just renders the pellet on the frame that Window creates.
