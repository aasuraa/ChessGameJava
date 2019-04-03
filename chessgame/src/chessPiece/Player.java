/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessPiece;

import chessDesign.*;

/**
 *
 * @author Sagar
 */
public class Player {
    
   private boolean isTurn = false;
   private int player;
   private final ChessPiece[] playerPiecesArray = new ChessPiece[16];
    
    public Player()
    {
        
    }
    
    public void swapTurn()
    {
        if(isTurn == false) {
            isTurn = true;
        }
        if(isTurn == true) {
            isTurn = false;
        }
    }
    
    

}
