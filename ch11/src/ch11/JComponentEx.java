package ch11;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JComponentEx extends JFrame{
	
	public JComponentEx() {
		setTitle("JComponent 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setLayout(new FlowLayout());
		
		JButton a = new JButton("Magenta/Yellow Button");
		a.setBackground(Color.yellow);
		a.setForeground(Color.magenta);
		a.setFont(new Font("arial", Font.ITALIC, 20));
		add(a);
		
		JButton b = new JButton("Disabled Button");
		b.setEnabled(false);
		add(b);
		
		JButton c = new JButton("getX(),getY()");
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton c1 = (JButton)e.getSource();
				JComponentEx frame = (JComponentEx)c1.getTopLevelAncestor();
				frame.setTitle(c1.getX() + "," + c1.getY());
			}
		});
		add(c);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JComponentEx();
	}
}
