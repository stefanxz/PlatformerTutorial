package main;

import inputs.KeyboardInputs;
//muie
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    //Coordinates where rectangle is drawn at
    private int xDelta = 100, yDelta = 100;
    //Constructor pulamea?
    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }
    public void changeX(int value){
        this.xDelta += value;
        repaint();
    }
    public void changeY(int value){
        this.yDelta += value;
        repaint();
    }
    public void drawRect(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }
//cacat

    public void paintComponent(Graphics g){

        //Keeping the drawing sheet clean
        super.paintComponent(g);

        //Draw functions
        g.fillRect(xDelta,yDelta,200, 50);
    }
}
