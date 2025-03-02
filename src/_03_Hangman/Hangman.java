package _03_Hangman;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	
	
	void setup(){
		frame.add(panel);
		frame.setVisible(true);
		panel.add(label);
		frame.setTitle("Hang Man");
		frame.pack();
	}
	
	 public static void main(String[] args) {
		 Hangman man = new Hangman();
		man.setup();
	String num = JOptionPane.showInputDialog(null, "please enter a number between 0 and 266" );
	Utilities.readRandomLineFromFile(num);
	System.out.println(Utilities.readRandomLineFromFile("dictionary.txt"));
	}
}
