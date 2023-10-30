package ch14;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog {
	private JTextField tf = new JTextField(10); // 다이얼로그에 삽입할 텍스트 필드
	private JButton okButton = new JButton("OK"); // 다이얼로그에 삽입할 OK 버튼
	
	public MyDialog(JFrame frame, String title) {
		super(frame,title);
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200, 100);
	
		// 다이얼로그의 OK 버튼에 Action 리스너 달기
		// OK 버튼이 선택되면 다이얼로그가 화면에서 사라지게 한다.
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false); // 다이얼로그를 보이지 않게 한다.
			}
		});
	}
}

public class DialogEx extends JFrame{
	private MyDialog dialog;
	
	public DialogEx() {
		setTitle("JDialog 예재");
		setSize(250,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btn  = new JButton("Show Dialog");
		dialog = new MyDialog(this, "Test Dialog");
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true); // 다이얼로그를 출력하고 작동시킨다.
			}
		});
		
		getContentPane().add(btn);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new DialogEx();
	}
}
