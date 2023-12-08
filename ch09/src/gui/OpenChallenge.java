package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpenChallenge extends JFrame{
	public OpenChallenge() {
		setTitle("오픈챌린지");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(new BorderLayout());
		
		add(new NorthPanel(),BorderLayout.NORTH);
		add(new CenterPanel(),BorderLayout.CENTER);
		
		setVisible(true);
	}
	
	class NorthPanel extends JPanel{
		public NorthPanel() {
			setBackground(Color.LIGHT_GRAY);
			setLayout(new FlowLayout());
			add(new JButton("Open"));
			add(new JButton("Read"));
			add(new JButton("Close"));
		}
	}
	
	class CenterPanel extends JPanel{
		public CenterPanel() {
			setLayout(null);
			JLabel hello = new JLabel("Hello");
			JLabel java = new JLabel("Java");
			JLabel love = new JLabel("Love");
			hello.setBounds(100,100,100,20);
			java.setBounds(133,360,100,20);
			love.setBounds(365,294,100,20);
			add(hello);
			add(love);
			add(java);
		}
	}
	
	public static void main(String[] args) {
		new OpenChallenge();
	}
}
