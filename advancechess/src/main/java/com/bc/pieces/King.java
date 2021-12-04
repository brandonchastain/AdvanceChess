package com.bc.pieces;

import java.awt.Color;
import java.util.ArrayList;

import com.bc.Board;
import com.bc.Tile;

public class King extends Piece {

    public King(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "K";
    }

    @Override
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> results = new ArrayList<Tile>();
        int row = tile.getRow();
        int col = tile.getCol();
        Board board = Board.getInstance();

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (i >= 0 && i < Board.length && j >= 0 && j < Board.length && (row != i || col != j)) {
                    results.add(board.getTileAtRowCol(i, j));
                }
            }
        }

        return results;
    }
}
