package com.bc.pieces;

import java.awt.Color;

import com.bc.Tile;

public class Knight extends Piece {

    public Knight(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "Kn";
    }
    
}
