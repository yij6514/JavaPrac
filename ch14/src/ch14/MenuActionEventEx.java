package ch14;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuActionEventEx extends JFrame{
	private JLabel imgLabel = new JLabel(); // 빈 이미지를 가진 레이블
	public MenuActionEventEx() {
		setTitle("Menu에 Action 리스너 만들기 예제");
		createMenu();
		getContentPane().add(imgLabel, BorderLayout.CENTER); 
		setSize(250,220); 
		setVisible(true);
	}
	
	private void createMenu() { // 메뉴바와 Screen 메뉴 생성. Screen 메뉴에 4개의 메뉴아이템 삽입
		JMenuBar mb = new JMenuBar(); // 메뉴바 생성
		JMenuItem [] menuItem = new JMenuItem [4];
		String[] itemTitle = {"Load", "Hide", "ReShow", "Exit"};
		JMenu screenMenu = new JMenu("Screen");
		
		// 4개의 메뉴아이템을 Screen 메뉴에 삽입한다.
		MenuActionListener listener = new MenuActionListener(); // Action 리스너 생성
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle[i]); // 메뉴아이템 생성
			menuItem[i].addActionListener(listener); // 메뉴아이템에 Action 리스너 등록
			screenMenu.add(menuItem[i]); // 메뉴아이템을 Screen 메뉴에 삽입
		}
		mb.add(screenMenu); // 메뉴바에 Screen 메뉴 삽입
		setJMenuBar(mb); // 메뉴바를 프레임에 부착
	}
	
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			switch(s) {
			case "Load" : 
				if(imgLabel.getIcon() != null) 
					return; // 이미 로딩되었으면 리턴
				imgLabel.setIcon(new ImageIcon("images/img.jpg")); 
				break;
			case "Hide" :		
				imgLabel.setVisible(false); 
				break;
			case "ReShow" : 
				imgLabel.setVisible(true); 
				break;
			case "Exit":
				System.exit(0);
				break;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuActionEventEx();
	}

}
