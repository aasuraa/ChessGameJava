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
public class Bishop extends ChessPiece {
    //Somehow grab the images that belongs to this class
    public Bishop(String name, int x, int y, int p)
    {
        super(name, x,y,p);
        this.setName(name);
        this.setText(name);
    }
    
    public void setWhiteIcon()
    {
       Icon wbishop = new ImageIcon(getClass().getResource("wbishop.jpg"));
       this.setIcon(wbishop);
    }
    
    public void setBlackIcon()
    {
        Icon bbishop = new ImageIcon(getClass().getResource("bbishop.jpg"));
        this.setIcon(bbishop);
    }
    public void move(int a, int b){
    }
}
