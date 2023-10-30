package ch14;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuEx extends JFrame{
	public MenuEx() {
		setTitle("메뉴만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(250,200);
		
		createMenu();
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar(); // 메뉴바 생성
		JMenu screenMenu = new JMenu("파일(F)"); // Screen 메뉴 생성
		JMenu editMenu = new JMenu("편집(E)");
		JMenu helpMenu = new JMenu("도움말(H)");
		
		screenMenu.add(new JMenuItem("새로만들기"));
		screenMenu.add(new JMenuItem("열기"));
		screenMenu.add(new JMenuItem("저장"));
		screenMenu.add(new JMenuItem("종료"));
		
		editMenu.add(new JMenuItem("실행취소"));
		editMenu.add(new JMenuItem("잘라내기"));
		editMenu.add(new JMenuItem("복사"));
		editMenu.add(new JMenuItem("붙여넣기"));
		
		helpMenu.add(new JMenuItem("도움말보기"));
		helpMenu.add(new JMenuItem("정보"));
		
		mb.add(screenMenu); // Screen 메뉴 삽입
		mb.add(editMenu); // Edit 메뉴 생성 삽입
		mb.add(helpMenu);
		setJMenuBar(mb);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuEx();
	}

}
