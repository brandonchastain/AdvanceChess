package com.bc;
import java.util.ArrayList;
import com.bc.pieces.*;

public class ChessGame {
    private int turn;
    private Player p1;
    private Player p2;
    private ArrayList<Piece> outOfPlayPieces;

    public tick() {
        p1.makeMove();
        p2.makeMove();
        checkGameCondition();
        turn++;
    }
}
