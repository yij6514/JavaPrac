package listener;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class FlyingTextEx extends JFrame{
	private final int FLYING_UNIT = 10;
	private JLabel la = new JLabel("injoon");
	
	public FlyingTextEx() {
		setTitle("flying ex");
		setSize(300,300);
		//setPreferredSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c = getContentPane();
		c.setLayout(null);
		la.setLocation(50,50);
		la.setSize(100,20);
		c.add(la);
		
		c.addKeyListener(new MyListener());
		
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() { 
			public void mouseClicked(MouseEvent e) {
				Component c = (Component)e.getSource(); // 마우스가 클릭된 컴포넌트
				c.setFocusable(true);
				c.requestFocus(); // 컴포넌트에게 포커스 설정
			}
		});
	}
	
	public static void main(String[] args) {
		new FlyingTextEx();
	}
	
	class MyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			switch(keyCode) {
				case KeyEvent.VK_UP :
				case KeyEvent.VK_W :
					la.setLocation(la.getX(),la.getY() - FLYING_UNIT);
					break;
				case KeyEvent.VK_DOWN :
				case KeyEvent.VK_S :
					la.setLocation(la.getX(),la.getY() + FLYING_UNIT);
					break;
				case KeyEvent.VK_LEFT :
				case KeyEvent.VK_A :
					la.setLocation(la.getX() - FLYING_UNIT,la.getY());
					break;
				case KeyEvent.VK_RIGHT :
				case KeyEvent.VK_D :
					la.setLocation(la.getX() + FLYING_UNIT,la.getY());
					break;
				case KeyEvent.VK_HOME :
					la.setLocation(300,300);
			}
		}
	}
}