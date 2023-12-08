package ch12;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class OpenChallenge extends JFrame{
	public OpenChallenge() {
		super("Open Challenge 12");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel p = new ImagePanel();
		setContentPane(p);
		
		setSize(400,400);
		setVisible(true);
		
		p.setFocusable(true);
		p.requestFocus();
	}
	
	class ImagePanel extends JPanel{
		private Image img = null;
		private int clipX = 0, clipY = 0;
		
		public ImagePanel() {
			img = new ImageIcon("images/bg.jpg").getImage();
			
			this.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					JPanel panel = (JPanel)e.getSource();
					panel.requestFocus();
				}
			});
			this.addKeyListener(new MyKeyListener());
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setClip(clipX, clipY, 20, 20);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
			g.drawString("자바", 40, 340);
		}
		
		class MyKeyListener extends KeyAdapter{
			@Override
			public void keyPressed(KeyEvent e) {
				switch(e.getKeyCode()) {
					case KeyEvent.VK_UP :
						clipY -= 10;
						if(clipY < 0)
							clipY = 0;
						break;
					case KeyEvent.VK_DOWN :
						clipY += 20;
						if(clipY > getHeight())
							clipY -= 10;
						break;
					case KeyEvent.VK_LEFT :
						clipX -= 10;
						if(clipX < 0)
							clipX = 0;
						break;
					case KeyEvent.VK_RIGHT :
						clipX += 10;
						if(clipX > getWidth())
							clipX -= 10;
						break;
				}
				repaint();
			}
		}
	}
	
	public static void main(String[] args) {
		new OpenChallenge();
	}
}
