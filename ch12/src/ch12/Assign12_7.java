package ch12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Assign12_7 extends JFrame {
	private MyPanel panel = new MyPanel();

	public Assign12_7() {
		setTitle("마우스로 폐다각형 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(300, 300);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		private Vector<Point> v = new Vector<Point>();

		public MyPanel() {
			setFocusable(true);
			requestFocus();
			addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					v.add(e.getPoint());
					repaint();
				}
			});
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.MAGENTA);
			int[] x = new int[v.size()];
			int[] y = new int[v.size()];
			for (int i = 0; i < v.size(); i++) {
				Point p = v.elementAt(i);
				x[i] = (int) p.getX();
				y[i] = (int) p.getY();
			}
			g.drawPolygon(x, y, v.size());
		}
	}

	public static void main(String[] args) {
		new Assign12_7();
	}

}
