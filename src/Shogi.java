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

	public Shogi() {
		//Border layout to hold board in the center, and each hand at the
		//top and bottom of the page, corresponding with player
		frame.setLayout(new BorderLayout());
		frame.setSize(486,600);
		frame.setTitle("Shogi Game");
		frame.add(boardGUI,BorderLayout.CENTER);
		//add player one hand GUI to top of screen
		frame.add(handPanel[1],BorderLayout.PAGE_START);
		//add player two hand GUI to bottom of screen
		frame.add(handPanel[2],BorderLayout.PAGE_END);
		boardGUI.setSize(486, 486);
		handPanel[1].setSize(486,57);
		handPanel[2].setSize(486,57);
		frame.setResizable(false);
		//allow the frame to be closed
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Add a button for each hand piece
		//for both players
		for(int j=1;j<=2;j++) {
			//for the 38 possible slots per player
			for(int i=0;i<38;i++) {
				//initialize with an empty button
				playerHandsButtons[j][i] = new JButton("");
				playerHandsButtons[j][i].setOpaque(true);
				playerHandsButtons[j][i].setSize(54, 54);
				//Hide line border (white on white) but preserve square shape
				playerHandsButtons[j][i].setBorder(new LineBorder(Color.WHITE));
				playerHandsButtons[j][i].setBackground(Color.WHITE);
				//save the owner of the hand (player number) in a final
				final int finalJ = j;
				//add anonymous listener class to handle when a hand piece is clicked
				playerHandsButtons[j][i].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for(int i=0;i<38;i++) {
							//find the hand piece based on the action O(n)
							if(e.getSource() == playerHandsButtons[finalJ][i]) {
								if(b.getHand(finalJ).getPiece(i).getOwner() != turn) {
									//create a temporary square at position 100 (invisible)
									Square s = new Square(100,100);
									Piece t = b.getHand(finalJ).getPiece(i);
									t.setOwner(b.getHand(finalJ).getOwner());
									s.setPiece(t);
									//set lastclicked to this temporary square
									lastClicked = s;
									//after the piece is moved hide the hand button
									playerHandsButtons[finalJ][i].setText("");
									playerHandsButtons[finalJ][i].setVisible(false);
									b.getHand(finalJ).setPiece(i, null);
								}
							}
						}
					}
				});
				//add each hand button to the GUI panel
				handPanel[j].add(playerHandsButtons[j][i]);
			}

		}

		//Draw a square button for each square
		//Handle what happens if a square is clicked
		for(int r=0;r<9;r++) {
			for(int c=0;c<9;c++) {
				//Initialize the button in the board array
				squares[r][c] = new JButton();
				squares[r][c].setOpaque(true);
				squares[r][c].setSize(54, 54);
				//force the square JButtons to draw as squares
				squares[r][c].setBorder(new LineBorder(Color.BLACK));
				//Set the background color for each square to light brown
				squares[r][c].setBackground(Color.decode("#db9356"));
				//Create an anonymous action listener class that handles
				//what happens when a square is clicked
				squares[r][c].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//For each square on the board
						for(int r=0;r<9;r++) {
							for(int c=0;c<9;c++) {
								//Find the square that was clicked iteratively
								if(e.getSource() == squares[r][c]) {
									int x = 0;
									//Check if the square contains a piece
									try {		
										x = b.getSquare(r, c).getPiece().getOwner();
									} catch(Exception e1) {}
									//If it's the turn of the piece on the square
									//and the last clicked square is null
									if(lastClicked == null && x == turn) {
										//null check
										if(b.getSquare(r, c).getPiece() != null) {
											//set the lastclicked variable to handle movement on
											//the next click
											lastClicked = b.getSquare(r, c);
											//Get every square on the board and highlight possible moves
											for(int i=0;i<9;i++) {
												for(int j=0;j<9;j++) {
													if(b.getSquare(r, c).getPiece().canMove(b.getSquare(r, c),
															b.getSquare(i, j), b)) {
														//draw a "." on each possible movement square
														squares[i][j].setText(squares[i][j].getText() + ".");
													}
												}
											}
										}
									} else {
										try {
											//If a piece is already selected, and a new square
											//was clicked, try to move the piece
											b.movePiece(lastClicked, b.getSquare(r, c), turn);
											squares[r][c].setForeground(Color.BLACK);
											//clear lastclicked to allow the next move
											lastClicked = null;	
											//cycle turns
											if(turn == 1){
												turn = 2;
											} else {
												turn = 1;
											}
											updateBoard();
										} catch (Exception ex) {
											//If the move failed, clear lastclicked and allow
											//the player to try to move again
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
				//add each square to the GUI panel
				boardGUI.add(squares[r][c]);
			}
		}

		updateBoard();
		frame.setVisible(true);
		//Redraw the graphics to show the squares
		frame.revalidate();
		frame.repaint();
	}

	public static void updateBoard() {
		//For pieces in the 9x9 board
		for(int r=0;r<9;r++) {
			for(int c=0;c<9;c++) {
				if(b.getSquare(r, c).getPiece() != null) {
					//Set the piece text based on the piece symbol
					squares[r][c].setText(b.getSquare(r, c).getPiece().getSymbol());
					if(b.getSquare(r, c).getPiece().getOwner() == 1) {
						//Set piece color for player one
						squares[r][c].setForeground(Color.BLACK);
					} else {
						//Set piece color for player two
						squares[r][c].setForeground(Color.WHITE);
					}
				} else {
					//If square is empty, clear text
					squares[r][c].setText("");
					squares[r][c].setForeground(Color.BLACK);
				}
			}
		}
		//For pieces in the players' hands
		for(int j=1;j<=2;j++) {
			for(int i=0;i<38;i++) {
				if(b.getHand(j).getPiece(i) != null) {
					//Demote any captured promoted pieces
					b.getHand(j).getPiece(i).demote();
					//Set the square text to the piece symbol
					playerHandsButtons[j][i].setText(b.getHand(j).getPiece(i).getSymbol());
					//If there's a piece, make the button visible
					playerHandsButtons[j][i].setVisible(true);
				} else {
					//If there are no pieces in the hand button, hide it
					playerHandsButtons[j][i].setVisible(false);
				}
			}
			//Redraw the graphics after each move
			frame.revalidate();
			frame.repaint();
		}
	}
}