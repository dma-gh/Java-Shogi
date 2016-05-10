
public class Knight implements Piece {
	private String type = "Knight";
	private String symbol = "Kn";
	private int owner;
	private boolean promoted = false;

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
			
			if(owner == 2) {
				//Check if moving up two squares
				if(from.getR() - to.getR() != 2 || Math.abs(from.getC() - to.getC()) != 1) {
					return false;
				}
			}
			if(owner == 1) {
				//Check if moving down two squares
				if(from.getR() - to.getR() != -2 || Math.abs(from.getC() - to.getC()) != 1) {
					return false;
				}
			}

			if(to.getPiece() != null) {
				if(from.getPiece().getOwner() == to.getPiece().getOwner()) {
					return false;
				}
			}

			return true;
	}
	
	public void promote() {
		promoted = true;
		symbol = "Kn!";
	}

	public Knight(int owner) {
		this.owner = owner;
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

