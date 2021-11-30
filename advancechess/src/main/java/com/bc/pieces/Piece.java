package com.bc.pieces;
import java.awt.Color;
import java.awt.Graphics;

import com.bc.Tile;

import java.awt.Font;

public abstract class Piece {
    private Tile tile;

    public void paint(Graphics g) {
        String l = getPieceLetter();
        int size = 32;
        Font f = new Font("Arial", 0, size);
        g.setFont(f);
        g.setColor(Color.RED);
        g.drawString(l, tile.getPosX() + Tile.TILE_WIDTH/2, tile.getPosY() + Tile.TILE_HEIGHT/2);
    }

    public void setTile(Tile t) {
        tile = t;
    }
 
    public abstract String getPieceLetter();
}
