package ch13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RandomCircleFrame extends JFrame{
	public RandomCircleFrame() {
		super("원을 0.5초 간격으로 랜덤한 위치로 이동시키는 스레드");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new CirclePanel());
		setSize(250,250);
		setVisible(true);
	}
	
	class CirclePanel extends JPanel implements Runnable{
		private int x = 100;
		private int y = 100;
		
		public CirclePanel() {
			addMouseListener(new MouseAdapter() {
				private Thread th = null;
				
				@Override
				public void mousePressed(MouseEvent e) {
					if(th == null) {
						th = new Thread(CirclePanel.this);
						th.start();
					}
				}
			});
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			g.drawOval(x, y, 50, 50);
		}
		
		@Override
		public void run() {
			while(true) {
				try {
					Thread.sleep(500);
				}
				catch (InterruptedException e) {
					return;
				}
				
				x = (int) (Math.random() * this.getWidth());
				y = (int) (Math.random() * this.getHeight());
				repaint();
			}
		}
	}
	
	public static void main(String[] args) {
		new RandomCircleFrame();
	}
}
