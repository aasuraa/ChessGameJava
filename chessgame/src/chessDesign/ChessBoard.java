 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessDesign;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/**
 *
 * @author Sagar
 */
public class ChessBoard extends JPanel implements MouseListener
{
    
    final private int sizeOfGameBoard = 600;
//    final private int sizeOfSquares = 75;
//    final private int startOfSideOfBoard = 100;
//    final private int startOfTopOfBoard = 50;
    
    public void mouseClicked(MouseEvent e)
    {
        
    }
    public void mousePressed(MouseEvent e)
    {
        
    }
    
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    public void mouseReleased(MouseEvent e)
    {
        
    }
    public void mouseExited(MouseEvent e)
    {
        
    }
    public ChessBoard()
    {
        super();
        this.setLayout(new BorderLayout(8,8));
        this.setSize(new Dimension(sizeOfGameBoard, sizeOfGameBoard));
        
        //Sets posistion of Top Left Corner of the JPanel in the JFrame
        this.setLocation(100, 50);
    }
    
}
