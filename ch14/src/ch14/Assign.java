package ch14;

import java.awt.*;  
import javax.swing.*;  
import javax.swing.filechooser.*;  
import javax.swing.text.StyledEditorKit;  
import java.awt.event.*;  
import java.io.*;  
  
public class Assign extends JFrame  {  
 // 변수 선언  
	JTextArea text;  
	Container pane;  
	JMenuBar nb = new JMenuBar();  
	JMenu file, help, edit;  
	JMenuItem newI, openI, saveI, closeI, infoI, helpI, copyI, pasteI, cutI; //제작
	String clip; //제작
	JFileChooser open = new JFileChooser();//파일 및 디렉토리 선택 컴포넌트 선언  
   
   
	public Assign()  {  
		super("MemoNote"); // 부모클래스 생성자 호출  
		pane=getContentPane(); //JFrame 디자인을 위한 컨텐츠 영역 선언  
		pane.setLayout(new BorderLayout()); //JFrame 정렬  
		setJMenuBar(nb); // 메뉴바 붙임  
   
  // 메뉴 및 메뉴 아이템 생성  
		file = new JMenu("파일(F)");  
		help = new JMenu("정보(I)");
		edit = new JMenu("편집(E)");
    
  //키보드 연상기호 설정  
		file.setMnemonic('F');  
		help.setMnemonic('I');  
    
  //파일 메뉴 내용 생성  
		newI = new JMenuItem("새파일");  
		openI = new JMenuItem("열기");  
		saveI = new JMenuItem("저장");  
		closeI = new JMenuItem("닫기");
  
  // 메뉴 단축키를 위한 셋팅  
		newI.setAccelerator(KeyStroke.getKeyStroke('N',Event.CTRL_MASK));  // Ctrl + N  
		openI.setAccelerator(KeyStroke.getKeyStroke('O',Event.CTRL_MASK)); // Ctrl + O  
		saveI.setAccelerator(KeyStroke.getKeyStroke('S',Event.CTRL_MASK)); // Ctrl + S  
		closeI.setAccelerator(KeyStroke.getKeyStroke('Q',Event.CTRL_MASK)); // Ctrl + Q  
  
  //정보 메뉴 생성  
		infoI = new JMenuItem("정보");  
		infoI.setAccelerator(KeyStroke.getKeyStroke('R',Event.CTRL_MASK)); // Ctrl + R  
  
  //제작
		copyI = new JMenuItem("복사");
		pasteI = new JMenuItem("붙여넣기");
		cutI = new JMenuItem("잘라내기");
  
  // 메뉴에 내용 붙임  
		file.add(newI);  
		file.add(openI);  
		file.add(saveI);  
		file.add(closeI);  
		help.add(infoI);
  
  // 제작
		edit.add(cutI);
		edit.add(copyI);
		edit.add(pasteI);
    
  // 메뉴 완성  
		nb.add(file);  
		nb.add(help);
  // 제작
		nb.add(edit);
   
  // 메뉴에서 새파일 클릭했을때 이벤트 처리  
		newI.addActionListener(new ActionListener()  {  
			public void actionPerformed(ActionEvent e)  {  
				text.setText(""); // text내용을 모두 지운다  
			}  
		});  
   
  // 메뉴에서 열기 클릭했을때 이벤트 처리  
		openI.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				int re = open.showOpenDialog(Assign.this); //파일열기 다이얼로그창을 띄운다  
				if (re==JFileChooser.APPROVE_OPTION) {     //리턴 상태 확인    
					String fN;  
					String dir;  
					String str;  
      
					File file_open = open.getSelectedFile(); // 선택한 파일명을 가져온다  
     
					FileInputStream fis;   //파일 시스템의 파일 입력 바이트 취급 스트림 선언  
					ByteArrayOutputStream bo;  //데이터 바이트 배열에 기입해지는 출력 스트림 선언  
					try  {  
						fis = new FileInputStream(file_open); // FileInputStream객체를 생성  
						bo = new ByteArrayOutputStream();     // ByteArrayOutputStream객체를 생성  
						int i = 0;  
						while ((i = fis.read()) != -1) {// 파일이 끝날때까지 읽어드림    
							bo.write(i);                  //len 바이트를 바이트 배열 출력 Stream에 기입  
						}  
						text.setText(bo.toString()); // 화면에 뿌려준다  
						fis.close();                 // FileInputStream을 닫는다.                  
						bo.close();                  // ByteArrayOutputStreamm을 닫는다.  
					}  
					catch(FileNotFoundException fe)  
					{}  
					catch(IOException ie)  
					{}  
				}  
			}  
		});  
		
  //메뉴에서 저장 클릭했을때 이벤트 처리  
		saveI.addActionListener(new ActionListener() {  
			public void actionPerformed(ActionEvent e) {  
				int re = open.showSaveDialog(Assign.this);  
				if (re==JFileChooser.APPROVE_OPTION) // 파일저장 다이얼로그를 띄운다  
				{  
					File file_open = open.getSelectedFile(); // 저장할 파일명을 가져온다  
					
					try  
					{  
						PrintWriter pw   = new PrintWriter(new BufferedWriter(new FileWriter(file_open))); // PrintWriter객체를 생성해서  
						pw.write(text.getText()); // 화면의 내용을 파일에 쓴다  
						pw.close();  
					}  
					
					catch(FileNotFoundException ie2)  
					{}  
					catch(IOException ie)  
					{}  
				}  
			}  
		});  
   
  //메뉴에서 닫기를 클릭했을때 이벤트 처리  
		closeI.addActionListener(new ActionListener()  
		{  
			public void actionPerformed(ActionEvent e)  
			{  
				dispose(); // 창을 닫고   
				System.exit(0); // 종료한다  
			}  
		});  
		
  // 메뉴에서 정보를 클릭했을때 이벤트 처리  
		infoI.addActionListener(new ActionListener()  
		{  
			public void actionPerformed(ActionEvent e)  
			{  
 // 	정보를 보여주는 다이얼로그를 띄운다  
				JOptionPane.showMessageDialog(pane , "MemoNote 2009/12 Kim & Park");  
			}  
		});  
  
		copyI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip = text.getSelectedText();
			}
		});
  
		pasteI.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				int position = text.getCaretPosition();
				text.insert(clip, position);
			}
		});
  
		cutI.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				clip = text.getSelectedText();
				int start = text.getSelectionStart();
				int end = text.getSelectionEnd();
				text.replaceRange("", start, end);
			}
		});
  
		text = new JTextArea();  
   
  // 화면에 보여질 text들의 상태에 따른 색상 지정  
		text.setCaretColor(Color.black);   
		text.setSelectedTextColor(Color.white);  
		text.setSelectionColor(Color.blue);  
		text.setBackground(Color.white);  
   
		pane.add(new JScrollPane(text));  
  
	}  
   
	public static void main(String[] args)  
	{  
		Assign note = new Assign(); // 객체생성  
		note.setSize(400,300); // 사이즈 지정  
		note.setVisible(true); // 화면에 보이게 함  
	}  
}  