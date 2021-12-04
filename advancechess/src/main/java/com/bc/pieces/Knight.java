package com.bc.pieces;

import java.awt.Color;
import java.util.ArrayList;

import com.bc.Board;
import com.bc.Tile;

public class Knight extends Piece {

    public Knight(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "Kn";
    }

    @Override
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> results = new ArrayList<Tile>();
        int row = tile.getRow();
        int col = tile.getCol();

        addIfPossible(row-2, col-1, results);
        addIfPossible(row-1, col-2, results);
        addIfPossible(row-2, col+1, results);
        addIfPossible(row-1, col+2, results);
        addIfPossible(row+2, col-1, results);
        addIfPossible(row+1, col-2, results);
        addIfPossible(row+2, col+1, results);
        addIfPossible(row+1, col+2, results);

        return results;
    }

    private void addIfPossible(int r, int c, ArrayList<Tile> results) {
        Board board = Board.getInstance();

        if (r >= 0 && r < Board.length
            && c >= 0 && c < Board.length
            && (r != tile.getRow() || c != tile.getCol())) {

            Tile t = board.getTileAtRowCol(r, c);
            results.add(t);
        }
    }
}
