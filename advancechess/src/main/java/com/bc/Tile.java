package com.bc;

import java.awt.Color;
import java.awt.Graphics;

public class Tile {
    public static final int TILE_WIDTH = 100;
    public static final int TILE_HEIGHT = 100;

    private int row;
    private int col;
    private Color color;
    private Piece piece;

    public Tile(int r, int c, Color cc) {
        row = r;
        col = c;
        color = cc;
        piece = null;
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(getPosX(), getPosY(), TILE_WIDTH, TILE_HEIGHT);
        if (piece != null) {
            piece.paint(g);
        }
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setPiece(Piece p) {
        piece = p;
    }

    public int getPosY() {
        return row * TILE_HEIGHT;
    }

    public int getPosX() {
        return col * TILE_WIDTH;
    }

    public Color getColor() {
        return color;
    }
}
