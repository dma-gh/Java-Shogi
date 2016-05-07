public class Square {
	
	private int r;
	private int c;
	private Piece p;
	
	public Square(int r, int c) {
		this.r = r;
		this.c = c;
	}
	
	public int getR() {
		return r;
	}
	
	public int getC() {
		return c;
	}
	
	public Piece getPiece() {
		return p;
	}
	
	public void setPiece(Piece p) {
		this.p = p;
	}
}
