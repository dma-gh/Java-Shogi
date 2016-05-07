
public class Pawn implements Piece {
	private String type = "Pawn";
	private String symbol = "P";
	private int owner;
	
	public Pawn() {
		
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
	
	/**
	 * @param owner Player 1 or 2
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}
	
	public int getOwner() {
		return owner;
	}
}
