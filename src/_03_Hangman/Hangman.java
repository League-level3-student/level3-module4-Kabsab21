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
	JButton button2 = new JButton();
	JTextField txt = new JTextField();
	static String word;
	static ArrayList<Character> letters = new ArrayList<Character>();
	static ArrayList<String> corresponding = new ArrayList<String>();
	static int lives = 10;
	int score = 0;
	char keypressed;
	int nuum;
	
	
	
	 
	
	void setup(){
		frame.add(panel);	
		frame.setVisible(true);
		panel.add(labelt);
		panel.add(label);
		txt.setPreferredSize(new Dimension( 50,50));
		txt.addKeyListener(this);
		button.addActionListener(this);
		button.setText("enter");
		button2.addActionListener(this);
		button2.setText("new game");
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
			 nuum = Integer.parseInt(num);
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
					//	System.out.println(list.size()+" word added: "+wrd);
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
		// System.out.println("key pressede"+e.getKeyChar());
		  keypressed = (char) e.getKeyChar();
		
		 if( txt.getText().length() >= 1) {
		
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
			Boolean living = false;
			
		//	System.out.println("SIERE");
			JButton button1 = (JButton) e.getSource();
			if( button1 == button) {
				for( int i = 0; i < letters.size(); i++ ) {
					if( letters.get(i).equals(keypressed)) {
						living = true;
						corresponding.set(i, letters.get(i)+"");
					//	System.out.println(letters.get(i));
						
					}
				}
				if(living == false ) {
					lives = lives -1;
				}
			//	System.out.println(lives+" "+living);
				if(lives == 0) {
					JOptionPane.showMessageDialog(null, "game lost " );
				}
				if(letters.toString().equals(corresponding.toString())) {
					JOptionPane.showMessageDialog(null, "game won " );
					panel.add(button2);
					frame.pack();
					score = score+1;
				}
				label.setText(corresponding+"");
				labelt.setText("lives: "+lives);
			}
			
			if( button1 == button2) {
				if(q.size() == 0){
					JOptionPane.showMessageDialog(null, "All rounds are completed, you have won "+score+"/"+nuum+" rounds" );
				}
				else {
					letters.removeAll(letters);
					corresponding.removeAll(corresponding);
			game();
			setup();
				}
			}
			
		}
		
		
	 
	
	
	
}


