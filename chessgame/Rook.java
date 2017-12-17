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
 * @author Sagar
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

    /*The movement of rook is actually very easy, It can move STRAIGHT so, no set of movement values required
    So first, see if it's moving up or down, or left or right. We can compare the destination and initial
    position values for this
    Then see if anything in between the position is occupied or not which is important 'cause it can't jump like knight
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
        return virtualChessBoard[a][y].getOccupied() != false;
   }

   @Override
    public void move(int x, int y){
        //see if the destination
        ////x is if it moves verticaclly and y for horizontal movement
        if ((x == getmyX())||(y == getmyY())) { //is there movement

            if(y == getmyY()){
            //for horizontal movement we have left or right movement
                //System.out.println("moving horizontal");
                if (x > getmyX()) {//if destination is greater than int, moving right
                    //System.out.println("heyy1");
                    if((x - getmyX()) > 1){ //if it's not the adjacent piece
                        int i = (getmyX()+1); //adjacent box
                        int arrayFalse = 0;
                        /*Okay! done so far. Now I got stuck in here for some thime, not longer than knight or pawn tho
                           I wasn't able to check the occupied values directly. So first, I thought of creating an array that
                            would hold the values and check but it got complicated. So, I thought maybe I could compare an int with
                            empty boxes. Guess what it worked!
                        */
                            while(i<x){ //just put values in there
                                //System.out.println(i);
                                if (sayOccupied(i,y)==false) {
                                    arrayFalse++;
                                    i++;
                                    continue; //iterates the next iteration
                                }
                                if (sayOccupied(i,y) == true) {
                                    System.out.println("Rook can't jump pieces.");
                                    ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                    ChessGame.firstPiece = null;
                                    break; //if the first is occupied, break there
                                }
                            }
                        /*if the number of false values is equal to the number of box inbetween then the rook is free to move in that direction*/
                        if(arrayFalse == (x-(getmyX()+1))){
                            rookMove(x,y);
                        }

                    } else { //one step
                        rookMove(x, y);
                    }
                } else { //dest is smaller
                if(x<getmyX()){ //moving left
                    //System.out.println("heyy2");
                    if(getmyX()- x > 1){ //if it's not the adjacent piece
                        int i = (getmyX()-1);
                        int arrayFalse = 0;
                        while(i>x){
                            //System.out.println(i);
                            if (sayOccupied(i,y)==false) {
                                arrayFalse++;
                                i--;
                                continue;
                            }
                            if (sayOccupied(i,y)==true) {
                                System.out.println("Rook can't jump pieces.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);
                                ChessGame.firstPiece = null;
                                break;
                            }
                        }
                      /*if the number of false values is equal to the number of box inbetween then the rook is free to move in that direction*/
                        if(arrayFalse == (getmyX()-(x+1))){
                              rookMove(x,y);
                      }

                    } else { //one step
                        rookMove(x, y);
                    }
                }
              }
                /* Now the code for movement. The vertical movement if found if there is
                change in value y. It can be moving up or moving down. There is not a lot
                to code 'cause we already have the structure. So, only the equation can be a challange*/
            } else {//comparing destX and x for horizontal movement

                System.out.println("hey");
                if (y > getmyY()) {//if destination is greater than int, moving down
                    if((y-getmyY())>1){ // if not the adjacent piece
                        int i = (getmyY()+1);
                        int arrayFalse = 0;
                        while(i<y){
                            if(sayOccupied(x,i) == false){
                                arrayFalse++;
                                i++;
                                continue;
                            }
                            if(sayOccupied(x,i) == true){
                                System.out.println("Rook can't jump pieces.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
                                break; //if the first is occupied, break there
                            }
                        }
                        if(arrayFalse == (y-(getmyY()+1))){
                            rookMove(x,y);
                        }
                    } else {
                      rookMove(x,y);
                    }
                } else { //destination is smaller, moving up
                    if((getmyY()-y)>1){ // if not the adjacent piece
                        int i = (getmyY()-1);
                        int arrayFalse = 0;
                        while(i>y){
                            //System.out.println(i);
                            if(sayOccupied(x,i) == false){
                                arrayFalse++;
                                i--;
                                continue;
                            }
                            if(sayOccupied(x,i) == true){
                                System.out.println("Rook can't jump pieces.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
                                break; //if the first is occupied, break there
                            }
                        }
                        if(arrayFalse == (getmyY()-(y+1))){
                            rookMove(x,y);
                        }
                    } else {
                      rookMove(x,y);
                    }
                }
            }

        } else {
            System.out.println("Invalid movement!");
        }
    }
}
