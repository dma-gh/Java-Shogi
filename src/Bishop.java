
public class Bishop implements Piece {
	private String type = "Bishop";
	private String symbol = "B";
	private int owner;

	public boolean canMove(Square from, Square to, Board b) {

		if(Math.abs(from.getR() - to.getR()) == Math.abs(from.getC() - to.getC())) {

			//Bishop is moving left and up
			if(from.getC() - to.getC() > 0) {
				//Loop through squares above and to the left
				for(int r = from.getR() + 1;r<to.getR()-1;r++) {
					for(int c = from.getC() - 1;c>to.getC();c--) {
						//if square contains piece, return false
						if(b.getSquare(r, c).getPiece() != null) {
							return false;
						}
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

	public Bishop(int owner) {
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

