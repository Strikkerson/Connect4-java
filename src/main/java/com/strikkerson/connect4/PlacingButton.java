
package com.strikkerson.connect4;

import javax.swing.JButton;


public class PlacingButton extends JButton{
    public PlacingButton(){
        super("Jogar");
        setEnabled(false);
    }
    
    public PlacingButton(int numCol, Game game){
        super("Jogar");
        PlacingActionListener placingAL = new PlacingActionListener(numCol, game);
        
        addActionListener(placingAL);
    }
    
}
