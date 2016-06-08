import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchScreen {

	static JLabel rulesMessage = new JLabel("<html><p style='width: 500px;'>The king (K). The king can move one square in any horizontal, vertical, or diagonal direction, just like the king in international chess. The king does not promote.<br><br>The rook (R). The rook can move any number of squares in a horizontal or vertical direction. The rook is the same as the rook in international chess (except that it can promote). A rook promotes to a “dragon king” or “dragon” for short (often just referred to as a “promoted rook”), which can move as a rook or can move one square in any diagonal direction.<br><br>The bishop (B). The bishop can move any number of squares in a diagonal direction. The bishop is the same as the bishop in international chess (except that it can promote). A bishop promotes to a “dragon horse” or “horse” for short (often just referred to as a “promoted bishop”), which can move as a bishop or can move one square in any horizontal or vertical direction. Note: the horse should not be confused with a knight (see below), as they are two completely different pieces.<br><br>The gold general (G). A gold general can move one square in any horizontal or vertical direction, or one square in a forward diagonal direction. Gold generals do not promote.<br><br>The silver general (S). A silver general can move one square in any diagonal direction, or one square straight forward. A silver general promotes to a gold general.<br><br>The knight (Kn). A knight can move one square straight forward followed by one square to either forward diagonal, jumping over intervening pieces if any. In other words, a knight moves like its international chess counterpart, but forward only. A knight promotes to a gold general. The knight is the only jumping piece, as in chess.<br><br>The lance (L). A lance can move any number of squares straight forward. A lance promotes to a gold general.<br><br>The pawn (P). A pawn can move one square straight forward. The pawn captures the same way that it moves, in contrast to international chess. There is also no initial two-space move for pawns and no en-passant capture. A pawn promotes to a gold general; a promoted pawn is usually known as a 'Tokin'.</p></html>");

	public static void main(String args[]) {
		setupFrame();
	}

	public static void setupFrame() {
		//Frame and content panel
		final JFrame launchScreen = new JFrame();	
		JPanel content = new JPanel();
		//Buttons
		JButton newGame = new JButton("New Game");
		JButton about = new JButton("About");
		JButton license = new JButton("License");
		//Setup frame
		launchScreen.setSize(486,300);
		launchScreen.setTitle("Shogi");
		//Set content panel to layout and add buttons
		content.setLayout(new GridLayout(3,1));
		content.add(newGame);
		content.add(about);
		content.add(license);
		launchScreen.add(content);
		launchScreen.setVisible(true);
		//setup button listeners to do what they say they do
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create a new game
				new Shogi();
				launchScreen.dispose();
			}
		});

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//about message dialog window
				JOptionPane.showMessageDialog(launchScreen,
					rulesMessage,
					"About",
						JOptionPane.DEFAULT_OPTION);
			}
		});

		license.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//about message dialog window
				JOptionPane.showMessageDialog(launchScreen,
					"Shogi Copyright (C) 2016 David Allen\n" +
					"This program comes with ABSOLUTELY NO WARRANTY;\n" +
					"for details visit <http://www.gnu.org/licenses/>",
						"License",
							JOptionPane.DEFAULT_OPTION);
			}
		});

		launchScreen.revalidate();
		launchScreen.repaint();
	}
}
