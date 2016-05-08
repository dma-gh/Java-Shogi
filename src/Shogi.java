public class Shogi {
	
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b.toString());
		b.movePiece(b.getSquare(8, 4), b.getSquare(7, 6));
		System.out.println(b.toString());
		b.movePiece(b.getSquare(6, 0), b.getSquare(5, 0));
		System.out.println(b.toString());
		b.movePiece(b.getSquare(8, 0), b.getSquare(6, 0));
		System.out.println(b.toString());
	}
}