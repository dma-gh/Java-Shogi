
public class Rook implements Piece {
	private String type = "Rook";
	private String symbol = "R";
	private int owner;
	
	public boolean canMove(Square from, Square to, Board b) {
		//Check for collision and row violation if moving up 
		if(from.getR() - to.getR() < 0 && from.getC() == to.getC()) {
			//Check squares between old and new position for pieces
			for(int i=from.getR() + 1;i<to.getR();i++) {
				if(b.getSquare(i, from.getC()).getPiece() != null) {
					return false;
				}
			}
		}
		//Check for collision and row violation if moving down 	
		if(from.getR() - to.getR() > 0 && from.getC() == to.getC()) {
			//Check squares between old and new position for pieces
			for(int i=from.getR() - 1;i>to.getR();i--) {
				if(b.getSquare(i, from.getC()).getPiece() != null) {
					return false;
				}
			}
		}
		
		//Check for collision and row violation if moving left
		if(from.getC() - to.getC() < 0 && from.getR() == to.getR()) {
			//Check squares between old and new position for pieces
			for(int i=from.getC() - 1;i>to.getC();i--) {
				if(b.getSquare(i, from.getC()).getPiece() != null) {
					return false;
				}
			}
		}
		
		//Check for collision and row violation if moving right
		if(from.getC() - to.getC() > 0 && from.getR() == to.getR()) {
			//Check squares between old and new position for pieces
			for(int i=from.getC() + 1;i<to.getC();i++) {
				if(b.getSquare(i, from.getC()).getPiece() != null) {
					return false;
				}
			}
		}
		if(to.getPiece().getOwner() != from.getPiece().getOwner()) {
			return true;
		}
		return false;
	}
	
	public Rook(int owner) {
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
