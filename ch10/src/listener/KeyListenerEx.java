package listener;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class KeyListenerEx extends JFrame{
	private JLabel[] keyMessage;
	
	public KeyListenerEx() {
		setTitle("keylistener 예재");
		setSize(300,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel(" getKeyCode() ");
		keyMessage[1] = new JLabel(" getKeyChar() ");
		keyMessage[2] = new JLabel(" getKeyText() ");
		
		c.add(keyMessage[0]);
		c.add(keyMessage[1]);
		c.add(keyMessage[2]);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new KeyListenerEx();
	}
}
