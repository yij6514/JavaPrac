package ch11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Assign extends JFrame{
	private JLabel[] viewList = new JLabel[8];
	private JTextField[] textList = new JTextField[8];
	private JCheckBox[] checkList = new JCheckBox[7];
	private String[] viewListstr = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
	private int[] arr = {50000,10000,1000,500,100,50,10,1};
	
	public Assign() {
		//프레임의 기본적인 설정사항입니다.
		setTitle("Money Changer with CheckBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(null);
		Container c = getContentPane();
		c.setBackground(new Color(255,192,203));
		
		//유저가 얼마의 돈을 입력할지를 받는 필드가 있는 패널입니다.
		JPanel top = new JPanel();
		top.setBackground(new Color(255,192,203));
		top.setLayout(new FlowLayout());
		top.setBounds(50,50,350,100);
		
		JTextField ad = new JTextField("0\t\t");
		JButton cal = new JButton("계산");
		//유저가 금액을 입력하고 계산 할 때 처리할 익명클래스입니다
		cal.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//메소드를 따로 지정하여 이 익명클래스에 모두 담지 않았습니다
				calculate(Integer.valueOf(ad.getText()));
			}
		});
		
		top.add(new JLabel("금액    "));
		top.add(ad);
		top.add(cal);
		
		//금액이 계산된 결과를 보여줄 패널입니다.
		JPanel bottom = new JPanel();
		bottom.setBackground(new Color(255,192,203));
		bottom.setLayout(new GridLayout(8,3,20,5));
		bottom.setBounds(80,100,350,300);
		
		for(int i = 0; i < viewList.length; i++) {
			viewList[i] = new JLabel(viewListstr[i]);
			viewList[i].setHorizontalAlignment(JLabel.RIGHT);
			
			textList[i] = new JTextField("0");
			textList[i].setHorizontalAlignment(JTextField.CENTER);
			
			if(i < 7) {
				checkList[i] = new JCheckBox();
				checkList[i].setBackground(new Color(255,192,203));
			}
			
			bottom.add(viewList[i]);
			bottom.add(textList[i]);
			if(i < 7)
				bottom.add(checkList[i]);
		}
		
		add(bottom);
		add(top);
		setVisible(true);
	}
	
	//금액이 계산되는 메소드입니다.
	public void calculate(int a) {
		int div, remain;
		remain = a;
		for(int i = 0; i < 7; i++) {
			//화폐를 사용할지 안할지 체크박스를 통해 조건을 받습니다
			if(checkList[i].isSelected()) {
				div = remain / arr[i];
				remain %= arr[i];
				textList[i].setText(Integer.toString(div));
			}
			else {
				//체크가 안된 단위들은 0으로 처리합니다
				textList[i].setText("0");
			}
		}
		//제일 마지막 1원 단위를 지정하는 코드입니다.
		textList[7].setText(Integer.toString(remain));
	}
	
	public static void main(String[] args) {
		new Assign();
	}
}
