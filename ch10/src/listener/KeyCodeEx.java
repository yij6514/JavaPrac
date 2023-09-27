package listener;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyCodeEx extends JFrame{
	private JLabel la = new JLabel();
	
	public KeyCodeEx() {
		setTitle("keycode 예재");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addKeyListener(new MyListener());
		c.add(la);
		
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
	}
	
	public static void main(String[] args) {
		new KeyCodeEx();
	}
	
	class MyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			Container c = (Container)e.getSource();
			la.setText(KeyEvent.getKeyText(e.getKeyCode()) + "key pressed");
			if(e.getKeyChar() == '%') // 입력된 키가  % 인 경우
				c.setBackground(Color.YELLOW);
			else if(e.getKeyCode() == KeyEvent.VK_F1) // 입력된 키가 <F1> 인가
				c.setBackground(Color.GREEN);
		}
	}
}