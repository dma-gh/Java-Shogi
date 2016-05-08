#Shogi
AP Computer Science Final Project - Japanese Chess Game - David Allen<br>
A Graphical Shogi (Japanese Chess) Game
##Implementation Details:
<ul>
	<li>Two-Player
	<li>The Game will highlight available moves when a piece is clicked
	<li>Players will use a GUI to control the Pieces
	<li>The Game is over when a player's king is captured
	<li>Players take turns moving their pieces until the game is over</li>
</ul>
##Code Details:
<ul>
	<li>Manages the Board class through a two-dimensional array of squares
	<li>Each Piece has a class which implements the Piece class
	<li>Each Piece has its own valid move checking method, which is used by a movePiece method in the board class
	<li>The GUI iterates through the board after each move and prints symbols
	<li>An ActionListener detects which piece is selected, then where it must move</li>
</ul>

