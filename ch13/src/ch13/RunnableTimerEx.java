package ch13;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class RunnableTimerEx extends JFrame{
	public RunnableTimerEx() {
		setTitle("runnable 예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		setSize(300,170);
		
		JLabel timerlabel = new JLabel();
		timerlabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		add(timerlabel);
		
		TimerRunnable thread = new TimerRunnable(timerlabel);
		Thread th = new Thread(thread);
		//th.start();
		
		Thread th1 = new Thread(new TimerRunnable(timerlabel));
		th1.start();
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RunnableTimerEx();
	}
}

class TimerRunnable implements Runnable{
	private JLabel timerLabel;
	public TimerRunnable(JLabel timerLabel) {
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
