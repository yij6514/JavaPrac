package ch11;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class RadioButtonItemEx extends JFrame {
	private JRadioButton [] radio = new JRadioButton [3];
	private String [] text = {"사과", "배", "체리"};
	private ImageIcon [] image = {
			new ImageIcon("images/apple.jpg"), 
			new ImageIcon("images/pear.jpg"),
			new ImageIcon("images/cherry.jpg")
			};
	private JLabel imageLabel = new JLabel();

	public RadioButtonItemEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,200);
		setTitle("라디오버튼 이벤트 처리");
		setLayout(new BorderLayout());
		
		JPanel radioPanel = new JPanel();
		radioPanel.setBackground(Color.gray);
		
		ButtonGroup g = new ButtonGroup();
		for(int i = 0; i < radio.length; i++) {
			radio[i] = new JRadioButton(text[i]);
			g.add(radio[i]);
			radioPanel.add(radio[i]);
			radio[i].addItemListener(new MyItemListener());
		}
		
		add(radioPanel,BorderLayout.NORTH);
		add(imageLabel, BorderLayout.CENTER);
		imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.DESELECTED)  
				return; // 해제된 경우 그냥 리턴(잠깐 참고)
			if(radio[0].isSelected()) // 사과가 선택된 경우
				imageLabel.setIcon(image[0]);
			else if(radio[1].isSelected()) // 배가 선택된 경우
				imageLabel.setIcon(image[1]);
			else // 체리가 선택된 경우
				imageLabel.setIcon(image[2]);
		}
	}
	
	public static void main(String[] args) {
		new RadioButtonItemEx();
	}

}
