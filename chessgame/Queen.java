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
public class Queen extends ChessPiece {
    //Somehow grab the images that belongs to this class
    public Queen(String name, int x, int y, int p)
    {
        super(name,x,y,p);
        this.setName(name);
        this.setText(name);
    }
    
    public void setWhiteIcon()
    {
        Icon wqueen = new ImageIcon(getClass().getResource("wqueen.jpg"));
        this.setIcon(wqueen);
    }
    
    public void setBlackIcon()
    {
        Icon bqueen = new ImageIcon(getClass().getResource("bqueen.jpg"));
        this.setIcon(bqueen);
    }
    public void move(int a, int b){
    }
}
