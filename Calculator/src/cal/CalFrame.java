package cal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalFrame extends JFrame{
	public CalFrame() {
		setTitle("Calculator");
		setSize(350,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		Container c = getContentPane();
		JPanel centerPan = new JPanel(new GridLayout(6,4,1,1));
		
		c.setLayout(new BorderLayout());
		
		JLabel mainBar = new MainBar();
		c.add(mainBar,BorderLayout.EAST);
		
		JButton[] btnList = new JButton[24];
		for(int i = 0; i < 24; i++) {
			JButton newBtn = new JButton(Integer.toString(i));
			centerPan.add(newBtn);
			btnList[i] = newBtn;
		}
		
		c.add(centerPan,BorderLayout.SOUTH);
		
		setVisible(true);
	}
}

class MainBar extends JLabel{
	public MainBar() {
		super("abcdefg");
		setHorizontalAlignment(JLabel.RIGHT);
		
	}
	
}
