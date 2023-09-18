package gui;

import javax.swing.*;
import java.awt.*;

public class BoderLayoutEx extends JFrame{
	public BoderLayoutEx() {
		setTitle("BorderLayout 프레임");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container con = getContentPane();
		con.setBackground(Color.CYAN);
		
		con.setLayout(new BorderLayout());
		con.add(new JButton("East"),BorderLayout.EAST);
		con.add(new JButton("West"),BorderLayout.WEST);
		con.add(new JButton("Center"),BorderLayout.CENTER);
		con.add(new JButton("North"),BorderLayout.NORTH);
		con.add(new JButton("South"),BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BoderLayoutEx();
	}
}
