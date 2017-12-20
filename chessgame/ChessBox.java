/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;
import static chessgame.ChessGame.virtualChessBoard;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    If it's clicked, is it empty??
    If yes, it asks you to select a box which is not empty.. meaning which is occupied
    After you select the non empty box, firstPiece is assigned
    
    I am trying to incorporate the player turn technique by counting the number of turns
    By convention the white goes first.. by racism too
    what a coincidence!!

    */
    public void firstSelect(){
        if(virtualChessBoard[boxX][boxY].getOccupied() == false){
            System.out.println("Select a piece first! Bitch!");
        
        } else {
         //if there is something in the box do this
         
         
                if(ChessGame.firstPiece == null){ //see if the firstPiece is occupied if not assign it
                    ChessGame.firstPiece = virtualChessBoard[boxX][boxY].getPiece();
                    //System.out.println(boxX +""+ boxY);
                    
                if(ChessGame.firstPiece.getPlayer() == ((ChessGame.countMove%2 )+1)){
                //using count static variable to determing the player piece chosen
                //if count is even ==> 0, gives 1, white goes
                //if count is odd  ==> 1, gives 2, black goes
                    
                    ChessGame.firstPiece.setVisible(false);

                    
                } //firstPiece is occupied
                else { //not player turn
                    ChessGame.virtualChessBoard[getBoxX()][getBoxY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                    ChessGame.firstPiece = null;
                    System.out.println("Not your turn.");
                }
            }
        
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
        if(ChessGame.firstPiece == null){
            //call the method that selects the piece first
            firstSelect();
        } else { 
            /*If the firstPiece is selected, see if the other box is selected
            If selected, but not occupied get there*/
            if(this.getOccupied() == false){ //move to empty spot
                //implements the move method of the piece
                ChessGame.firstPiece.move(boxX, boxY);
                //System.out.println("Box clicked1..var passed");
            } else { 
            /*there is something in the box come here
                move to not empty spot
                first see if it's the same player piece==> if yes, dont do it.. go back
                
              */
                //same player piece
                if(ChessGame.firstPiece.getPlayer() == this.getPiece().getPlayer()){ 
                    System.out.println("Cann't move there.");
                    ChessGame.virtualChessBoard[ChessGame.firstPiece.getmyX()][ChessGame.firstPiece.getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                    ChessGame.firstPiece = null;
                } else { //different player
                        ChessGame.firstPiece.move(boxX, boxY);             
                }
            }
        }
    }
    
    //ChessBox class not being abstract, all mouse click listener methods must be overridden
    @Override
    public void mouseExited(MouseEvent e)
    {
        
    }
    @Override
    public void mouseEntered(MouseEvent e)
    {
        
    }
    @Override
    public void mouseReleased(MouseEvent e)
    {
        
    }
    @Override
    public void mouseClicked(MouseEvent e)
    {
        
    }
} //End of ChessBox
