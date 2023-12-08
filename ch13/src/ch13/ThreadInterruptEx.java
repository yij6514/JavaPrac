package ch13;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThreadInterruptEx extends JFrame {
	private Thread th;
	
	ThreadInterruptEx(){
		setTitle("인터럽트예재");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,170);
		setLayout(new FlowLayout());
		
		JLabel timerLabel = new JLabel();
		timerLabel.setFont(new Font("Gothic", Font.ITALIC, 80));
		
		TimerRunnable runnable = new TimerRunnable(timerLabel);
		th = new Thread(runnable);
		add(timerLabel);
		
		JButton btn = new JButton("kill Timer");
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				th.interrupt();
				JButton btn = (JButton)e.getSource();
				btn.setEnabled(false);
			}
		});
		add(btn);
		
		setVisible(true);
		
		th.start();
	}
	
	public static void main(String[] args) {
		new ThreadInterruptEx();
	}
}

class TimerRunnerable implements Runnable{
	private JLabel timerLabel;
	public TimerRunnerable(JLabel timerLabel) {
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