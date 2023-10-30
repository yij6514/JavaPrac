package ch12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Assign12_6 extends JFrame{
	public Assign12_6() {
		setTitle("페인트예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,250);
		
		setContentPane(new MyPanel());
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			int w = getWidth();
			int h = getHeight();
			
			
			for(int i = 0; i < 10; i++) {
				int[] x = {w/2, i * 10, w/2, h- i * 10};
				int[] y = {i * 10, h/2, w - i * 10, h/2};
				g.drawPolygon(x, y, 4);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Assign12_6();
	}

}
