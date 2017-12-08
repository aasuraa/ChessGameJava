/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.*;
/**
 *
 * @author Jordan
 */
public class Knight extends ChessPiece {
    
    //two one dimentional arrays with horizontal and vertical values
    //horizontal left and vertical up are neg.
    int[] horizontal = {2,1,-1,-2,-2,-1,1,2};
    int[] vertical =   {-1,-2,-2,-1,1,2,2,1};
    //declaring and initilizing the arrays
    //manual values to arrays
    //values are given by knowing the possible moves of the knight which totals 8
    //above are all the possible moves of the night
    
    public void move(int desx, int desy){
        
    }
    public Knight(String name,int x, int y, int p)
    {
        super(name,x,y, p);
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
    
    
    
    
}
