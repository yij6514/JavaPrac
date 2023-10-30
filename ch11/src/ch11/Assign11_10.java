package ch11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Assign11_10 extends JFrame {
    int count = 0;
    
    Assign11_10 () {
    	//기본적인 프레임의 설정사항입니다
        setTitle("Ten 레이블 클릭");
        setDefaultCloseOperation(3);
        setLayout(null);
        setSize(350, 350);
        
        //0부터 9까지 숫자가 들어갈 레이블의 리스트입니다.
        JLabel[] labels = new JLabel[10];
        
        for(int i= 0; i < labels.length; i++) {
        	//각 레이블의 위치를 랜덤으로 조정하기 위한 변수입니다
            int x = (int) (Math.random() * 300);
            int y = (int) (Math.random() * 300);
            
            //각 레이블의 기본적인 설정사항입니다.
            labels[i] = new JLabel(Integer.toString(i));
            labels[i].setBounds(x, y, 15, 15);
            labels[i].setForeground(Color.MAGENTA);
            //각 레이블마다 익명 클래스로 이벤트처리하였습니다.
            labels[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel temp = (JLabel) e.getSource();
                    //유저가 레이블을 순서대로 눌렀는지 확인하는 조건문입니다
                    if(Integer.parseInt(temp.getText()) <= Integer.parseInt(labels[count].getText())){
                        temp.setVisible(false);
                        count++;
                        //유저가 마지막 9 레이블을 눌렀을때 다시 레이블의 위치를 조정하여 재시작하는 코드입니다.
                        if(Integer.parseInt(temp.getText()) == 9){
                            for(int i = 0; i < labels.length; i++){
                                int x = (int) (Math.random() * 300);
                                int y = (int) (Math.random() * 300);

                                labels[i].setLocation(x, y);
                                labels[i].setVisible(true);
                            	}
                        	}
                    	}
                	}
            });
            add(labels[i]);
        }       
        setVisible(true);
    }

    public static void main (String args[]) {
        new Assign11_10();
    }
}