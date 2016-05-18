import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class LaunchScreen {

	public static void main(String args[]) {
		setupFrame();
	}

	public static void setupFrame() {
		//Frame and content panel
		JFrame launchScreen = new JFrame();	
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
		//setup button listeners to do what they say they do
		newGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Create a new game
				Shogi game = new Shogi();
				game.setVisible(true);
			}
		});

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//about message dialog window
				JOptionPane.showMessageDialog(launchScreen,
						"This program was created by David Allen.\n It comes with ABSOLUTELY NO WARRANTY.",
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

		launchScreen.add(content);
		launchScreen.setVisible(true);
	}
}
