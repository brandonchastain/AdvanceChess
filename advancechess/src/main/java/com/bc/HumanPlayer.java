package com.bc;
import com.bc.pieces.Piece;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.*;

public class HumanPlayer extends Player implements OnClickable {
    private boolean isMyTurn;
    private boolean showingMoves;
    private HashMap<Tile, Color> oldColors;
    private ArrayList<Tile> shownMoves;

    public HumanPlayer(Color c) {
        super(c);
        oldColors = new HashMap<Tile, Color>();
    }

    /// Accepts user input to move a piece.
    @Override
    public void makeMove() {
        System.out.println("Player making move.");
        setIsMyTurn(true);
        while (isMyTurn()) {
            try {
                if (ChessGame.getInstance().isGameOver()) {
                    return;
                }
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Player completed move.");
    }

    @Override
    public void OnClick(MouseEvent e) {
        if (!isMyTurn()) {
            return;
        }

        if (showingMoves) {
            showingMoves = false;
            for (Tile m : shownMoves) {
                m.setColor(oldColors.get(m));
            }
            oldColors.clear();
            shownMoves.clear();

            // move the piece

            setIsMyTurn(false);

            return;
        }

        Tile t = Board.getInstance().getTileAt(e.getX(), e.getY());
        Piece p = t.getPiece();

        System.out.println(String.format("Player clicked %s", p.getPieceLetter()));

        if (this.color != p.getColor()) {
            return;
        }

        // start showing move locations
        shownMoves = p.getPossibleMoves();
        for (Tile m : shownMoves) {
            oldColors.put(m, m.getColor());
            m.setColor(Color.RED);
        }
        showingMoves = true;
        Board.getInstance().repaint();
    }

    private synchronized boolean isMyTurn() {
        return isMyTurn;
    }

    private synchronized void setIsMyTurn(boolean b) {
        isMyTurn = b;
    }
    
}
