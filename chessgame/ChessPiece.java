/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import static chessgame.ChessGame.virtualChessBoard;
import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

/**
 *
 * @author Jordan
 */
public abstract class ChessPiece extends JLabel implements move {
    public static ArrayList chessPieces = new ArrayList();
    //myX myY are the initial position values of the array
    private int myX, myY, p;
    private final int sideOfPiece = 75;
    private int newX, newY;
    
    public ChessPiece(String name, int x, int y, int p)
    {
        super(name);
        myX = x;
        myY = y;
        this.p = p;
        
        this.setSize(new Dimension(75, 75));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //addMouseListener(this);
    }
    
    public int getmyX(){
        return myX;
    }
    public int getmyY(){
        return myY;
    }
    public void setmyX(int a){
        myX = a;
    }
    public void setmyY(int b){
        myY = b;
    }
    public final int getPlayer(){
        return p;
    }
    
    public void move(int a, int b){
        //just move to empty spot
    }
    public void killmove(int a, int b){
        //kill for pawn
    }
    public void checkValidMove(int a, int b){
        //check valid moves if available
    }
    public void movement(int x, int y){
        //actual movement 
        //this method is general to all the pieces
        //it only changes the position of piece
        if (virtualChessBoard[x][y].getOccupied() == true) {
            virtualChessBoard[x][y].getPiece().setVisible(false);
            System.out.println("Nailed it!");
        }
        //does the rest even though dest is not occupied
        virtualChessBoard[getmyX()][getmyY()].setOccupied(false);//set occupied false for the initial box
        setmyX(ChessGame.getDestinationX());
        setmyY(ChessGame.getDestinationY());//set the destination
        //I am not making the ChessBox occupied to false because the new object will move in
        
        try{
        virtualChessBoard[x][y].add(ChessGame.firstPiece);//add piece to box
        } 
        catch(Exception e){
            System.err.println(e);
        }
        virtualChessBoard[getmyX()][getmyY()].setOccupied(true);//set occupied
        virtualChessBoard[getmyX()][getmyY()].setPiece(this);//set piece in box
        ChessGame.firstPiece.setVisible(true);
        ChessGame.firstPiece = null;
    }
    
    public boolean sayOccupied(int a, int y){
        return virtualChessBoard[a][y].getOccupied() != false;
   }

   public void invalidMovement(){
        System.out.println("Out of the world 'cannot be moved' movement!");
        ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
        ChessGame.firstPiece = null;
   }
    
}
