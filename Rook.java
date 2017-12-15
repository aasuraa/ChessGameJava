/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import static chessgame.ChessGame.virtualChessBoard;
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
    
    public Rook(String name, int x, int y, int player)
    {
        super(name,x,y,player);
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
    
    /*The movement of rook is actually very easy, It can move STRAIGHT so, no set of values required
    So first, see if it's moving up or down, or left or right. We can compare the destination and initial
    position values for this
    Then see if anything in between the position is occupied or not which is important can it can't jump unlike knight
    For this, compare destination and initial values then add or sub in the loop
    if not occupied move, If occupied invalid movement
    If it moves, see the destination is occupied or not
    */
   
   public void rookMove(int x, int y){
        if (virtualChessBoard[x][y].getOccupied() == true) {
            virtualChessBoard[x][y].getPiece().setVisible(false);
            System.out.println("Nailed it by rook!");
        }
        //does the rest even though dest is not occupied
        virtualChessBoard[getmyX()][getmyY()].setOccupied(false);//set occupied false for the initial box
        setmyX(ChessGame.getDestinationX());
        setmyY(ChessGame.getDestinationY());//set the destination
        
        virtualChessBoard[x][y].add(ChessGame.firstPiece);//add piece to box
        virtualChessBoard[getmyX()][getmyY()].setOccupied(true);//set occupied 
        virtualChessBoard[getmyX()][getmyY()].setPiece(this);//set piece in box
        ChessGame.firstPiece.setVisible(true);
        ChessGame.firstPiece = null;
   }
   
   public boolean sayOccupied(int a, int y){
       if (virtualChessBoard[a][y].getOccupied() == false) {
           return false;
       } else {
           return true;
       }
   }
    
    public void move(int x, int y){
        //see if the destination
        ////x is if it moves verticaclly and y for horizontal movement
        if ((x == getmyX())||(y == getmyY())) { //is there movement
            
            if(y == getmyY()){//for horizontal movement
                System.out.println("moving horizontal");
                if (x > getmyX()) {//if destination is greater than int, dest is greater
                    boolean[] check = new boolean[(x - getmyX())]; //false at first
                    System.out.println("heyy1");
                    if((x - getmyX()) > 1){ //if it's not the adjacent piece
                        int i = (getmyX()+1);
                        int checkNo = 0;
                        while(i<x){
                            System.out.println(i);
                            System.out.println(check[checkNo] = sayOccupied(i, y));
                            i++;
                            checkNo++;
                        }
                        
                        
//                        for (int i = (getmyX()+1); i < x; i++) { //we add one so it doesn't checks it's own position
//                            System.out.println(i);
//                            if (virtualChessBoard[i][y].getOccupied() == false) { //if the boxes in between is not occupied
//                                
//                                
//                            } else {
//                                System.out.println("Rook can't jump pieces.");
//                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
//                                ChessGame.firstPiece = null;
//                            }
//                        }
                    } else {
                        rookMove(x, y);
                    }
                } else { //dest is smaller
                    System.out.println("heyy2");
                    if(getmyX()-1 > 1){ //if it's not the adjacent piece
                        for (int i = (getmyX()-1); i > x; i--) { //we add one so it doesn't checks it's own position
                            System.out.println(i);
                            if (virtualChessBoard[i][y].getOccupied() == false) { //if the boxes in between is not occupied
                                rookMove(x, y);
                            } else {
                                System.out.println("Rook can't jump pieces.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
                            }
                        }
                    } else {
                        rookMove(x, y);
                    }
                }
            } else {//comparing destX and x for horizontal movemet
                System.out.println("heyx");
                if (y > getmyY()) {//if destination is greater than int
                    for (int i = getmyY()+1; i < y; i++) {
                        System.out.println(i);
                    }
                } else {
                    for (int i = getmyY()-1; i > x; i--) {
                        System.out.println(i);
                    }
                }

            }
            
        } else { 
            System.out.println("Invalid movement!");
        }
    }
}
