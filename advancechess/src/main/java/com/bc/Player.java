package com.bc;
import java.awt.Color;
import com.bc.pieces.*;

public abstract class Player {
    protected Color color;
    
    public Player(Color c) {
        color = c;
    }

    public abstract void makeMove();
}
