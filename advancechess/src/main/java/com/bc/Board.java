package com.bc;
import java.awt.Color;
import java.awt.Graphics;

public class Board {
    public static final Board instance = new Board();
    public static final int length = 8;

    private Tile[][] tiles;

    public static Board getInstance() {
        return instance;
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
        addPiece(tiles[0][0], new Rook());
        addPiece(tiles[0][1], new Knight());
        addPiece(tiles[0][2], new Bishop());
        addPiece(tiles[0][3], new Queen());
        addPiece(tiles[0][4], new King());
        addPiece(tiles[0][5], new Bishop());
        addPiece(tiles[0][6], new Knight());
        addPiece(tiles[0][7], new Rook());

        addPiece(tiles[7][0], new Rook());
        addPiece(tiles[7][1], new Knight());
        addPiece(tiles[7][2], new Bishop());
        addPiece(tiles[7][3], new Queen());
        addPiece(tiles[7][4], new King());
        addPiece(tiles[7][5], new Bishop());
        addPiece(tiles[7][6], new Knight());
        addPiece(tiles[7][7], new Rook());

        for (int col = 0; col < tiles[1].length; col++) {
            Tile tile = tiles[1][col];
            addPiece(tile, new Pawn());
        }

        for (int col = 0; col < tiles[7].length; col++) {
            Tile tile = tiles[6][col];
            addPiece(tile, new Pawn());
        }
    }

    private void addPiece(Tile t, Piece p) {
        t.setPiece(p);
        p.setTile(t);
    }
}
