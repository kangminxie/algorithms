package com.kangmin.algo.csce.recursion;

import java.applet.*;    //will use window
import java.awt.*;        //will use drawing methods

/**
 * This program uses a recursive method to draws a triangular fractal, stopping at pixel=4
 * This work was done using a java applet
 * Two methods were created: drawTriangle() and drawRecursionTriangles()
 * Step-1: draw the big black triangle using drawTriangle()
 * Step-2: calculate the coordinates of three points to draw a white triangle upside-down inside the black triangle
 * Step-3: draw the graphs use the as-obtained position
 * Step-4: recursion calls for the new triangles in three sub regions
 */

public class RecursionTriangles extends Applet {
    private Image display;            //define display as Image Type
    private Graphics drawingArea;    //define drawingArea as Graphics Type
    //Set stopping pixels as 4 for this homework
    private static final int STOP_PIXELS = 8;

    //initialize the graph and do recursion
    public void init() {
        int height = getSize().height;
        int width = getSize().width;
        display = createImage(width, height);
        drawingArea = display.getGraphics();
        //first draw the initial big black triangle
        drawTriangle(drawingArea, Color.black, 0, height, width / 2, 0, width, height);
        //now use recursion method to generate white triangle recursively
        drawRecursionTriangles(drawingArea, Color.white, 0, 0, width, height);
    }

    public void paint(Graphics g) {
        g.drawImage(display, 0, 0, null);
    }

    /**
     * This method draws and fill a triangle at certain positions
     * The triangle frame was plotted by default black color
     * Them the filling color will be used for the inside
     */
	private void drawTriangle(Graphics g, Color aColor, int x1, int y1, int x2, int y2, int x3, int y3) {
        Polygon myPolygon = new Polygon();
        myPolygon.addPoint(x1, y1);
        myPolygon.addPoint(x2, y2);
        myPolygon.addPoint(x3, y3);
		g.drawPolygon(myPolygon);	//draw the frame of the triangle(with black line)
        g.setColor(aColor);        //set the filling color
        g.fillPolygon(myPolygon);   //fill the triangle with desired color
    }


    /**
     * This method draws white triangle recursively
     * The triangle will filled with desired color
     * Once the side approaches STOP_PIXELS, the recursion will stop
     */
	private void drawRecursionTriangles(Graphics g, Color aColor, int x, int y, int width, int height) {
        if (width / 2 >= STOP_PIXELS) {
            //get the x coordinates of new white triangle to be drawn
            int x1 = x + width * 1 / 4;    //x coordinates of left points
            int x2 = x + width * 2 / 4;    //x coordinates of bottom points
            int x3 = x + width * 3 / 4;    //x coordinates of right points
            //get the y coordinates of new white triangle to be drawn
            int y1 = y + height * 1 / 2;    //y coordinates of left points
            int y2 = y + height * 1 / 1;    //y coordinates of bottom points
            int y3 = y + height * 1 / 2;    //y coordinates of right points
            //invoke the drawTriangle methods using the obtained coordinates above
            drawTriangle(g, aColor, x1, y1, x2, y2, x3, y3);

            //recursion call
            drawRecursionTriangles(g, aColor, x + width * 1 / 4, y + height * 0 / 4, width / 2, height / 2);    //top sub-graph's triangle
            drawRecursionTriangles(g, aColor, x + width * 0 / 4, y + height * 2 / 4, width / 2, height / 2);    //left sub-graph's triangle
            drawRecursionTriangles(g, aColor, x + width * 2 / 4, y + height * 2 / 4, width / 2, height / 2);    //right sub-graph's triangle
        }
    }

}
