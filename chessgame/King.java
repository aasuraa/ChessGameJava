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
 * @author Sagar
 */
public class King extends ChessPiece {
    //Somehow grab the images that belongs to this class
    public King(String name, int x, int y, int p)
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
    
    /*The king has 1 step any directional movement, similar to of pawn but easier.
    You can basically move to any adjacent square unless there is own team piece.
    */
    @Override
    public void move(int x, int y){
        //the movement for king in any direction can be following
        int[] horizontal = {-1, 1, -1, 0, 1, -1, 0, 1};
        int[] vertical =   {0, 0, 1, 1, 1, -1, -1, -1};
        
        if(
        ((x==(getmyX()+horizontal[0]))&&(y==(getmyY()+vertical[0])))||
        ((x==(getmyX()+horizontal[1]))&&(y==(getmyY()+vertical[1])))||
        ((x==(getmyX()+horizontal[2]))&&(y==(getmyY()+vertical[2])))||
        ((x==(getmyX()+horizontal[3]))&&(y==(getmyY()+vertical[3])))||
        ((x==(getmyX()+horizontal[4]))&&(y==(getmyY()+vertical[4])))||
        ((x==(getmyX()+horizontal[5]))&&(y==(getmyY()+vertical[5])))||
        ((x==(getmyX()+horizontal[6]))&&(y==(getmyY()+vertical[6])))||
        ((x==(getmyX()+horizontal[7]))&&(y==(getmyY()+vertical[7])))
        ){
            movement(x,y);
        } else {    //this code runs if its not valid
            invalidMovement();
        }
        
    }
}
