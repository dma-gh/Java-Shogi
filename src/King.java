
public class King implements Piece {
	private String type = "King";
	private String symbol = "K";
	private int owner;
	
	public boolean canMove(Square from, Square to, Board b) {
		if((Math.abs(from.getC() - to.getC()) >= 1) &&
				Math.abs(from.getR() - to.getR()) >= 1) {	
		return true;
		}
		return false;
	}
	
	public King(int owner) {
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
