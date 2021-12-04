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

        for (int i = row - 1; i <= row + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i >= 0 && i < Board.length && j >= 0 && j < Board.length && (row != i || col != j)) {
                    addTileToMoveSet(board.getTileAtRowCol(i, j), results);
                }
            }
        }

        return results;
    }
}
