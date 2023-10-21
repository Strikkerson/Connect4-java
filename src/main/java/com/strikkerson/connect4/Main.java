package com.strikkerson.connect4;


public class Main {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Game game = new Game(frame);
        
        game.startGame();
    }
}