package com.bc;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import com.bc.pieces.*;

public class ChessGame {
    private int turn;
    private boolean gameOver;
    private Player p1;
    private Player p2;
    private ArrayList<Piece> outOfPlayPieces;

    private static ChessGame instance = new ChessGame();

    public static ChessGame getInstance() {
        return instance;
    }

    private ChessGame() {
        p1 = new HumanPlayer(Color.WHITE);
        p2 = new HumanPlayer(Color.BLACK);
        Board.getInstance().subscribeToClickEvent((HumanPlayer)p1);
        Board.getInstance().subscribeToClickEvent((HumanPlayer)p2);
    }

    public void play() {
        System.out.println("Dun-dun-dun-dun-dun! Let the game begin!");
        while (!isGameOver()) {
            tick();
        }

        System.out.println("Game over!");
    }

    public void tick() {
        System.out.println("P1's turn");
        p1.makeMove();
        checkGameCondition();
        Board.getInstance().repaint();

        System.out.println("P2's turn");
        p2.makeMove();
        checkGameCondition();
        Board.getInstance().repaint();
        turn++;
    }

    public void checkGameCondition() {
        // check if game is over

        // check for special conditions (pawn reached last row, en passent, etc)
    }

    public void movePiece(Piece p, Tile from, Tile to) {
        from.setPiece(null);
        to.setPiece(p);
        p.setTile(to);

        p.onMove();
    }

    public synchronized boolean isGameOver() {
        return gameOver;
    }

    public synchronized void setGameOver() {
        gameOver = true;
    }
}
