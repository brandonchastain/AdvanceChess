package com.bc;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ChessGame game = ChessGame.getInstance();
        Window w = new Window(game);

        w.repaint();

        game.play();
    }
}
