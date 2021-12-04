package com.bc.pieces;

import java.awt.Color;
import java.util.ArrayList;

import com.bc.Tile;
import com.bc.Board;

public class Pawn extends Piece {

    private PawnDirection direction;
    private boolean hasBeenMoved;

    public Pawn(Tile t, Color c, PawnDirection d) {
        super(t, c);
        direction = d;
    }

    @Override
    public String getPieceLetter() {
        return "p";
    }

    @Override
    public ArrayList<Tile> getPossibleMoves() {
        ArrayList<Tile> result = new ArrayList<Tile>();
        int row = tile.getRow();

        int adj = 0;
        if (direction == PawnDirection.Up && row > 0) {
            adj = -1;
        } else if (direction == PawnDirection.Down && row < Board.length - 1) {
            adj = 1;
        }

        row += adj;

        Tile forwardSpace = Board.getInstance().getTileAtRowCol(row, tile.getCol());
        if (forwardSpace.getPiece() == null) {
            result.add(forwardSpace);
        }

        if (!hasBeenMoved&& row + adj >= 0 && row + adj < Board.length) {
            Tile next = Board.getInstance().getTileAtRowCol(row + adj, tile.getCol());
            if (next.getPiece() == null) {
                result.add(next);
            }
        }

        if (tile.getCol() > 0) {
            Tile fwdLeft = Board.getInstance().getTileAtRowCol(row, tile.getCol() - 1);
            Piece l = fwdLeft.getPiece();
            if (l != null && l.getColor() != this.getColor()) {
                result.add(fwdLeft);
            }
        }

        if (tile.getCol() <= Board.length) {
            Tile fwdRight = Board.getInstance().getTileAtRowCol(row, tile.getCol() + 1);
            Piece r = fwdRight.getPiece();
            if (r != null && r.getColor() != this.getColor()) {
                result.add(fwdRight);
            }
        }

        return result;
    }

    @Override
    public void onMove() {
        hasBeenMoved = true;
    }
    
}
