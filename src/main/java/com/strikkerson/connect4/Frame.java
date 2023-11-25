package com.strikkerson.connect4;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Frame extends JFrame {
    CardLayout cl = new CardLayout();
    JPanel clPanel = new JPanel();
    JPanel gameScreenPanel = new JPanel();
    JPanel winScreenPanel = new JPanel();
    
    public Frame(){
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setResizable(false);
        
        clPanel.setLayout(cl);
        clPanel.add(gameScreenPanel, "game");
        clPanel.add(winScreenPanel, "win");
        
        add(clPanel);
    }

    public void loadGameScreen(int[][] board, PlacingButton[] buttons){
        gameScreenPanel.setLayout(new BorderLayout());
        
        BoardPanel boardPanel = new BoardPanel(buttons, board);
        
        gameScreenPanel.add(boardPanel);
        
        cl.show(clPanel, "game");
        gameScreenPanel.setVisible(true);
        setVisible(true);

    }

    public void loadWinScreen(int winnerNumber, int[][] board) {
        PlacingButton[] buttons = new PlacingButton[7];
        for(int i = 0; i<7; i++){
            buttons[i] = new PlacingButton();
        }
        
        winScreenPanel.setLayout(new BorderLayout());
        
        BoardPanel boardPanel = new BoardPanel(buttons, board);
        winScreenPanel.add(boardPanel);
        
        cl.show(clPanel, "win");
        setVisible(true);
        
        JOptionPane.showMessageDialog(null, "Jogador "+winnerNumber+" venceu!", "Temos um vencedor:", JOptionPane.PLAIN_MESSAGE);
    }
}