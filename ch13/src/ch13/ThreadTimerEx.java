package ch13;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadTimerEx extends JFrame{
	public ThreadTimerEx() {
		setTitle("thread 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300,170);
		
		JLabel timerlabel = new JLabel();
		timerlabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		add(timerlabel);
		
		TimerThread thread = new TimerThread(timerlabel);
		thread.start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ThreadTimerEx();
	}
}

class TimerThread extends Thread{
	private JLabel timerLabel;
	public TimerThread(JLabel timerLabel) {
		this.timerLabel = timerLabel;
	}
	
	@Override
	public void run() {
		int n = 0;
		while(true) {
			timerLabel.setText(Integer.toString(n));
			n++;
			try {
				Thread.sleep(1000);
			}
			catch(InterruptedException e) {
				return;
			}
		}
	}
}