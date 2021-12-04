package com.bc.pieces;

import java.awt.Color;
import java.util.ArrayList;

import com.bc.Board;
import com.bc.Tile;

public class Queen extends Piece {

    public Queen(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "Q";
    }

    @Override
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> result = new ArrayList<Tile>();
        Board board = Board.getInstance();

        for (int r = tile.getRow() - 1; r >= 0; r--) {
            Tile t = board.getTileAtRowCol(r, tile.getCol());
            if (addTileToMoveSet(t, result)) {
                break;
            }
        }

        for (int r = tile.getRow() + 1; r < Board.length; r++) {
            Tile t = board.getTileAtRowCol(r, tile.getCol());
            if (addTileToMoveSet(t, result)) {
                break;
            }
        }

        for (int c = tile.getCol() - 1; c >= 0; c--) {
            Tile t = board.getTileAtRowCol(tile.getRow(), c);
            if (addTileToMoveSet(t, result)) {
                break;
            }
        }

        for (int c = tile.getCol() + 1; c < Board.length; c++) {
            Tile t = board.getTileAtRowCol(tile.getRow(), c);
            if (addTileToMoveSet(t, result)) {
                break;
            }
        }

        int row = tile.getRow() - 1;
        int col = tile.getCol() - 1;
        while (row >= 0 && col >= 0) {
            Tile t = board.getTileAtRowCol(row, col);
            if (addTileToMoveSet(t, result)) {
                break;
            }
            row--;
            col--;
        }

        row = tile.getRow() - 1;
        col = tile.getCol() + 1;
        while (row >= 0 && col < Board.length) {
            Tile t = board.getTileAtRowCol(row, col);
            if (addTileToMoveSet(t, result)) {
                break;
            }
            row--;
            col++;
        }

        row = tile.getRow() + 1;
        col = tile.getCol() + 1;
        while (row < Board.length && col < Board.length) {
            Tile t = board.getTileAtRowCol(row, col);
            if (addTileToMoveSet(t, result)) {
                break;
            }
            row++;
            col++;
        }

        row = tile.getRow() + 1;
        col = tile.getCol() - 1;
        while (row < Board.length && col >= 0) {
            Tile t = board.getTileAtRowCol(row, col);
            if (addTileToMoveSet(t, result)) {
                break;
            }
            row++;
            col--;
        }

        return result;
    }
    
}
