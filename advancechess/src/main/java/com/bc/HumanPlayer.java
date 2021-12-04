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
    private Piece movingPiece;

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

        // this logic should move to some methods including Game.Move(...)
        Tile clicked = Board.getInstance().getTileAt(e.getX(), e.getY());
        if (movingPiece != null) {
            if (clicked != movingPiece.getTile() && clicked.getColor() == Color.RED) {
                // move the piece
                ChessGame.getInstance().movePiece(movingPiece, movingPiece.getTile(), clicked);
            }

            //clear other possible moves
            for (Tile m : shownMoves) {
                m.setColor(oldColors.get(m));
            }
            oldColors.clear();
            shownMoves.clear();

            movingPiece = null;
            setIsMyTurn(false);
            return;
        }

        // Move this to Game.getPieceInfo(...)
        Tile t = Board.getInstance().getTileAt(e.getX(), e.getY());
        Piece p = t.getPiece();

        System.out.println(String.format("Player clicked %s", p.getPieceLetter()));

        // Move this to Game.showMoves(...)
        if (this.color != p.getColor()) {
            return;
        }

        // start showing move locations
        shownMoves = p.getPossibleMoves();
        
        if (shownMoves.size() == 0) {
            System.out.println("No available moves from that piece");
            return;
        }

        for (Tile m : shownMoves) {
            oldColors.put(m, m.getColor());
            m.setColor(Color.RED);
        }

        movingPiece = p;

        Board.getInstance().repaint();
    }

    private synchronized boolean isMyTurn() {
        return isMyTurn;
    }

    private synchronized void setIsMyTurn(boolean b) {
        isMyTurn = b;
    }
    
}
