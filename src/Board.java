import javax.swing.JOptionPane;

public class Board {
	private Square[][] board = new Square[9][9];

	//Array which holds the Player hands (Starts at index 1)s
	private Hand[] playerHands = { null, new Hand(1), new Hand(2) };

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
		//Added Bishops to initial setup
		board[1][7].setPiece(new Bishop(1));
		board[7][1].setPiece(new Bishop(2));
	}

	public void movePiece(Square from, Square to, int turn) throws Exception {
		Piece fromPiece = from.getPiece();
		if(fromPiece.getOwner() == turn) {
			if(fromPiece.canMove(from, to, this)) {
				//If piece is appropriate team and moving to or from promotion square
				try {
					if(to.getR() <= 2 && from.getPiece().getOwner() == 2 || 
							to.getR() <= 2 && from.getPiece().getOwner() == 2) {
						from.getPiece().promote();
					}

					if((to.getR() >= 6 && from.getPiece().getOwner() == 1) || 
							to.getR() >= 6 && from.getPiece().getOwner() == 1) {
						from.getPiece().promote();
					}

				} catch(Exception e) {
					//Throws null pointer if no piece on to
				}

				if(to.getPiece() != null) {
					if(to.getPiece().getType().equals("King")) {
						JOptionPane.showMessageDialog(null, "Player " + from.getPiece().getOwner() + " wins!",
								"Game Over", JOptionPane.INFORMATION_MESSAGE);
						System.exit(0);
					}
					//Is capturing opponent's piece
					if(from.getPiece().getOwner() != to.getPiece().getOwner()) {
						playerHands[from.getPiece().getOwner()].addPiece(to.getPiece());
					}	
				}

				from.setPiece(null);
				to.setPiece(null);
				to.setPiece(fromPiece);
			} 
			else if(from.getC() == 100 && from.getR() == 100){
				if(to.getPiece() == null) {
					//If drop row has no pawns
					if(from.getPiece().getSymbol().equals("P")) {
						for(int i = 0;i<9;i++) {
							if(board[i][to.getC()].getPiece() != null) {
								if(board[i][to.getC()].getPiece().getType().equals("Pawn")) {
									Piece p = from.getPiece();
									int x = p.getOwner();
									if(fromPiece.getOwner() == 1) {
										p.setOwner(2);
									} else {
										p.setOwner(1);
									}
									System.out.println(p.getOwner());
									playerHands[x].addPiece(p);
									throw new Exception();
								}
							}
						}
					}
					//Is a Drop to an open square
					fromPiece.demote();
					from.setPiece(null);
					to.setPiece(null);
					to.setPiece(fromPiece);
				} else {
					Piece p = from.getPiece();
					int x = p.getOwner();
					if(fromPiece.getOwner() == 1) {
						p.setOwner(2);
					} else {
						p.setOwner(1);
					}
					playerHands[x].addPiece(p);
					throw new Exception();
				}
			} 
			else {
				throw new Exception();
			}
		} else {
			throw new Exception();
		}
	}

	public Square getSquare(int r, int c) {
		return board[r][c];
	}

	public Hand getHand(int i) {
		return playerHands[i];
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