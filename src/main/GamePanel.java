package main;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.Graphics;

public class GamePanel extends JPanel{
    //Coordinates where rectangle is drawn at
    private int xDelta = 100, yDelta = 100;
    private int frames = 0;
    private long lastChecked = 0;
    //Constructor
    public GamePanel() {
        MouseInputs mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        Map map = new Map(this);
    }
    public void changeX(int value){
        this.xDelta += value;

    }
    public void changeY(int value){
        this.yDelta += value;

    }
    public void drawRect(int x, int y)
    {
        this.xDelta = x;
        this.yDelta = y;

    }

    @Override
    public void paintComponent(Graphics g){

        //Keeping the drawing sheet clean
        super.paintComponent(g);

        //Draw functions
        g.fillRect(xDelta,yDelta,50, 50);
        g.drawRect(400, 400, 2000, 1000);w
        frames++;
        //Check if a second passes/ has passed.
        if(System.currentTimeMillis() - lastChecked >= 1000) {
            lastChecked = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }
}
