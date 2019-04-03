/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPiece;

import main.ChessGame;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Sagar
 */
public class Queen extends Rook {
    //Somehow grab the images that belongs to this class
    public Queen(String name, int x, int y, int p)
    {
        super(name,x,y,p);
        this.setName(name);
        this.setText(name);
    }
    
    public void setWhiteIcon()
    {
        Icon wqueen = new ImageIcon(getClass().getResource("../piecePic/wking.jpg")); //The picture was named differently. LOL Jordan :P
        this.setIcon(wqueen);
    }
    
    public void setBlackIcon()
    {
        Icon bqueen = new ImageIcon(getClass().getResource("../piecePic/bking.jpg"));
        this.setIcon(bqueen);
    }
    
    /*Because I am lazy, I am just copying the code
    The other way to do this will be to make rook and Bishop implement the movements somehow*/
    
//    @Override
    public void move(int x, int y){
        
        try{
        if((x == getmyX())||
           (y == getmyY())){
            super.move(x, y);
        } else {
//                
           if(((getmyY()-y)==(x-getmyX()))||
           ((getmyY()-y)==(getmyX()-x))||
           ((y-getmyY())==(x-getmyX()))||
           ((y-getmyY())==(getmyX()-x))
           ){
        //bishop move
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
                                System.out.println("Invalid Movement.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
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
                                System.out.println("Invalid Movement.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
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
                                System.out.println("Invalid Movement.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
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
                                System.out.println("Invalid Movement.");
                                ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
                                ChessGame.firstPiece = null;
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
        } //else {
//            System.out.println("Invalid movement.");
//            ChessGame.virtualChessBoard[getmyX()][getmyY()].add(ChessGame.firstPiece).setVisible(true);//makes it comeback
//            ChessGame.firstPiece = null;
//        }
    }
     else {
        invalidMovement();
    }
        }
  }
    
    catch(Exception e) {
        
        System.err.println(e);
    }
    }
}
