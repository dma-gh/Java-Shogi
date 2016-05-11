public class Piece {
	
	private String type = "Empty";
	private String symbol = "E";
	protected int owner;
	protected boolean promoted = false;
	
	public Piece(int owner) {
		this.owner = owner;
	}
	
	/**
	 * @return Returns piece name as a full string
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return Returns piece symbol as one letter
	 */
	public String getSymbol() {
		return symbol;
	}
	/**
	 * @return Returns piece owner as 1 or 2
	 */
	public int getOwner() {
		return owner;
	}
	/**
	 * @param from Square to move from
	 * @param to Square to move to
	 * @return Returns true if move is valid
	 * This method is overridden for each piece
	 */
	public boolean canMove(Square from, Square to, Board b) {
		return false;
	}
	/**
	 * @param owner Player 1 or 2
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}
	/**
	 * @param newSymbol The new symbol to set the symbol variable to
	 */
	public void setSymbol(String newSymbol) {
		this.symbol = newSymbol;
	}
	/**
	 * @param newType The new symbol to set the symbol variable to
	 */
	public void setType(String newType) {
		this.type = newType;
	}
	/**
	 * Promotes piece
	 */
	public void promote() {
		promoted = true;
		//If a piece is "double promoted," don't add another "!" mark.
		if(!symbol.substring(symbol.length() -1 ).equals("!")) {
		symbol = symbol += "!";
		}
	}
	/**
	 * Demotes piece
	 */
	public void demote() {
		promoted = false;
		symbol = symbol.substring(0, symbol.length() - 2);
	}
}
