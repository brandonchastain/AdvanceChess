package com.bc;

import java.awt.*;
import java.awt.event.*;

public class Window extends Frame {

    private Canvas c;

    public Window(){
        setTitle("AdvanceChess");
        setSize(800, 800);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        c = new MyCanvas();
        add(c);

        repaint();
        setVisible(true);
    }

    public class MyCanvas extends Canvas {

        public void paint(Graphics g) {
            Board.getInstance().paint(g);
        }
    }
}
