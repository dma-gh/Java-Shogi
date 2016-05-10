
public class Pawn implements Piece {
	private String type = "Pawn";
	private String symbol = "P";
	private int owner;
	private boolean promoted = false;

	public Pawn(int owner) {
		this.owner = owner;
	}

	public boolean canMove(Square from, Square to, Board b) {
		if(promoted) {
			//Gold movement code
			if((Math.abs(from.getR() - to.getR()) <= 1 && 
					(Math.abs(from.getC() - to.getC()) <= 1))) {
				if(owner == 1) {
					//If Piece is moving backwards check for diagonal
					if(from.getR() - to.getR() == 1) {
						if(from.getC() != to.getC()) {
							return false;
						}
					}
				} else if(owner == 2) {
					//If Piece is moving backwards check for diagonal
					if(from.getR() - to.getR() == -1) {
						if(from.getC() != to.getC()) {
							return false;
						}
					}
				}
				if(to.getPiece() != null) {
					if(from.getPiece().getOwner() == to.getPiece().getOwner()) {
						return false;
					}
				}
				return true;
			}
			return false;
		}
		
		//Pawn Basic Move
		if(owner == 1 && from.getR() - to.getR() == -1 ||
				owner == 2 && from.getR() - to.getR() == 1) {
			if(from.getC() == to.getC()) {
				if(to.getPiece() != null) {
					if(from.getPiece().getOwner() == to.getPiece().getOwner()) {
						return false;
					}
				}
				return true;
			}
		}

		return false;
	}
	
	public void promote() {
		promoted = true;
		symbol = "P!";
	}

	public String getType() {
		return type;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public int getOwner() {
		return owner;
	}
}
