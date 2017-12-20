/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;
import static chessgame.ChessGame.virtualChessBoard;
import java.awt.*;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
/**
 *
 * @author Sagar
 */
public class Pawn extends ChessPiece {
   
    
    //private int myPX, myPY, player;
    public Pawn(String name,int x,int y, int player)
    {
        super(name,x,y, player);
    }
    
    public void setWhiteIcon()
    {
        Icon wpawn = new ImageIcon(getClass().getResource("wpawn.jpg"));
        this.setIcon(wpawn);
    }
    public void setBlackIcon()
    {
        Icon bpawn = new ImageIcon(getClass().getResource("bpawn.jpg"));
        this.setIcon(bpawn);
    }
    
    //movement for pawn
    //initial position is myX and myY 
    //p2,p1 rd,ld,ru,lu
    int[] horizontal = {0, 0, 1, -1, 1, -1};
    int[] vertical =   {-1, 1, 1, 1, -1, -1}; 
    
    /* To move diagonally when killing an enemy, you move left or right once and 
    up once
    This is where horizontal array comes handy
    it can kill diagonally only
    check the condition for movement and see if the space is occupied by opposite object
    you can probably use switch case structure, but this looks wayyyyyy cool
    */
    @Override
    public void move(int x, int y){//x and y are box values
        int a,b,c;
        if(ChessGame.firstPiece.getPlayer()==1) {
            a = 2;//player1
            b = 3;
            c = 1;
        } else { 
            a = 4;//player2
            b = 5;
            c = 0;
        }
        //if there is no player 2 pieces, it will only move forward
        //so has only 2 valid moves
        //it cannot move forward if there's another player piece
        if ((x == (getmyX()+ horizontal[c]))&&(y == (getmyY()+vertical[c]))&&(virtualChessBoard[x][y].getOccupied() == false)) {//forward movement only
            movement(x,y);
        } else if (((((x == (getmyX()+ horizontal[a]))&&(y == (getmyY()+vertical[a])))||((x == (getmyX()+ horizontal[b]))&&(y == (getmyY()+vertical[b]))))&&(virtualChessBoard[x][y].getOccupied() == true))) {
            movement(x,y);
        } else {    //this code runs if its not valid
            invalidMovement();
        }
    }
    
    
}
