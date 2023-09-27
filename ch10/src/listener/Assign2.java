package listener;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Assign2 extends JFrame{
	JLabel a = new JLabel("Love Java");
	
	public Assign2() {
		setTitle("마우스 휠을 굴려 폰트 크기 조정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(30,30,700,300);
		setLayout(new FlowLayout());
		
		add(a);
		
		addMouseWheelListener(new MyListener());
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Assign2();
	}
	
	class MyListener extends MouseAdapter{
		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			// TODO Auto-generated method stub			
			int tmp = a.getFont().getSize();
			if(e.getWheelRotation() < 0) {
				tmp += 5;
				a.setFont(new Font("Dialog.bold", Font.PLAIN, tmp));
			}
			else {
				if(tmp >5) {
					tmp -= 5;
					a.setFont(new Font("Dialog.bold", Font.PLAIN, tmp));
				}
			}
		}
	}

}
