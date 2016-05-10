import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Shogi extends JFrame {

	private static final long serialVersionUID = 6349187091886546866L; //Serial UID
	static JPanel boardGUI = new JPanel(new GridLayout(9,9));
	static JPanel p1Hand = new JPanel();
	static JPanel p2Hand = new JPanel();
	static JFrame frame = new JFrame();
	static JButton[][] squares = new JButton[9][9];
	static Board b = new Board();
	static Square lastClicked = null;
	public static int turn = 2;
	public static Hand p1 = new Hand(1);
	public static Hand p2 = new Hand(2);
	public static JButton[] p1List = new JButton[38];
	public static JButton[] p2List = new JButton[38];
	static Piece tmp;

	public static void main(String[] args){
		frame.setLayout(new BorderLayout());
		frame.setSize(486,600);
		frame.setTitle("Shogi");
		frame.add(boardGUI,BorderLayout.CENTER);
		frame.add(p1Hand,BorderLayout.PAGE_START);
		frame.add(p2Hand,BorderLayout.PAGE_END);
		boardGUI.setSize(486, 486);
		p1Hand.setSize(486, 57);
		p2Hand.setSize(486,57);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add squares to hands
		for(int i=0;i<38;i++) {
			p1List[i] = new JButton("");
			p2List[i] = new JButton("");

			p1List[i].setOpaque(true);
			p1List[i].setSize(54, 54);
			//Hide line border but preserve square shape
			p1List[i].setBorder(new LineBorder(Color.WHITE));
			p1List[i].setBackground(Color.WHITE);

			p1List[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<38;i++) {
						if(e.getSource() == p1List[i]) {
							Square s = new Square(100,100);
							Piece t = p1.getPiece(i);
							t.setOwner(p1.getOwner());
							s.setPiece(t);
							lastClicked = s;
							p1List[i].setText("");
							p1List[i].setVisible(false);
							p1.setPiece(i, null);
						}
					}
				}
			});
			p2List[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<38;i++) {
						if(e.getSource() == p2List[i]) {
							Square s = new Square(100,100);
							Piece t = p2.getPiece(i);
							t.setOwner(p2.getOwner());
							s.setPiece(t);
							lastClicked = s;
							p2List[i].setText("");
							p2List[i].setVisible(false);
							p2.setPiece(i, null);
						}
					}
				}
			});

			p2List[i].setOpaque(true);
			p2List[i].setSize(54, 54);
			//Hide line border but preserve square shape
			p2List[i].setBorder(new LineBorder(Color.WHITE));
			p2List[i].setBackground(Color.WHITE);

			p1List[i].setVisible(false);
			p2List[i].setVisible(false);

			p1Hand.add(p1List[i]);
			p2Hand.add(p2List[i]);

		}

		//Add Squares to board layout
		for(int r=0;r<9;r++) {
			for(int c=0;c<9;c++) {
				squares[r][c] = new JButton();
				squares[r][c].setOpaque(true);
				squares[r][c].setSize(54, 54);
				squares[r][c].setBorder(new LineBorder(Color.BLACK));
				squares[r][c].setBackground(Color.decode("#db9356"));
				squares[r][c].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int r=0;r<9;r++) {
							for(int c=0;c<9;c++) {
								if(e.getSource() == squares[r][c]) {
									if(lastClicked == null && b.getSquare(r, c).getPiece().getOwner() == turn) {
										if(b.getSquare(r, c).getPiece() != null) {
											lastClicked = b.getSquare(r, c);
											tmp = null;
											for(int i=0;i<9;i++) {
												for(int j=0;j<9;j++) {
													if(b.getSquare(r, c).getPiece().canMove(b.getSquare(r, c), b.getSquare(i, j), b)) {
														squares[i][j].setText(squares[i][j].getText() + ".");
													}
												}
											}
										}
									} else {
										try {
											if(b.getSquare(r, c).getPiece() != null) {
												tmp = b.getSquare(r, c).getPiece();
											}
											b.movePiece(lastClicked, b.getSquare(r, c));
											//Check for drop
											if(lastClicked.getC() == 100 && lastClicked.getR() == 100) {
												if(turn == 1) {

												} else {

												}
											} 
											squares[r][c].setForeground(Color.BLACK);
											lastClicked = null;
											if(turn == 2) {
												turn = 1;
												if(tmp != null) {
													p2.addPiece(tmp);
												}
											} else if(turn == 1) {
												turn = 2;
												if(tmp != null) {
													p1.addPiece(tmp);
												}
											}
											updateBoard();
											tmp = null;
										} catch (Exception ex) {
											ex.printStackTrace(System.out);
											System.out.println("Invalid Move");
											lastClicked = null;
											updateBoard();
										}
									}
								}
							}
						}
					}
				});
				boardGUI.add(squares[r][c]);
			}
		}

		updateBoard();
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
	}

	public static void updateBoard() {
		for(int r=0;r<9;r++) {
			for(int c=0;c<9;c++) {
				if(b.getSquare(r, c).getPiece() != null) {
					if(b.getSquare(r, c).getPiece().getOwner() == 1) {
						squares[r][c].setText(b.getSquare(r, c).getPiece().getSymbol());
					} else {
						squares[r][c].setText(b.getSquare(r, c).getPiece().getSymbol());
						squares[r][c].setForeground(Color.WHITE);
					}
				} else {
					squares[r][c].setText("");
					squares[r][c].setForeground(Color.BLACK);
				}
			}
		}
		for(int i=0;i<38;i++) {
			if(p1.getPiece(i) != null) {
				p1.getPiece(i).demote();
				p1List[i].setText(p1.getPiece(i).getSymbol());
				p1List[i].setVisible(true);
			} else {
				p1List[i].setVisible(false);
			}
			if(p2.getPiece(i) != null) {
				p2.getPiece(i).demote();
				p2List[i].setText(p2.getPiece(i).getSymbol());
				p2List[i].setVisible(true);
			} else {
				p2List[i].setVisible(false);
			}
		}
		frame.revalidate();
		frame.repaint();
	}
}