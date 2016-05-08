import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class Shogi extends JFrame {

		static JPanel boardGUI = new JPanel(new GridLayout(9,9));
	    public static void main(String[] args){
	    	Board b = new Board();
	        JFrame frame = new JFrame();
	        frame.setSize(486,486);
	        frame.setTitle("Shogi");
	        frame.add(boardGUI);
	        frame.setBackground(Color.LIGHT_GRAY);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        JButton[][] squares = new JButton[9][9];
	        
	        for(int r=0;r<9;r++) {
	        	for(int c=0;c<9;c++) {
	        		squares[r][c] = new JButton();
	        		squares[r][c].setOpaque(true);
	        		squares[r][c].setSize(54, 54);
	        		squares[r][c].setBorder(new LineBorder(Color.BLACK));
	        		boardGUI.add(squares[r][c]);
	        	}
	        }
	        
	        for(int r=0;r<9;r++) {
	        	for(int c=0;c<9;c++) {
	        		if(b.getSquare(r, c).getPiece() != null) {
	        			squares[r][c].setText(b.getSquare(r, c).getPiece().getSymbol());
	        		}
	        	}
	        }
	        frame.setVisible(true);
	        frame.revalidate();
	        frame.repaint();
	    }  
	}