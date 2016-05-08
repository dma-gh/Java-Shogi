
public class Lance implements Piece {
	private String type = "Lance";
	private String symbol = "L";
	private int owner;
	
	public boolean canMove(Square from, Square to, Board b) {
		if(from.getC() == to.getC()) {
			if(owner == 2) {
				//Check for collision and row violation if moving up 
				if(from.getR() - to.getR() < 0) {
					//Check squares between old and new position for pieces
					for(int i=from.getR() + 1;i<to.getR();i++) {
						if(b.getSquare(i, from.getC()).getPiece() != null) {
							return false;
						}
					}
				}
			}
			else if(owner == 1) {
				//Check for collision and row violation if moving down 	
				if(from.getR() - to.getR() > 0 && from.getC() == to.getC()) {
					//Check squares between old and new position for pieces
					for(int i=from.getR() - 1;i>to.getR();i--) {
						if(b.getSquare(i, from.getC()).getPiece() != null) {
							return false;
						}
					}
				}
			}
			return true;
		}
		return false;
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
