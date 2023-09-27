package listener;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Assign1 extends JFrame{
	String str = "Love Java";
	JLabel a = new JLabel(str);
	
	public Assign1() {
		setTitle("Left 키로 문자열 이동");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30,300,200,100);
		setLayout(new FlowLayout());
		addKeyListener(new MyListener());
		
		add(a);
		
		setFocusable(true);
		requestFocus();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Assign1();
	}
	
	class MyListener extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_LEFT) {
				String tmp = str.substring(0,1);
				str = str.substring(1,str.length()) + tmp;
				a.setText(str);
			}
			else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
				String tmp = str.substring(str.length()-1,str.length());
				str = tmp + str.substring(0,str.length()-1);
				a.setText(str);
			}
		}
	}

}
