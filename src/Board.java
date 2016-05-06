public class Board {
	private Piece[][] board = new Piece[9][9];
	
	public Board() {
		//Add Pawns
		for(int i = 0; i < 9;i++) {
			board[2][i] = new Pawn();
			board[6][i] = new Pawn();
		}
	}
	
	public void movePiece(Piece p) {
		
	}
	
	public String toString() {
		String ret = "";
		for(int r=0;r<board.length;r++) {
			for(int c=0;c<board[r].length;c++) {
				if(board[r][c] == null) {
					ret += " + ";
				} 
				else {
					ret += " " + board[r][c].getSymbol() + " ";
				}
			}
			ret += "\n";
		}
		return ret;
	}
}