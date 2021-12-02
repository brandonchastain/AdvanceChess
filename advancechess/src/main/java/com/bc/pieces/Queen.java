package com.bc.pieces;

import java.awt.Color;

import com.bc.Tile;

public class Queen extends Piece {

    public Queen(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "Q";
    }
    
}
