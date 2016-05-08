import java.util.ArrayList;

public class Hand {

	private ArrayList<Piece> pieces = new ArrayList<>();
	private int owner;
	
	public Hand(int owner) {
		this.owner = owner;
	}
	
	public Piece getPiece(int i) {
		return pieces.get(i);
	}
	
	public void addPiece(Piece p) {
		pieces.add(p);
	}
	
	public int getOwner() {
		return owner;
	}
}
