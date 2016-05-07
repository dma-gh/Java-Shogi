public class Shogi {
	
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b.toString());
		b.movePiece(b.getSquare(2, 0), b.getSquare(3, 0));
		System.out.println(b.toString());
		b.movePiece(b.getSquare(6, 0), b.getSquare(5, 0));
		System.out.println(b.toString());
	}
}