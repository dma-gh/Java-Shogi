
public class Bishop implements Piece {
	private String type = "Bishop";
	private String symbol = "B";
	private int owner;
	private boolean promoted = false;

	public boolean canMove(Square from, Square to, Board b) {
		
		if(promoted) {
			if((Math.abs(from.getC() - to.getC()) <= 1) &&
					Math.abs(from.getR() - to.getR()) <= 1) {	
				return true;
			}
		}
		
		if(Math.abs(from.getR() - to.getR()) == Math.abs(from.getC() - to.getC())) {
			//Check if moving left or right, up or down
			int dirC = to.getC()>from.getC() ? 1 : -1;
			int dirR = to.getR()>from.getR() ? 1 : -1;
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

	public void promote() {
		promoted = true;
		symbol = "B!";
	}
	
	public void demote() {
		promoted = false;
		symbol = "B";
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

