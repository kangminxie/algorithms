package main.java.com.kangmin.csce.recursion;

import java.applet.Applet;
import java.awt.*;
import java.util.Random;

public class RandomFractal extends Applet {

    private Image display;
    private Graphics drawingArea;

    public void init() {
        int height = getSize().height;
        int width = getSize().width;
        display = createImage(width, height);
        drawingArea = display.getGraphics();
        randomFractal(0, height / 2, width, height / 2, drawingArea);
    }

    public void paint(Graphics g) {
        g.drawImage(display, 0, 0, null);
    }

    private static void randomFractal(int leftX, int leftY,
                                      int rightX, int rightY,
                                      Graphics drawingArea) {
        final int STOP = 4;
        final int MAX = 12;
        int midX, midY, delta;
        Random r = new Random();
        if ((rightX - leftX) <= STOP) {
            drawingArea.drawLine(leftX, leftY, rightX, rightY);
        } else {
            midX = (leftX + rightX) / 2;
            midY = (leftY + rightY) / 2;
            delta = r.nextInt(MAX);
            midY += delta;
            randomFractal(leftX, leftY, midX, midY, drawingArea);
            randomFractal(midX, midY, rightX, rightY, drawingArea);
        }
    }
}
