
public class Silver extends Piece {
	
	public Silver(int owner) {
		super(owner);
		setSymbol("S");
		setType("Silver");
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
		if((Math.abs(from.getR() - to.getR()) <= 1 && 
				(Math.abs(from.getC() - to.getC()) <= 1))) {
			if(owner == 1) {
				//If Piece is moving backwards p1
				if(from.getR() - to.getR() == 1) {
					if(from.getC() == to.getC()) {
						return false;
					}
				}
			} else if(owner == 2) {
				//If Piece is moving backwards p2
				if(from.getR() - to.getR() == -1) {
					if(from.getC() == to.getC()) {
						return false;
					}
				}
			}
			
			//moving sideways
			if(from.getR() == to.getR()) {
				return false;
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

