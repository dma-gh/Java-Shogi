
public class Lance implements Piece{
	private String type = "Lance";
	private String symbol = "L";
	private int owner;
	
	public boolean canMove(Square from, Square to) {
		if(from.getR() == to.getR()) {
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
