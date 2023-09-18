package javaTest;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MineSweeper extends JFrame {
    private JButton[][] cells = new JButton[10][10];
    private boolean[][] mines = new boolean[10][10];
    private int[][] numbers = new int[10][10];
    
    public MineSweeper() {
        setTitle("지뢰찾기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        
        Container c = getContentPane();
        c.setLayout(new GridLayout(10, 10));
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                cells[i][j] = new JButton("");
                cells[i][j].setFont(new Font("Arial", Font.PLAIN, 12));
                cells[i][j].addActionListener(new CellListener(i, j));
                c.add(cells[i][j]);
            }
        }
        
        int count = 0;
        while (count < 10) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            if (!mines[x][y]) {
                mines[x][y] = true;
                count++;
            }
        }
        
        setVisible(true);
    }
    
    private class CellListener implements ActionListener {
        private int row, col;
        
        public CellListener(int r, int c) {
            row = r;
            col = c;
        }
        
        public void actionPerformed(ActionEvent e) {
            if (mines[row][col]) {
                cells[row][col].setText("*");
                JOptionPane.showMessageDialog(null, "지뢰가 폭발했습니다!");
                System.exit(0);
            } else {
                int count = countMines(row, col);
                cells[row][col].setText("" + count);
            }
        }
        
        private int countMines(int r, int c) {
            int count = 0;
            for (int i = r-1; i <= r+1; i++) {
                for (int j = c-1; j <= c+1; j++) {
                    if (i >= 0 && i < 10 && j >= 0 && j < 10 && mines[i][j]) {
                        count++;
                    }
                }
            }
            return count;
        }
    }
    
    public static void main(String[] args) {
        new MineSweeper();
    }
}
