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
		//Add Gold to initial setup
			board[0][3].setPiece(new Gold(1));
			board[0][5].setPiece(new Gold(1));
			board[8][3].setPiece(new Gold(2));
			board[8][5].setPiece(new Gold(2));
		//Add Silvers to initial setup
			board[0][2].setPiece(new Silver(1));
			board[0][6].setPiece(new Silver(1));
			board[8][2].setPiece(new Silver(2));
			board[8][6].setPiece(new Silver(2));
		//Add Knights to initial setup
			board[0][1].setPiece(new Knight(1));
			board[0][7].setPiece(new Knight(1));
			board[8][1].setPiece(new Knight(2));
			board[8][7].setPiece(new Knight(2));
		//Add Rooks to initial setup
			board[1][1].setPiece(new Rook(1));
			board[7][7].setPiece(new Rook(2));
	}
	
	public void movePiece(Square from, Square to) throws Exception {
		Piece fromPiece = from.getPiece();
		if(fromPiece.canMove(from, to, this)) {
				from.setPiece(null);
				to.setPiece(null);
				to.setPiece(fromPiece);
		} else {
			throw new Exception();
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