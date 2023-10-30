package ch11;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Assign11_9 extends JFrame {
    JButton btn[] = new JButton[3];
    ImageIcon imageIcons[] = {new ImageIcon("images/scissor.png"), new ImageIcon("images/rock.png"), new ImageIcon("images/paper.png")};
    JLabel userLabel = new JLabel("me");
    JLabel computerLabel = new JLabel("com");
    JLabel result = new JLabel();
    int user, computer;
    
    Assign11_9(){
    	//기본적인 프레임 설정 사항입니다.
        setTitle("가위 바위 보 게임");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 800);
        
        //위쪽 버튼의 패널입니다
        JPanel top = new JPanel();
        top.setLayout(new FlowLayout());
        top.setBackground(Color.gray);
        top.setBounds(0, 0, 1000, 200);

        for(int i = 0; i < 3; i++){
            btn[i] = new JButton(imageIcons[i]);
            btn[i].addActionListener(new game(i));	//버튼마다 game이라는 이벤트처리 클래스를 추가하였습니다
            top.add(btn[i]);
        }
        
        add(top);
        
        //게임이 진행된후 결과를 보여줄 패널입니다
        JPanel center = new JPanel();
        center.setLayout(new FlowLayout());
        center.add(userLabel);
        center.add(computerLabel);
        result.setForeground(Color.RED);
        center.add(result);
        center.setBackground(Color.YELLOW);
        center.setBounds(0, 200, 1000, 650);
        add(center);
    
        setVisible(true);
    }

    //가위바위보 게임의 버튼의 이벤트 처리 클래스입니다.
    class game implements ActionListener{
        int index;
        
        game(int i){
            index = i;
        }
        
        public void actionPerformed(ActionEvent e){
            user = index;
            computer = (int)(Math.random() * 3);
            userLabel.setIcon(imageIcons[user]);
            computerLabel.setIcon(imageIcons[computer]);

            if(user == computer){
                result.setText("SAME!!");	//컴퓨터와 같은걸 내면 비깁니다
            }
            else if(user - computer == -2 || user - computer == 1){
                result.setText("ME !!");	//컴퓨터를 이겼을때입니다.
            }else{
                result.setText("COM !!");
            }
        }
    }

    public static void main(String args[]){
        new Assign11_9();
    }
}
