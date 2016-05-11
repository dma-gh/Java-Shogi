
public class Rook extends Piece {
	
	public Rook(int owner) {
		super(owner);
		setSymbol("R");
		setType("Rook");
	}

	public boolean canMove(Square from, Square to, Board b) {

		if(promoted) {
			if((Math.abs(from.getC() - to.getC()) <= 1) &&
					Math.abs(from.getR() - to.getR()) <= 1) {	
				return true;
			}
		}
		
		if(to.getPiece() != null) {
			if(from.getPiece().getOwner() == to.getPiece().getOwner()) {
				return false;
			}
		}

		if(from.getC() != to.getC() && from.getR() != to.getR()) {
			return false;
		}

		//Rook is moving left
		if(from.getC() - to.getC() > 0) {
			//Loop through squares from from square to to square
			for(int i = from.getC() - 1;i>to.getC();i--) {
				//if square contains piece, return false
				if(b.getSquare(from.getR(), i).getPiece() != null) {
					return false;
				}
			}
		}

		//Rook is moving right
		if(from.getC() - to.getC() < 0) {
			//Loop through squares from from square to to square
			for(int i = from.getC() + 1;i<to.getC();i++) {
				//if square contains piece, return false
				if(b.getSquare(from.getR(), i).getPiece() != null) {
					return false;
				}
			}
		}

		//Rook is moving down
		if(from.getR() - to.getR() < 0) {
			//Loop through squares from from square to to square
			for(int i = from.getR() + 1;i<to.getR();i++) {
				//if square contains piece, return false
				if(b.getSquare(i, from.getC()).getPiece() != null) {
					return false;
				}
			}
		}

		//Rook is moving up
		if(from.getR() - to.getR() > 0) {
			//Loop through squares from from square to to square
			for(int i = from.getR() - 1;i>to.getR();i--) {
				//if square contains piece, return false
				if(b.getSquare(i, from.getC()).getPiece() != null) {
					return false;
				}
			}
		}

		return true;
	}
}
