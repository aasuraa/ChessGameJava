/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Jordan
 */
public class Rook extends ChessPiece {
    //Somehow grab the images that belongs to this class
    //hint says create set and get methods for location x and y, but they are already in ChessPiece
    //why would I need separate methods.
    
    public Rook(String name, int x, int y, int p)
    {
        super(name,x,y,p);
        this.setName(name);
        this.setText(name);
    }
    
    public void setWhiteIcon()
    {
        Icon wrook = new ImageIcon(getClass().getResource("wrook.jpg"));
        this.setIcon(wrook);
        
    }
    
    public void setBlackIcon()
    {
        Icon brook = new ImageIcon(getClass().getResource("brook.jpg"));
        this.setIcon(brook);
    }
    
    
    public String getName()
    {
        return super.getName();
    }
    
    public void move(int a, int b){
    }
}
