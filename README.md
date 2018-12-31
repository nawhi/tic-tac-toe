# Tic Tac Toe Kata

The rules of the tic tac toe game are the following:

* There are two players in the game (X and O)
* A game has nine fields in a 3x3 grid
* Players take turns taking fields until the game is over
* A player can only take a field if it is currently unoccupied

A player wins the game when any of the following are satisfied:
* all fields in a row are taken by that player
* all fields in a diagonal are taken by that player 
* all fields in a column are taken by that player

The game is a draw if:
* all the game's fields are occupied but neither player has won 

## Object Calisthenics Branch
Rules: 
* Only one level of indentation per method
* Don’t use the ELSE keyword
* Wrap all primitives and strings
* First class collections (wrap all collections)
* Only one dot per line:  `dog.body.tail.wag()` => `dog.expressHappiness()`
* No abbreviations
* Keep all entities small (10 files per package, 50 lines per class, 5 lines per method, 2 arguments per method)
* No classes with more than two instance variables
* No public getters/setters/properties