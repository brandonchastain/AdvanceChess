package com.bc;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import com.bc.pieces.*;

public class Board extends Canvas {
    public static final Board instance = new Board();
    public static final int length = 8;

    private Tile[][] tiles;
    private ArrayList<OnClickable> onClickables;

    public static Board getInstance() {
        return instance;
    }

    public void subscribeToClickEvent(OnClickable onClickable) {
        onClickables.add(onClickable);
    }

    public Tile getTileAt(int x, int y) {
        int r = y / Tile.TILE_HEIGHT;
        int c = x / Tile.TILE_WIDTH;
        Tile t = tiles[r][c];
        return t;
    }

    public Tile getTileAtRowCol(int row, int col) {
        Tile t = tiles[row][col];
        return t;
    }

    public void paint(Graphics g) {
        for (Tile[] row : tiles) {
            for (Tile t : row) {
                t.paint(g);
            }
        }
    }

    private Board()
    {
        tiles = new Tile[8][8];
        onClickables = new ArrayList<OnClickable>();
        boolean isWhite = true;
        for (int r = 0; r < tiles.length; r++) {
            for (int c = 0; c < tiles[r].length; c++) {
                tiles[r][c] = new Tile(r, c, isWhite ? Color.WHITE : Color.BLACK);
                isWhite = !isWhite;
            }
            
            isWhite = !isWhite;
        }

        // RNBQKBNR
        // pppppppp
        addPiece(tiles[0][0], new Rook(tiles[0][0], Color.BLACK));
        addPiece(tiles[0][1], new Knight(tiles[0][1], Color.BLACK));
        addPiece(tiles[0][2], new Bishop(tiles[0][2], Color.BLACK));
        addPiece(tiles[0][3], new Queen(tiles[0][3], Color.BLACK));
        addPiece(tiles[0][4], new King(tiles[0][4], Color.BLACK));
        addPiece(tiles[0][5], new Bishop(tiles[0][5], Color.BLACK));
        addPiece(tiles[0][6], new Knight(tiles[0][6], Color.BLACK));
        addPiece(tiles[0][7], new Rook(tiles[0][7], Color.BLACK));

        addPiece(tiles[7][0], new Rook(tiles[7][0], Color.WHITE));
        addPiece(tiles[7][1], new Knight(tiles[7][1], Color.WHITE));
        addPiece(tiles[7][2], new Bishop(tiles[7][2], Color.WHITE));
        addPiece(tiles[7][3], new Queen(tiles[7][3], Color.WHITE));
        addPiece(tiles[7][4], new King(tiles[7][4], Color.WHITE));
        addPiece(tiles[7][5], new Bishop(tiles[7][5], Color.WHITE));
        addPiece(tiles[7][6], new Knight(tiles[7][6], Color.WHITE));
        addPiece(tiles[7][7], new Rook(tiles[7][7], Color.WHITE));

        for (int col = 0; col < tiles[1].length; col++) {
            Tile tile = tiles[1][col];
            addPiece(tile, new Pawn(tiles[1][col], Color.BLACK, PawnDirection.Down));
        }

        for (int col = 0; col < tiles[7].length; col++) {
            Tile tile = tiles[6][col];
            addPiece(tile, new Pawn(tiles[6][col], Color.WHITE, PawnDirection.Up));
        }

        addMouseListener(new BoardMouseListener());
    }

    private void addPiece(Tile t, Piece p) {
        t.setPiece(p);
    }

    private class BoardMouseListener extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            int r = y / Tile.TILE_HEIGHT;
            int c = x / Tile.TILE_WIDTH;
            Tile t = tiles[r][c];
            t.OnMouseClicked();

            for (OnClickable o : onClickables) {
                o.OnClick(e);
            }
        }

    }
}
