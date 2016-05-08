public class Shogi {
	
	public static void main(String[] args) {
		Board b = new Board();
		System.out.println(b.toString());
		b.movePiece(b.getSquare(8, 5), b.getSquare(7, 5));
		System.out.println(b.toString());
	}
}