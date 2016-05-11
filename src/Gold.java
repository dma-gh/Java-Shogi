
public class Gold extends Piece {
	
	public Gold(int owner) {
		super(owner);
		setSymbol("G");
		setType("Gold");
	}
	
	public boolean canMove(Square from, Square to, Board b) {
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
	
	public void promote() {
		//this piece does not promote
	}
	
	public void demote() {
		//does not demote
	}
}
