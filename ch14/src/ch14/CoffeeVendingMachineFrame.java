package ch14;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CoffeeVendingMachineFrame extends JFrame{
	private CoffeeMachinePanel coffeeMachinePanel = new CoffeeMachinePanel();
	public CoffeeVendingMachineFrame() {
		setTitle("Open Challenge 14");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new TitlePanel(), BorderLayout.NORTH);
		c.add(coffeeMachinePanel, BorderLayout.CENTER);
		c.add(new ButtonPanel(), BorderLayout.SOUTH);
		
		setSize(450,400);
		setResizable(false);
		setVisible(true);
	}
	
	class TitlePanel extends JPanel{
		private JLabel titleMsg = new JLabel("Welcome, Hot Coffee !!");
		public TitlePanel() {
			titleMsg.setHorizontalAlignment(JLabel.CENTER);
			setBackground(Color.magenta);
			add(titleMsg);
		}
	}
	
	class ButtonPanel extends JPanel{
		private JButton[] coffeeButtons = new JButton[4];
		private String[] names = {"Black Coffee", "Sugar Coffee", "Dabang Coffee", "Reset"};
		
		public ButtonPanel() {
			for(int i = 0; i < coffeeButtons.length; i++) {
				coffeeButtons[i] = new JButton(names[i]);
				add(coffeeButtons[i]);
				
				coffeeButtons[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						coffeeMachinePanel.operate(e.getActionCommand());
					}
				});
			}
		}
	}
	
	class CoffeeMachinePanel extends JPanel{
		private BoxLabel[] boxes = new BoxLabel[5];
		private JLabel coffeeImageLabel;
		private final int CUP = 0;
		private final int COFFEE = 1;
		private final int WATER = 2;
		private final int SUGAR = 3;
		private final int CREAM = 4;
		
		private String[] boxNames = {"Cup", "Coffee", "Water", "Sugar", "Cream"};
		
		private ImageIcon coffeeIcon = new ImageIcon("imgaes/coffee.jpg");
		
		public CoffeeMachinePanel() {
			setLayout(null);
			for(int i = 0; i < boxes.length; i++) {
				boxes[i] = new BoxLabel();
				boxes[i].setLocation(30 + 80 * i, 10);
				boxes[i].setSize(40,100);
				
				JLabel text = new JLabel(boxNames[i]);
				text.setLocation(30 + 80 * i, 120);
				text.setSize(50,30);
				
				add(boxes[i]);
				add(text);
			}
			
			coffeeImageLabel = new JLabel();
			
			coffeeImageLabel.setLocation(180,200);
			coffeeImageLabel.setSize(coffeeIcon.getIconWidth(), coffeeIcon.getIconHeight());
			
			add(coffeeImageLabel);
		}
		
		public void operate(String cmd) {
			if(cmd.equals("Black Coffee")) {
				if(boxes[CUP].isEmpty() || boxes[COFFEE].isEmpty() || boxes[WATER].isEmpty()) {
					error("부족한 것이 있습니다. 채워주세요.");
					return;
				}
				else {
					boxes[CUP].consume();
					boxes[COFFEE].consume();
					boxes[WATER].consume();
				}
			}
			else if(cmd.equals("Sugar Coffee")) {
				if(boxes[CUP].isEmpty() || boxes[COFFEE].isEmpty() || boxes[WATER].isEmpty() || boxes[SUGAR].isEmpty()) {
					error("부족한 것이 있습니다. 채워주세요.");
					return;
				}
				else {
					boxes[CUP].consume();
					boxes[COFFEE].consume();
					boxes[WATER].consume();
					boxes[SUGAR].consume();
				}
			}
			else if(cmd.equals("Dabang Coffee")) {
				if(boxes[CUP].isEmpty() || boxes[COFFEE].isEmpty() || boxes[WATER].isEmpty() || boxes[SUGAR].isEmpty() || boxes[CREAM].isEmpty()) {
					error("부족한 것이 있습니다. 채워주세요.");
					return;
				}
				else {
					boxes[CUP].consume();
					boxes[COFFEE].consume();
					boxes[WATER].consume();
					boxes[SUGAR].consume();
					boxes[CREAM].consume();
				}
			}
			else {
				boxes[CUP].reset();
				boxes[COFFEE].reset();
				boxes[WATER].reset();
				boxes[SUGAR].reset();
				boxes[CREAM].reset();
				repaint();
				
				return;
			}
			
			repaint();
			
			this.coffeeImageLabel.setIcon(coffeeIcon);
			
			JOptionPane.showMessageDialog(CoffeeMachinePanel.this, "뜨거워요, 즐거운 하루~~", "커피나왔습니다.",JOptionPane.INFORMATION_MESSAGE);
			
			coffeeImageLabel.setIcon(null);
		}
		
		public void error(String msg) {
			JOptionPane.showMessageDialog(CoffeeMachinePanel.this, msg, "커피 자판기 경고", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
	}
	
	class BoxLabel extends JLabel{
		private final int MAXSIZE = 10;
		private int currentSize;
		
		public BoxLabel() {
			currentSize = MAXSIZE;
		}
		boolean consume() {
			if(currentSize > 0) {
				currentSize--;
				return true;
			}
			else {
				return false;
			}
		}
		
		void reset() {
			currentSize = MAXSIZE;
		}
		
		boolean isEmpty() { return currentSize == 0; }
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			
			g.setColor(Color.LIGHT_GRAY);;
			int y = this.getHeight() - (currentSize * this.getHeight() / MAXSIZE);
			g.fillRect(0, y, this.getWidth(), this.getHeight() - y);
			
			g.setColor(Color.gray);
			g.drawRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
		}
	}
	
	static public void main(String[] args) {
		new CoffeeVendingMachineFrame();
	}
}
