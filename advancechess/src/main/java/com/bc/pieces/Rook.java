package com.bc.pieces;

import java.awt.Color;

import com.bc.Tile;

public class Rook extends Piece {

    public Rook(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "R";
    }
    
}
