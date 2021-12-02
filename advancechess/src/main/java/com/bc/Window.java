package com.bc;

import java.awt.*;
import java.awt.event.*;

public class Window extends Frame {
    private ChessGame chessGame;

    public Window(ChessGame cg){
        chessGame = cg;

        setTitle("AdvanceChess");
        setSize(800, 800);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                chessGame.setGameOver();
                dispose();
            }
        });

        add(Board.getInstance());

        repaint();
        setVisible(true);
    }
}
