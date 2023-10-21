/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.strikkerson.connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Aluno
 */
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
