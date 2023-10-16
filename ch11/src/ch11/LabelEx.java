package ch11;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LabelEx extends JFrame{
	public LabelEx() {
		setTitle("레이블 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(400,600);
		
		JLabel text = new JLabel("사랑합니다.");
		
		ImageIcon a = new ImageIcon("images/beauty.jpg");
		JLabel image = new JLabel(a);
		
		ImageIcon b = new ImageIcon("images/normalicon.gif");
		JLabel c = new JLabel("보고싶으면 전화하세요", b, SwingConstants.CENTER);
		
		add(text);
		add(image);
		add(c);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}
}
