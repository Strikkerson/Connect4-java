package com.strikkerson.connect4;

import java.util.ArrayList;




public class Game{
    private final int[][] board;
    private final Frame frame;
    private int currentPlayerNumber;
    
    public Game(Frame frame) {
        this.frame = frame;
        this.board = new int[6][7];
    }
    
    public void startGame(){
        frame.loadGameScreen(board, setupButtons());
        currentPlayerNumber = 1;
    }    
            
    public PlacingButton[] setupButtons(){    
       PlacingButton[] buttons = new PlacingButton[7];
       
       for(int i=0; i<7;i++){
           buttons[i] = new PlacingButton(i, this);
       }
       
       return buttons;
    }
    
    
    public void makePlay(int numCol){
        for(int i = 5; i>=0;i--){
            if(board[i][numCol] == 0){
                board[i][numCol] = currentPlayerNumber;
                break;
            }
        }
        if(currentPlayerNumber == 1) currentPlayerNumber = 2;
        else currentPlayerNumber = 1;
        
        if(verifyWin(board)) return; 
        frame.loadGameScreen(board, setupButtons());
        
    }
    
    public boolean verifyWin(int[][] board){
        boolean player1Win = false;
        boolean player2Win = false;
        
        
        ArrayList<Integer[]> lines = getLines(board);
        
        int result = checkConnect4(lines);
     
        if(result == 1) player1Win = true;
        else if(result == 2) player2Win = true;
        
        if(player1Win || player2Win){
            if(player1Win){ 
                frame.loadWinScreen(1, board);
                //frame.loadGameScreen(board, setupButtons());
            }else{ 
                frame.loadWinScreen(2, board);
                //frame.loadGameScreen(board, setupButtons());
            }
            
        }
        
        return player1Win || player2Win;
    }
    
    private Integer[] getDiagonalAsArray(int[][] board, int startLine, boolean isToUp, boolean isToRight){
        ArrayList<Integer> diagonal = new ArrayList<>();
        int j;
        int i = startLine;
        int endLine;
        
        
        if(isToRight) j = 0; 
        else j = 6;
        
        if(isToUp) endLine = 0;
        else endLine = 5;
        
        if(startLine == endLine){
            diagonal.add(board[endLine][j]);
            return diagonal.toArray(new Integer[diagonal.size()]);
        }
        
        do{
            diagonal.add(board[i][j]);
            
            if(isToUp) i--;
            else i++;
            
            if(isToRight) j++;
            else j--;
            
        }while((i != endLine+1 && !isToUp) || (i != endLine-1 && isToUp));
        
        return diagonal.toArray(new Integer[diagonal.size()]); 
    }
    
    public int checkConnect4(ArrayList<Integer[]> lines){
        
        for(Integer[] line : lines){
            int[] count = {0, 0};
            
            for(Integer num : line){
               if(num > 0) count[num-1]++;

               if(count[0] > 0 && num != 1) count[0] = 0;
               if(count[1] > 0 && num!= 2) count[1] = 0;

               if(count[0] == 4){
                   return 1;
               }

               if(count[1] == 4){
                   return 2;
               }
           }
        }
        
        return 0;
    }
    
    public ArrayList<Integer[]> getLines(int board[][]){
        
        ArrayList<Integer[]> lines = new ArrayList<>();
        for(int i = 0; i<6;i++){
            Integer[] boardRow = new Integer[board[i].length];
            for(int j = 0; j<7; j++){
                boardRow[j] = board[i][j];
            }
            
            lines.add(getDiagonalAsArray(board, i, true, true));
            lines.add(getDiagonalAsArray(board, i, false, true));
            lines.add(getDiagonalAsArray(board, i,false, false));
            lines.add(getDiagonalAsArray(board, i, true, false));
            lines.add(boardRow);
            
        }
        
        for(int j = 0; j<7; j++){
            Integer[] boardCol = new Integer[6];
        
            for(int i = 0; i<6; i++){
                boardCol[i] = board[i][j];
            }
            
            lines.add(boardCol);
        }
        
        return lines;
    }
}
