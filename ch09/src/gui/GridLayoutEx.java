package gui;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame{
	public GridLayoutEx() {
		setTitle("GridLayout 예재");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(new JLabel(" 이름"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학번"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 학과"));
		c.add(new JTextField(""));
		c.add(new JLabel(" 과목"));
		c.add(new JTextField(""));
		
		GridLayout grid = new GridLayout(4,2);
		grid.setVgap(10);
		
		c.setLayout(grid);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx();
	}
}
