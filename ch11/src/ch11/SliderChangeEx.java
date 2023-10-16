package ch11;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderChangeEx extends JFrame{
	private JLabel colorLabel;
	private JSlider [] sl = new JSlider [3];

	public SliderChangeEx() {
		setTitle("슬라이더와 ChangeEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		colorLabel = new JLabel("       SLIDER EXAMPLE        ");
		
		for(int i = 0; i < sl.length; i++) {
			sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128); 
			sl[i].setPaintLabels(true);
			sl[i].setPaintTicks(true);
			sl[i].setPaintTrack(true);
			sl[i].setMajorTickSpacing(50);
			sl[i].setMinorTickSpacing(10);
			sl[i].addChangeListener(new MyChangeListener());
			c.add(sl[i]);
		}
		
		sl[0].setForeground(Color.RED); // s[0] 슬라이더는 RED 값 선택
		sl[1].setForeground(Color.GREEN); // s[1] 슬라이더는 GREEN 값 선택
		sl[2].setForeground(Color.BLUE);
		
		
		c.add(colorLabel);
		setSize(300,230);
		setVisible(true);
	}
	
	class MyChangeListener implements ChangeListener {
		public void stateChanged(ChangeEvent e) { // 슬라이더의 값이 변경할 때 호출
			// 3개의 슬라이더로부터 값을 얻어 colorLabel의 배경색 변경
			int r = sl[0].getValue(); // R 성분 값 얻기
			int g = sl[1].getValue(); // G 성분 값 얻기
			int b = sl[2].getValue(); // B 성분 값 얻기
			colorLabel.setBackground(new Color(r,g,b)); // r,g,b 값으로 새로운 색 설정
		}
	}
	
	public static void main(String [] args) {
		new SliderChangeEx();
	}
}
