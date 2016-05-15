#Shogi
AP Computer Science Final Project - Japanese Chess Game - David Allen<br>
A Graphical Shogi (Japanese Chess) Game
##Implementation Details:
<ul>
<li>There are two Players.</li>
<li>The Board consists of 81 Squares, 9x9.</li>
<li>Each piece has a starting position, and will be placed there upon the start of the game.</li>
<li>Player 1 moves first.</li>
<li>Each piece has its own individual set of moves, and only the knight may jump over other pieces.</li>
<li>If a piece is selected and it is the player’s turn, the available moves for that piece will be highlighted.</li>
<li>After a Piece is captured, it is added to the hand of the player which captured the piece. The Players’ hands can be seen at the top and bottom of the screen.</li>
<li>The game is over when a player's king is captured, the player who 
captured their opponent's king is the winner.</li>

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

