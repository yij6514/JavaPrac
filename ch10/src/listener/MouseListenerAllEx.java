package listener;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class MouseListenerAllEx extends JFrame{
	private JLabel la = new JLabel("No Mouse Event");
	
	public MouseListenerAllEx() {
		setTitle("마우스 리스너와 마우스모션리스너 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.addMouseListener(new MyListener());
		c.addMouseMotionListener(new MyListener());
		c.add(la);
		
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MouseListenerAllEx();
	}
	
	class MyListener implements MouseListener,MouseMotionListener{
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if(e.getClickCount() == 2) { // 더블클릭의 경우
				// [0,255] 사이의 랜덤한 r,g,b 정수 값 얻기 
				int r = (int)(Math.random()*256);
				int g = (int)(Math.random()*256);
				int b = (int)(Math.random()*256);
				
				Component c = (Component)e.getSource(); // 마우스가 클릭된 컴포넌트를 알아낸다.
				c.setBackground(new Color(r,b,g)); // 컴포넌트의 배경을 r,g,b 색으로 칠한다.
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			Component c = (Component)e.getSource(); // 마우스가 올라간 컴포넌트를 알아낸다.
			c.setBackground(Color.CYAN);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			Component c = (Component)e.getSource(); // 마우스가 내려간 컴포넌트를 알아낸다.
			c.setBackground(Color.YELLOW);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("mousePressed ("+e.getX()+","+e.getY()+")"); // 마우스가 눌러진 위치 (x,y) 점을 출력
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("MouseReleased("+e.getX()+","+e.getY()+")"); // 마우스가 떼어진 위치 (x,y) 점을 출력
		}
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("MouseDragged ("+e.getX()+","+e.getY()+")");
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			la.setText("MouseMoved ("+e.getX()+","+e.getY()+")");
		}
	}

}
