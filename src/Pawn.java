
public class Pawn implements Piece {
	private String type = "Pawn";
	private String symbol = "P";
	private int owner;
	
	public Pawn() {
		
	}
	
	public boolean canMove(Square from, Square to) {
		//Pawn Basic Move
		if(owner == 1 && from.getR() - to.getR() == -1 ||
				owner == 2 && from.getR() - to.getR() == 1) {
						return true;
		}
		return false;
	}
	
	public Pawn(int owner) {
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
