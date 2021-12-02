package com.bc.pieces;

import java.awt.Color;

import com.bc.Tile;

public class King extends Piece {

    public King(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "K";
    }
    
}
