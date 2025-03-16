package _03_Hangman;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.IntStream;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman {
	static ArrayDeque<String> q = new ArrayDeque<String>();
	static ArrayList<String> list = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	static String word;
	static int lives = 10;
	int score = 0;
	
	 
	
	void setup(){
		frame.add(panel);
		frame.setVisible(true);
		panel.add(label);
		frame.setTitle("Hang Man");
		frame.pack();
	}
	
	 public static void main(String[] args) {
		 Hangman man = new Hangman();
		 man.listmaker();
		 man.setup();
		 man.game();
		
		}
		
		
		void listmaker() {
			
			String num = JOptionPane.showInputDialog(null, "please enter a number between 0 and 266" );
			int nuum = Integer.parseInt(num);
			while( nuum > list.size()) {
				Boolean equal = false;
				String wrd = Utilities.readRandomLineFromFile("dictionary.txt");
				for( int i = 0; i < list.size(); i++) {
					
					
					if( wrd.equals( list.get(i))) {
						equal = true;
						break;
					}
				}
				
				if( equal == false ) {
						list.add(wrd);
						System.out.println(list.size()+" word added: "+wrd);
				}
				
			}
			
			for( int i = 0; i < list.size(); i++) {
				q.add(list.get(i));
			}
			System.out.println(q);
			
			
			
		}
		
		void game() {
			word = q.pop();
			
		}
		
		
	// auhhh add thing for typing letters, make word into an array, connected to another array that is just blank,
	// when user guess a letter, iterate through array to find letters macht, if letters match replace __ in blank array with letter
	// if not, reduce the lives by one. onece arrays are fully equal to each other, write score one if win, if run out of lives lose.
	// give user their score out of all games played.
	
}


