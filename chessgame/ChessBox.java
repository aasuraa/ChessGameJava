/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;
import static chessgame.ChessGame.colorChessBoard;
import static chessgame.ChessGame.virtualChessBoard;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.util.ArrayList;
/**
 *
 * @author Jordan
 */
public class ChessBox extends JLabel implements MouseListener {
    //May be better to implement a Point object.
    //public Point location;
    private int locationx;
    private int locationy;
    private String name;
    private boolean isOccupied;
    
   private int boxX, boxY;
    private ChessPiece piece;
       
    
    public ChessBox(boolean occupy, int a, int y)
    {
        super("");
        boxX = a;
        boxY = y;
        occupy = isOccupied;
        addMouseListener(this);
        
    }
    public ChessBox(int x, int y, ChessPiece e){
        boxX = x;
        boxY = y;
        this.piece = e;
        if(e != null){
            setOccupied(true);
        } else {
            setOccupied(false);
        }
    }
    
    
    public void setPiece(ChessPiece e){
        this.piece = e;
        setOccupied(true);
    }
    public ChessPiece getPiece(){
        return piece;
    }
    
    
    public ChessBox(String name)
    {
        super(name);
        addMouseListener(this);
    }
    
    public ChessBox(String name, Icon icon)
    {
        super(name, icon, LEFT);
        addMouseListener(this);
    }
    public int getBoxX()
    {
        return boxX;
    }
    public int getBoxY()
    {
        return boxY;
    }
    public void setOccupied(Boolean state)
    {
        this.isOccupied = state;
    }
    public boolean getOccupied(){
        return isOccupied;
    }
    
    public void setLocationX(int i)
    {
        this.locationx = i;
    }
    
    public int getLocationX()
    {
        return locationx;
    }
    
    public void setLocationY(int i)
    {
        this.locationy = i;
    }
    
    public int getLocationY()
    {
        return locationy;
    }
    /*The following method checks if the box has been clicked
    If it's clicked, is it empty
    If yes, it asks you to select a box which is not empty.. meaning which is occupied
    After you select the non empty box, firstPiece is assigned*/
    public void firstSelect(){
        if(virtualChessBoard[boxX][boxY].getOccupied() == false){
            System.out.println("Select a piece first! Bitch!");
        
        } else { //if there is something in the box do this
            //System.out.println(ChessGame.firstPiece);
            if(ChessGame.firstPiece == null){ //see if the firstPiece is occupied if not assign it
                ChessGame.firstPiece = virtualChessBoard[boxX][boxY].getPiece();
                ChessGame.firstPiece.setVisible(false);
            } //firstPiece is occupied
            //System.out.println(ChessGame.firstPiece);
        }
    }
    public void mousePressed(MouseEvent e)
    {
        if(ChessGame.firstPiece == null){
            //call the method that selects the piece first
            firstSelect();
        } else { 
            /*If the firstPiece is selected, see if the other box is selected
            If selected, but not occupied get there*/
            if(this.getOccupied() == false){ //move to empty spot
                ChessGame.setXandY(boxX, boxY); //implements the move method of the piece
                //System.out.println("Box clicked1..var passed");
            } else { 
            /*there is something in the box come here
                move to not empty spot
                first see if it's the same player piece==> if yes, dont do it.. go back
                
              */
                //same player piece
                if(ChessGame.firstPiece.getPlayer() == this.getPiece().getPlayer()){ 
                    ChessGame.virtualChessBoard[ChessGame.firstPiece.getmyX()][ChessGame.firstPiece.getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                    ChessGame.firstPiece = null;
                } else { //different player
//                    ChessGame.setXandYKill(boxX, boxY);
                    //pawn has a slightly different movement from the rest
                    //so need to do this
                    if(ChessGame.firstPiece instanceof Pawn){
                        ChessGame.setXandYKill(boxX, boxY);
                        System.out.println("Pawn");
                    } else {
                        ChessGame.setXandY(boxX, boxY);
                    }
                    System.out.println("Box clicked2..var different player");
                }
//                System.out.println("Box clicked..var not passed");
            }
        }
    }
    
    
    public void mouseExited(MouseEvent e)
    {
        
    }
    
    public void mouseEntered(MouseEvent e)
    {
        
    }
    
    public void mouseReleased(MouseEvent e)
    {
        
    }
    
    public void mouseClicked(MouseEvent e)
    {
        
    }
} //End of ChessBox
