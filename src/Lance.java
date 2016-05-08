
public class Lance implements Piece {
	private String type = "Lance";
	private String symbol = "L";
	private int owner;
	
	public boolean canMove(Square from, Square to, Board b) {
			//Check for collision and row violation if moving up 
			if(owner == 1 && from.getC() == to.getC()) {
				for(int i=from.getR() + 1;i<to.getR();i++) {
					if(b.getSquare(i, from.getC()).getPiece() != null) {
						return false;
					}
				}
			}
			//Check for collision and row violation if moving down 	
			if(owner == 2 && from.getC() == to.getC()) {
				for(int i=from.getR() - 1;i>to.getR();i--) {
					if(b.getSquare(i, from.getC()).getPiece() != null) {
						return false;
					}
				}
			}
			return true;
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
