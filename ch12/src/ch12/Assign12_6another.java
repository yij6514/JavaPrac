package ch12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assign12_6another extends JFrame{
	public Assign12_6another() {
		setTitle("페인트예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,220);
		
		setContentPane(new MyPanel());
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			int w = getWidth();
			int h = getHeight();
			for(int i = 0; i < 10 ; i++) {
				g.drawLine(i * w / 10, 0, i * w / 10, h);
			}
			for(int i = 0; i < 10; i++) {
				g.drawLine(0, i * h / 10, w, i* h/10);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Assign12_6another();
	}

}
