public class Board {
	private Square[][] board = new Square[9][9];
	
	public Board() {
		//Add Squares
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[r].length;c++) {
				board[r][c] = new Square(r,c);
			}
		}
		//Add Pawns to initial setup
		for(int i = 0; i < 9;i++) {
			board[2][i].setPiece(new Pawn(1));
			board[6][i].setPiece(new Pawn(2));
		}
		//Add Lances to initial setup
			board[0][0].setPiece(new Lance(1));
			board[0][8].setPiece(new Lance(1));
			board[8][0].setPiece(new Lance(2));
			board[8][8].setPiece(new Lance(2));
		//Add Kings to initial setup
			board[0][4].setPiece(new King(1));
			board[8][4].setPiece(new King(2));
	}
	
	public void movePiece(Square from, Square to) {
		Piece fromPiece = from.getPiece();
		if(fromPiece.canMove(from, to, this)) {
			if(to.getPiece() == null) {
				from.setPiece(null);
				to.setPiece(null);
				to.setPiece(fromPiece);
			}
		}
	}
	
	public Square getSquare(int r, int c) {
		return board[r][c];
	}
	
	public String toString() {
		String ret = "";
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[r].length;c++) {
				if(board[r][c].getPiece() == null) {
					ret += " + ";
				} 
				else {
					ret += " " + board[r][c].getPiece().getSymbol() + " ";
				}
			}
			ret += "\n";
		}
		return ret;
	}
}