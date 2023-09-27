package listener;

import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LovejavaEx extends JFrame{
	private JLabel a = new JLabel("Love Java");
	public LovejavaEx () {
		setTitle("LovejavaEx");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		a.addMouseListener(new MyListener());
		add(a);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LovejavaEx();
	}
	
	class MyListener extends MouseAdapter{
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			a.setText("Love Java");
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			a.setText("사랑해");
		}
	}

}
