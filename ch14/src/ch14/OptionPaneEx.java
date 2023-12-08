package ch14;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPaneEx extends JFrame {
	public OptionPaneEx() {
		setTitle("옵션 팬 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);

		add(new MyPanel(), BorderLayout.NORTH);
		
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private JButton inputButton = new JButton("Input Name");
		private JButton confirmBtn = new JButton("Confirm");
		private JButton messageBtn = new JButton("Message");
		private JTextField tf = new JTextField(10);
		
		public MyPanel() {
			add(inputButton);
			add(confirmBtn);
			add(messageBtn);
			add(tf);
			inputButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String name = JOptionPane.showInputDialog("이름을 입력하세요.");
					if(name != null)
						tf.setText(name);
				}
			});
			
			confirmBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 확인 다이얼로그 생성
					int result = JOptionPane.showConfirmDialog(null, 
							"계속할 것입니까?", "Confirm", JOptionPane.YES_NO_OPTION);

					// 사용자가 선택한 버튼에 따라 문자열을 텍스트필드 창에 출력
					if(result == JOptionPane.CLOSED_OPTION)
						tf.setText("Just Closed without Selection");
					else if(result == JOptionPane.YES_OPTION)
						tf.setText("Yes");
					else
						tf.setText("No");
				}
			});
		}
	}
	
	public static void main(String[] args) {
		new OptionPaneEx();
	}
}
