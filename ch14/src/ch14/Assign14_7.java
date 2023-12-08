package ch14;

import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.event.*;
import java.io.File;

public class Assign14_7 extends JFrame{
	
	Clip clip = null;
	File audioFile = null;
	JLabel lb = new JLabel("파일을 선택해주세요.");
	
	Assign14_7(){
		
		Container c = getContentPane();
		
		JMenuBar mb = new JMenuBar();
		JMenu audio = new JMenu("오디오");
		JMenuItem play = new JMenuItem("연주");
		JMenuItem stop = new JMenuItem("연주종료");
		
		mb.add(audio);
		audio.add(play);
		audio.add(stop);
		setJMenuBar(mb);
		
		Action action = new Action();
		
		play.addActionListener(action);
		stop.addActionListener(action);
		
		setTitle("훙훙의 블로그");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
	}
	
	class Action implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String text = e.getActionCommand();
			if(text.equals("연주")) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("wav 파일", "wav");
				chooser.setFileFilter(filter);
				int select = chooser.showOpenDialog(null);
				
				if( select == JFileChooser.APPROVE_OPTION) {
					String path = chooser.getSelectedFile().getPath();
					audioAction(path);
				}
			}
			else if(text.equals("연주종료")) {
				if(clip.isActive()) {
					lb.setText("연주가 종료되었습니다");
					clip.stop();
				}
					
			}
		}
	}
	
	public void audioAction(String path) {
		try {
			clip = AudioSystem.getClip();
			audioFile = new File(path);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.start();
			lb.setText(path+"가 연주되고 있습니다.");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Assign14_7();
	}

}