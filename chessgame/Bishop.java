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

    /* V1. The movement of bishop is somewhat tricky. First, it's like rook but hey! Diagonal.
    So there can be 4 ways. Up and right, Up and left, Down and right, Down and left.
    To check these movement first, we compare the initial x and y values to the final x and y values.
    For up and right:   y decreases and x increases
    For up and left:    y decreases and x decreases
    For down and right: y increases and x increases
    For down and left:  y increases and x decreases
    So, there will be 4 parts to this movement like the Rooks(Rook was coded before this)
    Compare the y values first(gives if it moves up or down)
    Compare the x values second(gives the left or right)
    Then, See if there's anything inbetween. Come with an equation. Move.
    */
   
    @Override
    public void move(int x, int y){
        if(((getmyY()-y)==(x-getmyX()))||
           ((getmyY()-y)==(getmyX()-x))||
           ((y-getmyY())==(x-getmyX()))||
           ((y-getmyY())==(getmyX()-x))){ // see if there's a movement
            
            //checking the y values for up or down movement
            if (y<getmyY()) { //if y is smaller than getmyY(), it moves up
               //check if it moves left or right while moving up
                if (x>getmyX()) { //if x is greater, it moves right
                    if((x-getmyX()) > 1){
                        int i = (getmyX()+1);//shift to the right adjacent box
                        int j = (getmyY()-1);
                        int arrayFalse = 0;

                        while(i<x){
                            //System.out.println(i);
                            if (sayOccupied(i,j)==false) {
                                arrayFalse++;
                                i++;j--;
                                continue;//iterates the next iteration
                            }
                            if (sayOccupied(i,j)==true) {
                                invalidMovement();
                                break; //if the first is occupied, break there
                            }
                        }

                        if(arrayFalse == (x-(getmyX()+1))){
                            //movement code
                            movement(x,y);
                        }
                    } else { //adjacent piece
                        movement(x,y);
                    }
                } else { //if x is smaller, it moves left
                    if((getmyX()-x) > 1){
                        int i = (getmyX()-1);//shift to the right adjacent box
                        int j = (getmyY()-1);
                        int arrayFalse = 0;

                        while(i>x){
                            //System.out.println(i);
                            if (sayOccupied(i,j)==false) {
                                arrayFalse++;
                                i--;j--;
                                continue;//iterates the next iteration
                            }
                            if (sayOccupied(i,j)==true) {
                                invalidMovement();
                                break; //if the first is occupied, break there
                            }
                        }

                        if(arrayFalse == (getmyX()-(x+1))){
                            //movement code
                            movement(x,y);
                        }
                    } else { //adjacent piece
                        movement(x,y);
                    }
                }   
            } else { //if y is greater than getmyY(), it moves down
                //check if it moves left or right while moving up
                if (x>getmyX()) { //if x is greater, it moves right
                    if((x-getmyX()) > 1){
                        int i = (getmyX()+1);//shift to the right adjacent box
                        int j = (getmyY()+1);
                        int arrayFalse = 0;

                        while(i<x){
                            //System.out.println(i);
                            if (sayOccupied(i,j)==false) {
                                arrayFalse++;
                                i++;j++;
                                continue;//iterates the next iteration
                            }
                            if (sayOccupied(i,j)==true) {
                                invalidMovement();
                                break; //if the first is occupied, break there
                            }
                        }

                        if(arrayFalse == (x-(getmyX()+1))){
                            //movement code
                            movement(x,y);
                        }
                    } else { //adjacent piece
                        movement(x,y);
                    }
                } else {
                    if((getmyX()-x) > 1){
                        int i = (getmyX()-1);//shift to the left adjacent box
                        int j = (getmyY()+1);
                        int arrayFalse = 0;

                        while(i>x){
                            //System.out.println(i);
                            if (sayOccupied(i,j)==false) {
                                arrayFalse++;
                                i--;j++;
                                continue;//iterates the next iteration
                            }
                            if (sayOccupied(i,j)==true) {
                                invalidMovement();
                                break; //if the first is occupied, break there
                            }
                        }

                        if(arrayFalse == (getmyX()-(x+1))){
                            //movement code
                            movement(x,y);
                        }
                    } else { //adjacent piece
                        movement(x,y);
                    }
                }
            }
        } else {
            invalidMovement();
        }
    }
}
