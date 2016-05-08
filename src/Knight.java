
public class Knight implements Piece {
	private String type = "Knight";
	private String symbol = "Kn";
	private int owner;

	public boolean canMove(Square from, Square to, Board b) {
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

