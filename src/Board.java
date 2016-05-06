public class Board {
	private Piece[][] board = new Piece[8][8];
	
	public Board() {
		//Add Pawns
		for(int i = 0; i < board[i].length;i++) {
			board[i][2] = new Pawn();
			board[i][6] = new Pawn();
		}
	}
	
	public void movePiece(Piece p) {
		
	}
}