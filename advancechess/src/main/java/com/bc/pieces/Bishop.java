package com.bc.pieces;

import java.awt.Color;

import com.bc.Tile;

public class Bishop extends Piece {

    public Bishop(Tile t, Color c) {
        super(t, c);
    }

    @Override
    public String getPieceLetter() {
        return "B";
    }
    
}
