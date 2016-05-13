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

	//The JPanel that handles the visual for the board object
	static JPanel boardGUI = new JPanel(new GridLayout(9,9));

	//The JPanel that handles the visual for the hand objects
	static JPanel[] handPanel = {null, new JPanel(), new JPanel() };

	//The Frame that's displayed. (Contains the Panels)
	static JFrame frame = new JFrame();

	//The Array of JButtons which handle the visual for the Square objects
	static JButton[][] squares = new JButton[9][9];

	//The board object
	static Board b = new Board();

	//A variable that handles which Square the player currently has selected
	static Square lastClicked = null;

	//Handles the current turn
	public static int turn = 2;

	//Array which holds the JButton arrays for each player's hand visual
	public static JButton[] playerHandsButtons[] = { null, new JButton[38], new JButton[38] };

	public static void main(String[] args){
		//Set up the frame with sizes and a layout
		frame.setLayout(new BorderLayout());
		frame.setSize(486,600);
		frame.setTitle("Shogi");
		frame.add(boardGUI,BorderLayout.CENTER);
		frame.add(handPanel[1],BorderLayout.PAGE_START);
		frame.add(handPanel[2],BorderLayout.PAGE_END);
		boardGUI.setSize(486, 486);
		handPanel[1].setSize(486, 57);
		handPanel[2].setSize(486,57);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add squares to hands
		for(int j=1;j<=2;j++) {
			for(int i=0;i<38;i++) {
				playerHandsButtons[j][i] = new JButton("");

				playerHandsButtons[j][i].setOpaque(true);
				playerHandsButtons[j][i].setSize(54, 54);
				//Hide line border but preserve square shape
				playerHandsButtons[j][i].setBorder(new LineBorder(Color.WHITE));
				playerHandsButtons[j][i].setBackground(Color.WHITE);

				final int finalJ = j;

				playerHandsButtons[j][i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<38;i++) {
							if(e.getSource() == playerHandsButtons[finalJ][i]) {
								Square s = new Square(100,100);
								Piece t = b.getHand(finalJ).getPiece(i);
								t.setOwner(b.getHand(finalJ).getOwner());
								s.setPiece(t);
								lastClicked = s;
								playerHandsButtons[finalJ][i].setText("");
								playerHandsButtons[finalJ][i].setVisible(false);
								b.getHand(finalJ).setPiece(i, null);
							}
						}
					}
				});

				handPanel[j].add(playerHandsButtons[j][i]);
			}

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
											b.movePiece(lastClicked, b.getSquare(r, c));
											squares[r][c].setForeground(Color.BLACK);
											lastClicked = null;	
											if(turn == 1){
												turn = 2;
											} else {
												turn = 1;
											}
											updateBoard();
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
		for(int j=1;j<=2;j++) {
			for(int i=0;i<38;i++) {
				if(b.getHand(j).getPiece(i) != null) {
					b.getHand(j).getPiece(i).demote();
					playerHandsButtons[j][i].setText(b.getHand(j).getPiece(i).getSymbol());
					playerHandsButtons[j][i].setVisible(true);
				} else {
					playerHandsButtons[j][i].setVisible(false);
				}
			}
			frame.revalidate();
			frame.repaint();
		}
	}
}