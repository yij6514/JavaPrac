package ch14;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MenuAndFileDialogEx extends JFrame{
	private JLabel imageLabel = new JLabel();
	private JLabel label = new JLabel("Hello");
	
	public MenuAndFileDialogEx() {
		setTitle("Menu와 JFileChooser 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(350,200);
		Container c = getContentPane();
		
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie", Font.ITALIC, 30));
		c.add(label, BorderLayout.CENTER);
		
		//add(imageLabel);
		createMenu();
		
		setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenu textMenu = new JMenu("Text");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem colorMenuItem = new JMenuItem("Color");
		
		saveItem.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
				
				chooser.setFileFilter(filter);
				int ret = chooser.showOpenDialog(chooser);
				if(ret != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
					return;
				}
			}
		});
		openItem.addActionListener(new OpenActionListener());
		colorMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String cmd = e.getActionCommand(); // 메뉴아이템의 이름 리턴
				if(cmd.equals("Color")) { // Color 메뉴아이템의 경우
					// 컬러 다이얼로그를 출력하고 사용자가 선택한 색을 알아온다.
					Color selectedColor = JColorChooser.showDialog(null,"Color",Color.YELLOW);
					
					// 취소 버튼을 누르거나 그냥 다이얼로그를 닫는 경우 selectedColor는 null이다.
					if(selectedColor != null) 
						label.setForeground(selectedColor);
				}
			}
		});
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		textMenu.add(colorMenuItem);
		mb.add(fileMenu);
		mb.add(textMenu);
		setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener{
		private JFileChooser chooser;
		
		public OpenActionListener() {
			chooser = new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "jpg", "gif");
			
			chooser.setFileFilter(filter);
			int ret = chooser.showOpenDialog(chooser);
			if(ret != JFileChooser.APPROVE_OPTION) {
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String filePath = chooser.getSelectedFile().getPath();
			imageLabel.setIcon(new ImageIcon(filePath));
			pack();
		}
	}
	
	public static void main(String[] args) {
		new MenuAndFileDialogEx();
	}

}
