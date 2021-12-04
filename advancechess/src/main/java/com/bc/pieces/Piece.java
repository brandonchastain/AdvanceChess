package com.bc.pieces;
import java.awt.Color;
import java.awt.Graphics;

import com.bc.Tile;

import java.awt.Font;
import java.util.ArrayList;

public abstract class Piece {
    protected Tile tile;
    private Color color;

    public Piece(Tile t, Color c) {
        tile = t;
        color = c;
    }

    public void paint(Graphics g) {
        int x = tile.getPosX() + Tile.TILE_WIDTH / 2;
        int y = tile.getPosY() + Tile.TILE_HEIGHT / 2;
        g.setColor(Color.GRAY);
        g.fillRect(x - 20, y - 25, 70, 50);

        String l = getPieceLetter();
        int size = 32;
        Font f = new Font("Arial", 0, size);
        g.setFont(f);
        g.setColor(color);
        g.drawString(l, x, y);
    }
 
    public abstract String getPieceLetter();

    public ArrayList<Tile> getPossibleMoves() {
        return new ArrayList<Tile>();
    }

    public Color getColor() {
        return color;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile t) {
        tile = t;
    }

}
