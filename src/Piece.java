public interface Piece {
	/**
	 * @return Returns piece name as a full string
	 */
	public String getType();
	/**
	 * @return Returns piece symbol as one letter
	 */
	public String getSymbol();
	/**
	 * @return Returns piece owner as 1 or 2
	 */
	public int getOwner();
	/**
	 * @param from Square to move from
	 * @param to Square to move to
	 * @return Returns true if move is valid
	 */
	public boolean canMove(Square from, Square to, Board b);
	/**
	 * @param owner Player 1 or 2
	 */
	public void setOwner(int owner);
	/**
	 * Promotes piece
	 */
	public void promote();
}
