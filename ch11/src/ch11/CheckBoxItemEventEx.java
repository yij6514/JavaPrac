package ch11;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckBoxItemEventEx extends JFrame{
	private JCheckBox [] fruits = new JCheckBox [3];
	private String [] names = {"사과", "배", "체리"};
	private JLabel sumLabel;
	
	public CheckBoxItemEventEx () {
		setTitle("체크박스 아이템이벤트 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(250,200);
		
		add(new JLabel("사과 100원, 배 500원, 체리 20000원"));
		
		MyListener listener = new MyListener();
		for(int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].addItemListener(listener);
			add(fruits[i]);
		}
		
		sumLabel = new JLabel("현재 0 원 입니다."); // 가격 합을 출력하는 레이블 생성
		add(sumLabel);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();
	}
	
	class MyListener implements ItemListener {
		private int sum = 0;
		
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) {
				if(e.getItem() == fruits[0]) 
					sum += 100;
				if(e.getItem() == fruits[1])
					sum += 500;
				if(e.getItem() == fruits[2])
					sum += 20000;
			}
			else {
				if(e.getItem() == fruits[0]) 
					sum -= 100;
				else if(e.getItem() == fruits[1])
					sum -= 500;
				else
					sum -= 20000;
			}
			sumLabel.setText("현재 "+ sum + "원 입니다.");
			
		}
	}
}
