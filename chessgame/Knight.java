/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;
import static chessgame.ChessGame.virtualChessBoard;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.*;
/**
 *
 * @author Sagar
 */
public class Knight extends ChessPiece {
    
    
    public Knight(String name,int x, int y, int player)
    {
        super(name,x,y, player);
        this.setName(name);
        this.setText(name);
    }

    public void setWhiteIcon()
    {
        Icon wknight = new ImageIcon(getClass().getResource("knight.jpg"));
        this.setIcon(wknight);
    }
    
    public void setBlackIcon()
    {
        Icon bknight = new ImageIcon(getClass().getResource("bknight.jpg"));
        this.setIcon(bknight);
    }

    //two one dimentional arrays with horizontal and vertical values
    //horizontal left and vertical up are neg.
    int[] horizontal = {1,-1, 2, -2, 2, 1,-1,-2};
    int[] vertical =   {2, 2, -1,-1, 1,-2,-2, 1};
    
    //declaring and initilizing the arrays
    //manual values to arrays
    //values are given by knowing the possible moves of the knight which totals 8
    //above are all the possible moves of the night
    
    

    @Override
    public void move(int x, int y){ //x and y are box values
        
        /*after the firstPiece is selected, we select a box which can be empty or occupied
        we make a switch statement with different values from the set of moves in arrays
        we see if it matches then move it
        */
        
        if (
        ((x==(getmyX()+horizontal[0]))&&(y==(getmyY()+vertical[0])))||
        ((x==(getmyX()+horizontal[1]))&&(y==(getmyY()+vertical[1])))||
        ((x==(getmyX()+horizontal[2]))&&(y==(getmyY()+vertical[2])))||
        ((x==(getmyX()+horizontal[3]))&&(y==(getmyY()+vertical[3])))||
        ((x==(getmyX()+horizontal[4]))&&(y==(getmyY()+vertical[4])))||
        ((x==(getmyX()+horizontal[5]))&&(y==(getmyY()+vertical[5])))||
        ((x==(getmyX()+horizontal[6]))&&(y==(getmyY()+vertical[6])))||
        ((x==(getmyX()+horizontal[7]))&&(y==(getmyY()+vertical[7])))
        ) {
            movement(x,y);
        } else {    //this code runs if its not valid
            System.out.println("Invalid movement.");
            ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
            ChessGame.firstPiece = null;
        }
       
    }

}
