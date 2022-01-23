# BattleShipGame
A fully functional Battleship game made entirely in Java. Play against AI computer in a client interface to see who is the better battleshiper. 

Project Architecture is based of Model View Controller design. Where model represents the state of the game (No. of Battleships, Records of Hits and Misses, Battleship Placement)
and notifies the view when there is a change in state, the view is in charge of displaying the state of the game to the client interface, 
and controller is in charge of interpreting user input and changing the model (picking a coordinate where "hit" is placed, or which battleship is sunk) based off it.

This keeps the program modular and makes it easier if there's any changes wanted to made to the program. One part will not affect the other.

