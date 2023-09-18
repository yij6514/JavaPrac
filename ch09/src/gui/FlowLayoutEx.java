package gui;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame{
	public FlowLayoutEx() {
		setTitle("Flowlayout 프레임");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container con = getContentPane();
		con.setBackground(Color.CYAN);
		con.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		con.add(new JButton("East"));
		con.add(new JButton("West"));
		con.add(new JButton("Center"));
		con.add(new JButton("North"));
		con.add(new JButton("South"));
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new FlowLayoutEx();
	}
}
