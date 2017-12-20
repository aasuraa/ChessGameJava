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
public abstract class ChessPiece extends JLabel implements move, validMove {
    public static ArrayList chessPieces = new ArrayList();
    //myX myY are the initial position values of the array
    private int myX, myY, p;
    private final int sideOfPiece = 75;
    private int newX, newY;
    private String name;
    
    public ChessPiece(String name, int x, int y, int p)
    {
        super(name);
        this.name =  name;
        myX = x;
        myY = y;
        this.p = p;
        
        this.setSize(new Dimension(75, 75));
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        //addMouseListener(this);
    }
    
    public String getName(){
        return name;
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
    public int getPlayer(){
        return p;
    }
    
    public void move(int a, int b){
        //just move to empty spot
    }
    public void killmove(int a, int b){
        //kill for pawn
    }
    public void movement(int x, int y){
        //actual movement 
        //this method is general to all the pieces
        //it only changes the position of piece, calculation is done within the specific piece
        if (virtualChessBoard[x][y].getOccupied() == true) {
            if(virtualChessBoard[x][y].getPiece() instanceof King){
                //king dies the game is over
                //we can put the celebration code here
                
                virtualChessBoard[x][y].getPiece().setVisible(false);
                System.out.printf("Nailed it by %s%n", ChessGame.firstPiece.getName());
                
                System.out.println("You win!!");
            } else { 
                virtualChessBoard[x][y].getPiece().setVisible(false);
                System.out.printf("Nailed it by %s%n", ChessGame.firstPiece.getName()); //gives which piece gets the kill
            }
        }
        //does the rest even though dest is not occupied
        virtualChessBoard[getmyX()][getmyY()].setOccupied(false);//set occupied false for the initial box
//        setmyX(ChessGame.getDestinationX());
//        setmyY(ChessGame.getDestinationY());//set the destination
        setmyX(x);
        setmyY(y);
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
        ChessGame.countMove++;
    }

    public void checkValidMove(){
        /*check valid moves if available
        First Piece is selected.
        Then based on it's calculation for moves, the valid area will be highlighted.
        this method call should take place before move method call*/

    }
    
    public boolean sayOccupied(int a, int b){ 
        return virtualChessBoard[a][b].getOccupied() != false;
   }

   public void invalidMovement(){
        System.out.println("Out of the world 'cannot be moved' movement!");
        ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
        ChessGame.firstPiece = null;
   }
    
}
