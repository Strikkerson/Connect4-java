package com.strikkerson.connect4;

import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;


public class BoardPanel extends JPanel {
    public BoardPanel(PlacingButton[] buttons, int board[][]){
        super(new GridLayout(7,7));
        
        for(int i=0;i<7;i++){
            add(buttons[i]);
        }
        
        ImageIcon redDot = createImageIcon("/redDotIcon.png");
        ImageIcon yellowDot = createImageIcon("/yellowDotIcon.png");
        ImageIcon emptyDot = createImageIcon("/emptyIcon.png");
        
        for(int i=1;i<7;i++){
            for(int j=0;j<7;j++){
                JLabel label;
                
                switch(board[i-1][j]){
                    case 0:
                        label = new JLabel(emptyDot);
                        break;
                    case 1:
                        label = new JLabel(redDot);
                        break;
                    case 2:
                        label = new JLabel(yellowDot);
                        break;
                    default:
                        label = new JLabel(emptyDot);
                }
            
                label.setFont(new Font("Arial", Font.BOLD, 30));
                label.setHorizontalAlignment(JLabel.CENTER);
            
                add(label);
            }
        }
        
       
    }
    
    private ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
}