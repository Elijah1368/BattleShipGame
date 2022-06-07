# BattleShipGame
A fully functional Battleship game made entirely in Java. Play against AI computer in a client interface to see who is the better battleshiper. 

IMPORTANT
To start game: 

1.) Download and extract repository

2.) Open Terminal

3.) Change Directory to project folder

4.) Type java -jar out/artifacts/BattleShipGame_jar/BattleShipGame.jar


![BattleshipPreview](https://raw.githubusercontent.com/Elijah1368/BattleShipGame/master/Assets/battleship.png)

The "-" represents the spaces in the battleship map. The map on top, is the computer's and the map on the bottom is the user's.
The "+" represents the battleships you have. Since the computer's ships are hidden to the user's, it is all "-". The "O" represents all the hits
you made in the computer's map that missed. It will display "X" if you hit a computer's battleship. The "X" in your map represents all the hits the computer made.

![Battleshipplacement](https://raw.githubusercontent.com/Elijah1368/BattleShipGame/master/Assets/BattleshipPlacement.png)
You can have your ship placed automatically or manually before the start of the game. Ships must be one space apart from each other and must be within map bounds.

![BattleshipPreview](https://raw.githubusercontent.com/Elijah1368/BattleShipGame/master/Assets/debug.png)
At the start of the game, you can choose debug mode. Which enables you to change the number of ships, or change the ship types (big ship, medium ship, small ship) used in the game. At the start of the game in debug mode, the computer's battleship placement will be entirely visibile to you.

Project Architecture is based of Model View Controller design. Where model represents the state of the game (No. of Battleships, Records of Hits and Misses, Battleship Placement)
and notifies the view when there is a change in state, the view is in charge of displaying the state of the game to the client interface, 
and controller is in charge of interpreting user input and changing the model (picking a coordinate where "hit" is placed, or which battleship is sunk) based off it.

This keeps the program modular and makes it easier if there's any changes wanted to made to the program. One part will not affect the other.

