package gui;

import java.awt.*;

import javax.swing.*;

public class Problem3 extends JFrame{
	public Problem3() {
		//JFrame 전체 설정입니다 크기, 제목
		setTitle("계산기 프레임");
		setSize(300, 225);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//JFrame 컨테이너 인스턴스를 받아 새로 레이아웃을 지정
		Container c = getContentPane();
		c.setLayout(new BorderLayout(0, 1));
		
		//BorderLayout.NORTH에 들어갈 JPanel입니다
		JPanel c1 = new JPanel(new FlowLayout());
		
		//c1 패널에 색깔 변경 라벨과 텍스트필드 추가
		c1.setBackground(Color.lightGray);
		JLabel a = new JLabel("수식입력");
		JTextField jtf1 = new JTextField(20);
		c1.add(a);
		c1.add(jtf1);
		
		//BorderLayout.CENTER에 들어갈 JPanel입니다
		JPanel c2 = new JPanel(new GridLayout(4,4,2,2));
		
		//for문을 이용하여 0~9까지의 버튼을 생산 및 추가 합니다
		for(int i = 0; i < 10; i ++)
			c2.add(new JButton(Integer.toString(i)));
		
		c2.add(new JButton("CE"));
		c2.add(new JButton("계산"));
		
		//for문과 리스트를 이용해서 연산자를 버튼으로 생성 및 추가
		String[] opArr = {"+", "-", "X", "/"};
		for(int i = 0; i < opArr.length; i++) {
			JButton tmp = new JButton(opArr[i]);
			tmp.setBackground(Color.cyan);
			c2.add(tmp);
		}
		
		//BoderLayout.SOUTH에 들어갈 JPanel입니다
		JPanel c3 = new JPanel(new FlowLayout());
		
		//c3 패널에 색깔 변경 라벨과 텍스트필드 추가
		c3.setBackground(Color.green);
		JLabel b = new JLabel("계산결과");
		JTextField jtf2 = new JTextField(20);
		c3.add(b);
		c3.add(jtf2);
		
		//다 만들어진 JPanel들을 컨테이너에 추가
		c.add(c1, BorderLayout.NORTH);
		c.add(c2, BorderLayout.CENTER);
		c.add(c3, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Problem3();
	}
}
