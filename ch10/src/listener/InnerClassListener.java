package listener;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class InnerClassListener extends JFrame {
	public static void main(String [] args) {
		new InnerClassListener();
	}
	
	public InnerClassListener() {
		setTitle("내부 클래스 Action 이벤트 리스너 예재");
		setSize(350,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		btn.addActionListener(new myActionListener());
		c.add(btn);
		
		setVisible(true);
	}
	
	private class myActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton) e.getSource();
			if(b.getText().equals("Action")) {
				b.setText("액션");
			}
			else {
				b.setText("Action");
			}
		}
	}
} 
