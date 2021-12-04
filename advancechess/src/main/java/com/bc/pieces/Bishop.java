package com.bc.pieces;

import java.awt.Color;
import java.util.ArrayList;

import com.bc.Board;
import com.bc.Tile;

public class Bishop extends Piece {

    public Bishop(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "B";
    }
    
    @Override
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> result = new ArrayList<Tile>();
        Board board = Board.getInstance();

        int row = tile.getRow() - 1;
        int col = tile.getCol() - 1;
        while (row >= 0 && col >= 0) {
            Tile t = board.getTileAtRowCol(row, col);
            if (t.getPiece() != null) {
                break;
            }
            result.add(t);
            row--;
            col--;
        }

        row = tile.getRow() - 1;
        col = tile.getCol() + 1;
        while (row >= 0 && col < Board.length) {
            Tile t = board.getTileAtRowCol(row, col);
            if (t.getPiece() != null) {
                break;
            }
            result.add(t);
            row--;
            col++;
        }

        row = tile.getRow() + 1;
        col = tile.getCol() + 1;
        while (row < Board.length && col < Board.length) {
            Tile t = board.getTileAtRowCol(row, col);
            if (t.getPiece() != null) {
                break;
            }
            result.add(t);
            row++;
            col++;
        }

        row = tile.getRow() + 1;
        col = tile.getCol() - 1;
        while (row < Board.length && col >= 0) {
            Tile t = board.getTileAtRowCol(row, col);
            if (t.getPiece() != null) {
                break;
            }
            result.add(t);
            row++;
            col--;
        }

        return result;
    }
}
