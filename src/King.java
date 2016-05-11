
public class King extends Piece {

	public King(int owner) {
		super(owner);
		setSymbol("K");
		setType("King");
	}
	
	public boolean canMove(Square from, Square to, Board b) {
		if(to.getPiece() != null) {
			if(from.getPiece().getOwner() == to.getPiece().getOwner()) {
				return false;
			}
		}
		
		if((Math.abs(from.getC() - to.getC()) <= 1) &&
				Math.abs(from.getR() - to.getR()) <= 1) {	
				return true;
		}
		return false;
	}
	
	public void promote() {
		//This piece does not promote
	}
	public void demote() {
		//This piece does not demote
	}
}
