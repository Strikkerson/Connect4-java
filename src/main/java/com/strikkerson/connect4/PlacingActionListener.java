package com.strikkerson.connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PlacingActionListener implements ActionListener{
    public int numCol;
    public Game game;
    
    public PlacingActionListener(int numCol, Game game){
       this.numCol = numCol;
       this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.makePlay(numCol);
    }
}
