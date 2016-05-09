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
<li>Board Class contains an array of Squares.</li>
<li>Square class contains a piece and location, drop pieces are on hidden Square 100.</li>
<li>Each Piece has a class which implements the Piece interface</li>
<li>Each Piece class contains a canMove() boolean method, which takes the “from” square, the “to” square and the board as parameters. It then determines whether or not the move is valid.</li>
<li>The board class contains a move method, which uses the canMove method in each piece to determine if the move is valid and make it. <li>If the move cannot be made, it throws an exception.</li> 
<li>The GUI is a JFrame with three JPanels.</li>
<li>The first and third JPanel contain screens which display the held pieces by each player. (Captured Pieces)</li>
<li>The Hand class contains an ArrayList which holds the pieces a player has captured.</li>
<li>In the GUI, each Square is represented by a JButton. The Square’s pieces Symbol represents the Button's text.</li>
<li>The maximum amount of Pieces a player can hold and capture is 38, so each hand JPanel has 38 invisible buttons which become visible, and have their text changed, as Pieces are captured.</li>
<li>Moving is handled through a lastClicked Square variable. Based on the lastClicked variable, when a Square is clicked, its Piece is either highlighted, or the previously clicked Piece is moved.</li>
<li>When a Piece is highlighted, each Square on the Board is checked, if it is a valid move for the Piece, the square is highlighted with a “.”</li>

</ul>

