package ch11;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextAreaEx extends JFrame{
	private JTextField tf = new JTextField(20);
	private JTextArea ta = new JTextArea(7, 20);
	
	public TextAreaEx() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setLayout(new FlowLayout());
		
		add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		add(tf);
		add(new JScrollPane(ta));
		
		tf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField)e.getSource();
				ta.append(t.getText() + "\n");
				t.setText(""); 
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new TextAreaEx();
	}
}
