package ch12;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintJPanelEx extends JFrame{
	public PaintJPanelEx() {
		setTitle("페인트예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,220);
		
		setContentPane(new MyPanel());
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		public void paintComponent(Graphics g) {
			g.setColor(Color.blue);
			g.drawRect(10,10,50,50);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PaintJPanelEx();
	}

}
