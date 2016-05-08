
public class Silver implements Piece {
	private String type = "Silver";
	private String symbol = "S";
	private int owner;

	public boolean canMove(Square from, Square to, Board b) {
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

	public Silver(int owner) {
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

