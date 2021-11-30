package com.bc;

import java.awt.*;
import java.awt.event.*;

public class Window extends Frame {
    public Window(){
        setTitle("AdvanceChess");
        setSize(800, 800);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        add(Board.getInstance());

        repaint();
        setVisible(true);
    }
}
