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
public class Queens extends ChessPiece {
    //Somehow grab the images that belongs to this class
    public Queens(String name, int x, int y, int p)
    {
        super(name,x,y,p);
        this.setName(name);
        this.setText(name);
    }
    
    public void setWhiteIcon()
    {
        Icon wking = new ImageIcon(getClass().getResource("wqueen.jpg"));
        this.setIcon(wking);
    }
    
    public void setBlackIcon()
    {
        Icon bking = new ImageIcon(getClass().getResource("bqueen.jpg"));
        this.setIcon(bking);
    }
    public void move(int a, int b){
    }
}





