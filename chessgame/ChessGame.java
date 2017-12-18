/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Jordan
 */

//there is somehow a problem in this with the last square covering the screen
//have group members analyze code.

public class ChessGame extends JFrame
{

    //ChessGame extends JFrame and thereofore creates and JFrame (a window)
    //and opens one with the settings giving in the constucture.
    public ChessGame()
    {
        setTitle("ChessGame");
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    static ChessBoard chessBoard = new ChessBoard();
    static ChessBox[][] virtualChessBoard = new ChessBox[8][8];
//    public static ChessPiece[] player1Pieces = new ChessPiece[16];
//    public static ChessPiece[] player2Pieces = new ChessPiece[16];
    public static ChessPiece firstPiece;
//    public static String isTurn = "1";

    public static int countMove = 0;



    public static void main(String[] args) {

        //These are variables to contain the location where the board starts.
        int startOfSideOfBoard = 100;
        int startOfTopOfBoard = 50;


        //This creates the ChessGame window (it extends JFrame)
        ChessGame frame = new ChessGame();


        //This creates all new chessbox objects in side the 2D array virtualChessBox
        for(int i = 0; i < 8; i ++)
        {
            for(int j = 0; j < 8; j++)
            {
                virtualChessBoard[i][j] = new ChessBox(false,i,j);
            }
        }


        //This is where things get confusing. I'm attempting to name the squares with a row and column identifier
        //but I think there's a different way. The most important part is the setLocationX method (i believe).
        for(int i = 0; i < 8; i ++)
        {
            int move = 100;
            for(int x = 0; x < 8; x++)
            {
                virtualChessBoard[i][x].setLocationX(move);
                move += 75;
            }
        }

        //And I think that this is where I set the Y locations of the ChessBox's in the array.
         for(int i = 0; i < 8; i ++)
        {
            int move = 50;
            for(int x = 0; x < 8; x++)
            {
                virtualChessBoard[x][i].setLocationY(move);
                move += 75;
            }
        }

        //This loop creates the boxes using the location setting set above
        for(int i = 0; i < 8; i++)
        {
            for(int x = 0; x < 8; x++)
            {
                virtualChessBoard[x][i].setLocation(virtualChessBoard[i][x].getLocationX(), virtualChessBoard[i][x].getLocationY());
                virtualChessBoard[x][i].setSize(new Dimension(75, 75));
                virtualChessBoard[x][i].setBorder(BorderFactory.createLineBorder(Color.black));
                virtualChessBoard[x][i].setOpaque(true);
                chessBoard.add(virtualChessBoard[x][i]);
                }
        }




        //This next code somehow fixes an issue with the plast ChessBox not appearing in place.
        ChessBox blankBox = new ChessBox("");
        blankBox.setSize(new Dimension(75, 75));
        chessBoard.add(blankBox);

        //This places the pieces in their starter positions
        initiatePieces();
        //Color the squares of the board
        colorChessBoard();

        //activate player one pieces
//        activatePlayerOnePieces();
//        deactivatePlayerTwoPieces();


        //this addes the chessBoard JPanel to the window
        frame.add(chessBoard);
        //this has something to do with the postioning -\0_0/- if you get rid of it the squares disappear.
        frame.revalidate();
    }


//trying to figure out what to do here.
    public static void initiatePieces()
    {
       //name, x, y, player
        //Place Player1 rooks
        Rook Player1Rook1 = new Rook("P1 Rook1", 0, 0,1);
        Player1Rook1.setWhiteIcon();

        virtualChessBoard[0][0].add(Player1Rook1);
        virtualChessBoard[0][0].setOccupied(true);
        //virtualChessBoard[0][0].new ChessBox(0,0, Player1Rook1);
        virtualChessBoard[0][0].setPiece(Player1Rook1);

//        player1Pieces[0] = Player1Rook1;

        Rook Player1Rook2 = new Rook("P1 Rook2", 7, 0,1);
        Player1Rook2.setWhiteIcon();

        virtualChessBoard[7][0].add(Player1Rook2);
        virtualChessBoard[7][0].setOccupied(true);
        virtualChessBoard[7][0].setPiece(Player1Rook2);

//        player1Pieces[1] = Player1Rook2;

        // //Place Player2 rooks
        Rook Player2Rook1 = new Rook("P2 Rook1",0,7,2);
        Player2Rook1.setBlackIcon();

        virtualChessBoard[0][7].add(Player2Rook1);
        virtualChessBoard[0][7].setOccupied(true);

        virtualChessBoard[0][7].setPiece(Player2Rook1);


        //Place Player2 rooks
       
//        player2Pieces[0] = Player2Rook1;

        Rook Player2Rook2 = new Rook("P2 Rook2",7,7,2);
        Player2Rook2.setBlackIcon();

        virtualChessBoard[7][7].add(Player2Rook2);
        virtualChessBoard[7][7].setOccupied(true);

        virtualChessBoard[7][7].setPiece(Player2Rook1);

//        player2Pieces[1] = Player2Rook2;

        //Place Player1 knights
        Knight player1Knight1  = new Knight("P1 Knight1",1,0,1);
        player1Knight1.setWhiteIcon();

        virtualChessBoard[1][0].add(player1Knight1);
        virtualChessBoard[1][0].setOccupied(true);
        virtualChessBoard[1][0].setPiece(player1Knight1);

//        player1Pieces[2] = player1Knight1;

        Knight Player1Knight2 = new Knight("P1 Knight2",6,0,1);
        Player1Knight2.setWhiteIcon();
        virtualChessBoard[6][0].add(Player1Knight2);
        virtualChessBoard[6][0].setOccupied(true);
        virtualChessBoard[6][0].setPiece(Player1Knight2);

//        player1Pieces[3] = Player1Knight2;

//        //Place Player2 knights
        Knight Player2Knight1 = new Knight("P2 Knight1",1,7,2);
        Player2Knight1.setBlackIcon();
        virtualChessBoard[1][7].add(Player2Knight1);
        virtualChessBoard[1][7].setOccupied(true);
        virtualChessBoard[1][7].setPiece(Player2Knight1);


//        player2Pieces[2] = Player2Knight1;

        Knight Player2Knight2 = new Knight("P2 Knight2",6,7,2);
        Player2Knight2.setBlackIcon();
        virtualChessBoard[6][7].add(Player2Knight2);
        virtualChessBoard[6][7].setOccupied(true);
        virtualChessBoard[6][7].setPiece(Player2Knight2);

//        player2Pieces[3] = Player1Knight2;

        //Place Player1 bishops
        Bishop Player1Bishop1 = new Bishop("P1 Bishop1",2,0,1);
        Player1Bishop1.setWhiteIcon();
        virtualChessBoard[2][0].add(Player1Bishop1);
        virtualChessBoard[2][0].setOccupied(true);
        virtualChessBoard[2][0].setPiece(Player1Bishop1);

//        player1Pieces[4] = Player1Bishop1;

        Bishop Player1Bishop2 = new Bishop("P1 Bishop2",5,0,1);
        Player1Bishop2.setWhiteIcon();
        virtualChessBoard[5][0].add(Player1Bishop2);
        virtualChessBoard[5][0].setOccupied(true);
        virtualChessBoard[5][0].setPiece(Player1Bishop2);

//        player1Pieces[5] = Player1Bishop2;

        //Place Player2 bishops
        Bishop Player2Bishop1 = new Bishop("P2 Bishop1",2,7,2);
        Player2Bishop1.setBlackIcon();
        virtualChessBoard[2][7].add(Player2Bishop1);
        virtualChessBoard[2][7].setOccupied(true);
        virtualChessBoard[2][7].setPiece(Player2Bishop1);

//        player2Pieces[4] = Player2Bishop1;

        Bishop Player2Bishop2 = new Bishop("P2 Bishop2",5,7,2);
        Player2Bishop2.setBlackIcon();
        virtualChessBoard[5][7].add(Player2Bishop2);
        virtualChessBoard[5][7].setOccupied(true);
        virtualChessBoard[5][7].setPiece(Player2Bishop2);

//        player2Pieces[5] = Player2Bishop2;

        //Place Player1 Queen
        Queens Player1Queen = new Queens("P1 Queen",4,0,1);
        Player1Queen.setWhiteIcon();
        virtualChessBoard[4][0].add(Player1Queen);
        virtualChessBoard[4][0].setOccupied(true);
        virtualChessBoard[4][0].setPiece(Player1Queen);

//        player1Pieces[6] = Player1Queen;

        //Place Player1 King
        King Player1King = new King("P1 King",3,0,1);
        Player1King.setWhiteIcon();
        virtualChessBoard[3][0].add(Player1King);
        virtualChessBoard[3][0].setOccupied(true);
        virtualChessBoard[3][0].setPiece(Player1King);

//        player1Pieces[7] = Player1King;

        //Place Player2 Queen
        Queens Player2Queen = new Queens("P2 Queen",4,7,2);
        Player2Queen.setBlackIcon();
        virtualChessBoard[4][7].add(Player2Queen);
        virtualChessBoard[4][7].setOccupied(true);
        virtualChessBoard[4][7].setPiece(Player2Queen);

//        player2Pieces[6] = Player2Queen;

        //Place Player2 King
        King Player2King = new King("P2 King",3,7,2);
        Player2King.setBlackIcon();
        virtualChessBoard[3][7].add(Player2King);
        virtualChessBoard[3][7].setOccupied(true);
        virtualChessBoard[3][7].setPiece(Player2King);

//        player2Pieces[7] = Player2King;

        //Place Pawns for Player1
        Pawn[] player1Pawns = new Pawn[8];

        for(int i = 0; i < 8; i++)
        {
            String p1PawnName = "p1Pawn" + i;
            player1Pawns[i] = new Pawn(p1PawnName,i,1,1);
            player1Pawns[i].setWhiteIcon();
            virtualChessBoard[i][1].add(player1Pawns[i]);
            virtualChessBoard[i][1].setOccupied(true);
//            player1Pieces[i + 8] = player1Pawns[i];
            virtualChessBoard[i][1].setPiece(player1Pawns[i]);
        }

        Pawn[] player2Pawns = new Pawn[8];

        for(int i = 0; i < 8; i++)
        {
            String p2PawnName = "p2Pawn" + i;
            player2Pawns[i] = new Pawn(p2PawnName,i,6,2);
            player2Pawns[i].setBlackIcon();
            virtualChessBoard[i][6].add(player2Pawns[i]);
            virtualChessBoard[i][6].setOccupied(true);
//            player2Pieces[i + 8] = player2Pawns[i];
            virtualChessBoard[i][6].setPiece(player2Pawns[i]);
        }
    }

    public static void colorChessBoard()
    {
//        for(int i = 0; i < 8; i++)
//        {
//            if(i % 2 != 0)
//            {
//                virtualChessBoard[i][0].setBackground(Color.gray);
//                virtualChessBoard[i][2].setBackground(Color.gray);
//                virtualChessBoard[i][4].setBackground(Color.gray);
//                virtualChessBoard[i][6].setBackground(Color.gray);
//            }
//        }
//
//        for(int i = 0; i < 8; i++)
//        {
//            if(i % 2 == 0)
//            {
//                virtualChessBoard[i][1].setBackground(Color.gray);
//                virtualChessBoard[i][3].setBackground(Color.gray);
//                virtualChessBoard[i][5].setBackground(Color.gray);
//                virtualChessBoard[i][7].setBackground(Color.gray);
//            }
//        }
        //Jordan I am just playing with the colors :D
        
        for(int i = 0; i < 8; i++)
        {
            if (i%2 == 0) {
                virtualChessBoard[i][1].setBackground(Color.decode("#C8E6C9"));
                virtualChessBoard[i][3].setBackground(Color.decode("#C8E6C9"));
                virtualChessBoard[i][5].setBackground(Color.decode("#C8E6C9"));
                virtualChessBoard[i][7].setBackground(Color.decode("#C8E6C9"));
            }
            if(i % 2 != 0){
                virtualChessBoard[i][0].setBackground(Color.decode("#C8E6C9"));
                virtualChessBoard[i][2].setBackground(Color.decode("#C8E6C9"));
                virtualChessBoard[i][4].setBackground(Color.decode("#C8E6C9"));
                virtualChessBoard[i][6].setBackground(Color.decode("#C8E6C9"));
            } 
        }
        for(int i = 0; i<8; i++){
            if (i%2 == 0) {
                virtualChessBoard[i][0].setBackground(Color.decode("#4CAF50"));
                virtualChessBoard[i][2].setBackground(Color.decode("#4CAF50"));
                virtualChessBoard[i][4].setBackground(Color.decode("#4CAF50"));
                virtualChessBoard[i][6].setBackground(Color.decode("#4CAF50"));
            }
            if(i % 2 != 0){
                virtualChessBoard[i][1].setBackground(Color.decode("#4CAF50"));
                virtualChessBoard[i][3].setBackground(Color.decode("#4CAF50"));
                virtualChessBoard[i][5].setBackground(Color.decode("#4CAF50"));
                virtualChessBoard[i][7].setBackground(Color.decode("#4CAF50"));
            } //4CAF50
        }
    }

//    public static void activatePlayerOnePieces()
//    {
//        for(int i = 0; i < 16; i++)
//        {
//            player1Pieces[i].isActive = true;
//        }
//    }
//
//    public static void deactivatePlayerOnePieces()
//    {
//        for(int i = 0; i < 16; i++)
//        {
//            player1Pieces[i].isActive = false;
//        }
//    }
//
//    public static void activatePlayerTwoPieces()
//    {
//        for(int i = 0; i < 16; i++)
//        {
//            player2Pieces[i].isActive = true;
//        }
//    }
//
//    public static void deactivatePlayerTwoPieces()
//    {
//        for(int i = 0; i < 16; i++)
//        {
//            player2Pieces[i].isActive = false;
//        }
//    }

    //passing destination set it
    private static int desX, desY;

    public static void setDestinationX(int x){
       desX = x;
    }
    public static void setDestinationY(int y){
        desY = y;
    }
    public static void setXandY(int x, int y){
        desX = x;
        desY = y;
        firstPiece.move(x, y);//movement method for move only
    }
    public static int getDestinationX(){
        return desX;
    }
    public static int getDestinationY(){
        return desY;
    }
    //tokill
    public static void setXandYKill(int x, int y){
        desX = x;
        desY = y;
        firstPiece.killmove(x,y);

    }

    }
