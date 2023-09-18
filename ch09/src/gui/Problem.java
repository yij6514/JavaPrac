package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Problem extends JFrame{
	public Problem() {
		setTitle("Ten Color Buttons Frame");
		setSize(500,300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(1,10));
		
		for(int i = 0; i < 10; i++) {
			Color[] col = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN,
					Color.BLUE, Color.MAGENTA, Color.GRAY, Color.PINK, Color.LIGHT_GRAY
			};
			JButton a = new JButton(Integer.toString(i));
			a.setBackground(col[i]);
			c.add(a);
		}
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Problem();
	}
}
