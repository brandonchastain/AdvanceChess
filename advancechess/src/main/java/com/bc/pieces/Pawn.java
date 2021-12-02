package com.bc.pieces;

import java.awt.Color;
import java.util.ArrayList;

import com.bc.Tile;
import com.bc.Board;
import com.bc.Direction;

public class Pawn extends Piece {

    private Direction direction;

    public Pawn(Tile t, Color c, Direction d) {
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
        Tile forwardSpace = null;
        int row = tile.getRow();
        if (direction == Direction.Up && row > 0) {
            forwardSpace = Board.getInstance().getTileAtRowCol(row - 1, tile.getCol());
        } else if (direction == Direction.Down && row < Board.length) {
            forwardSpace = Board.getInstance().getTileAtRowCol(row + 1, tile.getCol());
        }

        result.add(forwardSpace);
        return result;
    }
    
}
