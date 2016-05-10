
public class Lance implements Piece {
	private String type = "Lance";
	private String symbol = "L";
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
		
		if(from.getC() == to.getC()) {
			if(owner == 2) {
				//Check for collision and row violation if moving up 
				if(from.getR() - to.getR() > 0) {
					//Check squares between old and new position for pieces
					for(int i=from.getR() - 1;i>to.getR();i--) {
						if(b.getSquare(i, from.getC()).getPiece() != null) {
							return false;
						}
					}
				} else {
					return false;
				}
			}
			if(owner == 1) {
				//Check for collision and row violation if moving down 	
				if(from.getR() - to.getR() < 0 && from.getC() == to.getC()) {
					//Check squares between old and new position for pieces
					for(int i=from.getR() + 1;i<to.getR();i++) {
						if(b.getSquare(i, from.getC()).getPiece() != null) {
							return false;
						}
					}
				} else {
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
		return false;
	}
	public void promote() {
		promoted = true;
		symbol = "L!";
	}
	
	public void demote() {
		promoted = false;
		symbol = "L";
	}
	
	public Lance(int owner) {
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
