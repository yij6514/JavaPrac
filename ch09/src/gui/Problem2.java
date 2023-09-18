package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Problem2 extends JFrame{
	public Problem2() {
		setTitle("Ten Color Buttons Frame");
		setSize(500,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new GridLayout(4,4));
		
		for(int i = 0; i < 16; i++) {
			Color[] col = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN,
					Color.CYAN, Color.BLUE, Color.MAGENTA, Color.GRAY, 
					Color.PINK, Color.LIGHT_GRAY,Color.black,Color.white,
					Color.darkGray, Color.MAGENTA, Color.ORANGE, Color.PINK
			};
			JLabel a = new JLabel(Integer.toString(i));
			a.setBackground(col[i]);
			a.setOpaque(true);
			c.add(a);
		}
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Problem2();
	}
}
