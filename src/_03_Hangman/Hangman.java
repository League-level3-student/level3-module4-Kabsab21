package _03_Hangman;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.stream.IntStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Hangman implements KeyListener, ActionListener {
	static ArrayDeque<String> q = new ArrayDeque<String>();
	static ArrayList<String> list = new ArrayList<String>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel labelt = new JLabel();
	JLabel label = new JLabel();
	JButton button = new JButton();
	JTextField txt = new JTextField();
	static String word;
	static ArrayList<Character> letters = new ArrayList<Character>();
	static ArrayList<String> corresponding = new ArrayList<String>();
	static int lives = 10;
	int score = 0;
	char keypressed;
	
	 
	
	void setup(){
		frame.add(panel);	
		frame.setVisible(true);
		panel.add(labelt);
		panel.add(label);
		txt.setPreferredSize(new Dimension( 50,50));
		txt.addKeyListener(this);
		button.addActionListener(this);
		button.setText("enter");
		panel.add(txt);
		panel.add(button);
		frame.setSize(100,100);
		labelt.setText("lives: "+lives);
		label.setText(corresponding+"");
		frame.setTitle("Hang Man");
		frame.setSize(500, 500);
		frame.pack();
	}
	
	 public static void main(String[] args) {
		 Hangman man = new Hangman();
		 man.listmaker();
		
		 man.game();
		 man.setup();
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
			for( int i = 0; i < word.length(); i++) {
				letters.add(word.charAt(i));
				corresponding.add("_");
			}
			System.out.println(letters);
			System.out.println(corresponding);
		}

		
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
		 System.out.println("key pressede"+e.getKeyChar());
		  keypressed = (char) e.getKeyChar();
		//
		 if( txt.getText().length() >= 1) {
		//	 txt.getText().substring(txt.getText().length() -1,txt.getText().length() );
			 txt.setText(txt.getText().substring(txt.getText().length() -1,txt.getText().length() - 1));
			 }
		 }

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println("SIERE");
			JButton button1 = (JButton) e.getSource();
			if( button1 == button) {
				for( int i = 0; i < letters.size(); i++ ) {
					if( letters.get(i).equals(keypressed)) {
						corresponding.set(i, letters.get(i)+"");
						System.out.println(letters.get(i));
					}else {
						lives = lives -1;
						System.out.println(lives);
						if(lives == 0) {
							JOptionPane.showInputDialog(null, "game over " );
							// chat maybe edit this segment.
						}
					}
				}
				label.setText(corresponding+"");
			}
			
		}
		
		
	// 
	// when user guess a letter, iterate through array to find letters macht, if letters match replace __ in blank array with letter
	// if not, reduce the lives by one. onece arrays are fully equal to each other, write score one if win, if run out of lives lose.
	// give user their score out of all games played.
	
}


