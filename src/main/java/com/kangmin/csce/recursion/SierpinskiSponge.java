package main.java.com.kangmin.csce.recursion;

import java.applet.Applet;
import java.awt.*;

public class SierpinskiSponge extends Applet {
    private Image display;
    private Graphics drawingArea;

    public void init() {
        int height = getSize().height;
        int width = getSize().width;
        display = createImage(width, height);
        drawingArea = display.getGraphics();
        drawGasket(0, 0, height, drawingArea);
    }

    public void paint(Graphics g) {
        g.drawImage(display, 0, 0, null);
    }

    private void drawGasket(int x, int y, int side, Graphics g) {
        int sub = side / 3;
        //Draw a square
        g.fillRect(x + sub, y + sub, sub, sub);
        if (sub >= 3) {
            //top 3 square
            drawGasket(x + sub * 0, y + sub * 0, sub, g);
            drawGasket(x + sub * 1, y + sub * 0, sub, g);
            drawGasket(x + sub * 2, y + sub * 0, sub, g);
            //middle left and right
            drawGasket(x + sub * 0, y + sub * 1, sub, g);
            drawGasket(x + sub * 2, y + sub * 1, sub, g);
            //bottom 3 square
            drawGasket(x + sub * 0, y + sub * 2, sub, g);
            drawGasket(x + sub * 1, y + sub * 2, sub, g);
            drawGasket(x + sub * 2, y + sub * 2, sub, g);
        }
    }
}
