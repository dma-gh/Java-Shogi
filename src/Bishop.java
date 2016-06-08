
public class Bishop extends Piece {
	
	public Bishop(int owner) {
		super(owner);
		setSymbol("B");
		setType("Bishop");
	}

	public boolean canMove(Square from, Square to, Board b) {
		
		if(promoted) {
			if((Math.abs(from.getC() - to.getC()) <= 1) &&
					Math.abs(from.getR() - to.getR()) <= 1) {	
				return true;
			}
		}
		
		if(Math.abs(from.getR() - to.getR()) == Math.abs(from.getC() - to.getC())) {
			//Check if moving left or right, up or down
			int dirC = to.getC() > from.getC() ? 1 : -1;
			int dirR = to.getR() > from.getR() ? 1 : -1;
			for (int i=1;i<Math.abs(to.getC()-from.getC());i++) {
				if (b.getSquare(from.getR()+i*dirR,from.getC()+i*dirC).getPiece() != null) {
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
}

