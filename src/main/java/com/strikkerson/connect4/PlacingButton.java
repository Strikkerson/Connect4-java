/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.strikkerson.connect4;

import java.awt.event.ActionEvent;
import javax.swing.JButton;

/**
 *
 * @author Aluno
 */
public class PlacingButton extends JButton{
    public PlacingButton(){
        super("Jogar");
        setEnabled(false);
    }
    
    public PlacingButton(int numCol, Game game){
        super("Jogar");
        
        addActionListener((ActionEvent e) -> game.makePlay(numCol));
    }
    
}
