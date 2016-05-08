
public class Gold implements Piece {
	private String type = "Gold";
	private String symbol = "G";
	private int owner;
	
	public boolean canMove(Square from, Square to, Board b) {
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
			if(to.getPiece().getOwner() != from.getPiece().getOwner()) {
				return true;
			}
		}
		return false;
	}
	
	public Gold(int owner) {
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
