/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

/**
 *
 * @author sagar
 */
public interface move {
    
    public void move(int a, int b); //calculation for movement
    
    public void movement(int x, int y); //does the actual swap
    
    public boolean sayOccupied(int a, int y); //used for rook, bishop, queen to determine the way
    
}
