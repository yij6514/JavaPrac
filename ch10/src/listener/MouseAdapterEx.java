package listener;

import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseAdapterEx extends JFrame{
	private JLabel la = new JLabel("Hello");
	
	public MouseAdapterEx() {
		setTitle("마우스 이벤트 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,250);
		
		Container c = getContentPane();
		c.setLayout(null);
		c.addMouseListener(new MyMouseAdapter());
		
		//JLabel la = new JLabel("Hello");
		
		la.setSize(50,20);
		la.setLocation(30,30);
		c.add(la);
		
		setVisible(true);
	}
	
	class MyMouseAdapter extends MouseAdapter{
		public void mousePressed(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
			la.setLocation(x,y);
		}
	}
	
	public static void main(String[] args) {
		new MouseAdapterEx();
	}
}
