/*
 * @(#)SampleCanvas.java	1.4 01/06/08
 * Copyright (c) 1999-2001 Sun Microsystems, Inc. All Rights Reserved.
 */

package com.cesine.ipm.tema3.guitests;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

class SampleCanvas extends Canvas{
    int     x, y;           // Location of cross hairs
    String  event = "";     // Last key event type
    int     keyCode;        // Last keyCode pressed
    Font    font;           // Font used for drawing text
    int     fh;             // height of the font
    int     w, h;           // width and height of the canvas
    int     titleHeight;    // Height of the title
    int     pieSize;        // Size of the Pie chart used for width and height
    int     barSize;        // Size of the Bar chart used for width and height
    int     eventHeight;    // Size of the event region
    int     pad;            // Padding used between items

    SampleCanvas() {
        w = getWidth();
        h = getHeight();
        font = Font.getFont(Font.FACE_SYSTEM,
			    Font.STYLE_PLAIN, Font.SIZE_SMALL);
        fh = font.getHeight();

        /* Compute the sizes of the bar and pie charts
         * It should use all the space except for the title
	 * and event regions.
         * Don't let the charts get too small
         */
        pad = 2;
        titleHeight = fh + pad * 2;
        eventHeight = fh * 3;
        barSize = h - (titleHeight + pad) - (eventHeight + pad);
        if (barSize < 20)               // Don't let them get too small
            barSize = 20;
        if (barSize > (w - pad) / 2)    // Shrink to 1/2 width
            barSize = (w - pad) / 2;
        pieSize = barSize;

        this.addCommand(new Command("Exit", Command.EXIT, 0));
        this.setCommandListener(Status.listener);
    }

    protected void keyPressed(int key) {
        keyCode = key;
        event = "Pressed";
        handleActions(key);
        repaint();
    }

    protected void keyRepeated(int key) {
        keyCode = key;
        event = "Repeated";
        handleActions(key);
        repaint();
    }

    protected void keyReleased(int key) {
        keyCode = key;
        event = "Released";
        repaint();
    }

    protected void pointerPressed(int x, int y) {
        this.x = x;
        this.y = y;
        keyCode = 0;
        event = "Pressed";
        repaint();
    }
    protected void pointerReleased(int x, int y) {
        this.x = x;
        this.y = y;
        keyCode = 0;
        event = "Released";
        repaint();
    }

    protected void pointerDragged(int x, int y) {
        this.x = x;
        this.y = y;
        keyCode = 0;
        event = "Dragged";
    }

    void handleActions(int keyCode) {
        int action = getGameAction(keyCode);
        switch (action) {
            case LEFT:
            x -= 1;
            break;
            case RIGHT:
            x += 1;
            break;
            case UP:
            y -= 1;
            break;
            case DOWN:
            y += 1;
            break;
        }
    }

    protected void paint(Graphics g) {

        g.setFont(font);
        g.setGrayScale(255);
        g.fillRect(0, 0, w, h);

        x = (x < 0) ? w - 1 : x;
        y = (y < 0) ? h - 1 : y;
        x = x % w;
        y = y % h;

        // Draw Fill and outline for background of title Text
        int swidth = pad * 2 + font.stringWidth("Pie and Bar Samples");
        int title_x = (w - swidth)/2;

        g.setGrayScale(128);
        g.fillRoundRect(title_x, 0, swidth, fh, 5, 5);
        g.setGrayScale(0);
        g.drawRoundRect(title_x, 0, swidth, fh, 5, 5);

        // Sample Text
        g.setColor(0, 0, 0);
        g.drawString("Pie and Bar Samples",
		     title_x + pad, pad, Graphics.TOP|Graphics.LEFT);

	// Translate to below title text
        g.translate(0, titleHeight + pad);

        /*
	 * Draw pie chart on the left side
	 * using the barSize for width and height
	 */
        g.setColor(255, 0, 0);
        g.fillArc(0, 0, pieSize, pieSize, 45, 270);
        g.setColor(0, 255, 0);
        g.fillArc(0, 0, pieSize, pieSize, 0, 45);
        g.setColor(0, 0, 255);
        g.fillArc(0, 0, pieSize, pieSize, 0, -45);
        g.setColor(0);
        g.drawArc(0, 0, pieSize, pieSize, 0, 360);

        // Draw Bar chart on right side of the display
        // scale the values to the pieSize maximum value
        int yorig = barSize;
        int h1 = barSize / 3, h2 = barSize / 2, h3 = barSize;
        int avg = (h1 + h2 + h3) / 3;

        // Move over to draw Bar chart
        g.translate((w + pad) / 2, 0);

        int bw = pieSize / 7;
        if (bw < 2)
             bw = 2;
        g.setColor(255, 0, 0);
        g.fillRect(bw*1, yorig-h1, bw+1, h1);
        g.setColor(0, 255, 0);
        g.fillRect(bw*3, yorig-h2, bw+1, h2);
        g.setColor(0, 0, 255);
        g.fillRect(bw*5, yorig-h3, bw+1, h3);
        g.setColor(0);
        g.drawRect(bw*1, yorig-h1, bw, h1);
        g.drawRect(bw*3, yorig-h2, bw, h2);
        g.drawRect(bw*5, yorig-h3, bw, h3);

        // Draw axis for bar chart.
        g.setGrayScale(0);
        g.drawLine(0, 0, 0, yorig);
        g.drawLine(0, yorig, barSize, yorig);
        g.setStrokeStyle(Graphics.DOTTED);
        g.drawLine(0, yorig - avg, barSize, yorig-avg);
        g.setStrokeStyle(Graphics.SOLID);

	// Restore to left and move down
        g.translate(-(w + pad) / 2, pieSize + pad);

        // Draw the key and pointer status
        g.setColor(128, 128, 128);
        int col1 = font.stringWidth("Action:");
        g.drawString("Key: ",      col1,     0,
		     Graphics.TOP|Graphics.RIGHT);
        g.drawString(keyString(keyCode), col1, 0,
		     Graphics.TOP|Graphics.LEFT);
        g.drawString("Action:",    col1,     fh,
		     Graphics.TOP|Graphics.RIGHT);
        g.drawString(actionString(keyCode), col1, fh,
		     Graphics.TOP|Graphics.LEFT);
        g.drawString("Event:",     col1,     fh*2,
		     Graphics.TOP|Graphics.RIGHT);
        g.drawString(event,        col1,     fh*2,
		     Graphics.TOP|Graphics.LEFT);
        int col2 = 80;
        g.drawString("x:",         col2,     0,
		     Graphics.TOP|Graphics.RIGHT);
        g.drawString(Integer.toString(x), col2, 0,
		     Graphics.TOP|Graphics.LEFT);
        g.drawString("y:",         col2,     fh,
		     Graphics.TOP|Graphics.RIGHT);
        g.drawString(Integer.toString(y), col2, fh,
		     Graphics.TOP|Graphics.LEFT);

        // Restore the origin and draw the crosshairs on top
        g.translate(-g.getTranslateX(), -g.getTranslateY());

        g.setColor(0, 0, 0);
        g.drawLine(x, y - 5, x, y + 5);
        g.drawLine(x - 5, y, x + 5, y);
    }

    String keyString(int keyCode) {
        if (keyCode == 0) {
            return "";
        }
        return Integer.toString(keyCode);
    }

    String actionString(int keyCode) {
        if (keyCode == 0) {
            return "";
        }

	int action = getGameAction(keyCode);
	switch (action) {
	case FIRE:
	    return "Fire";
	case LEFT:
	    return "Left";
	case RIGHT:
	    return "Right";
	case DOWN:
	    return "Down";
	case UP:
	    return "Up";
	case GAME_A:
	    return "Game A";
	case GAME_B:
	    return "Game B";
	case GAME_C:
	    return "Game C";
	case GAME_D:
	    return "Game D";
	case 0:
	    return "";
	default:
	    return Integer.toString(action);
	}
    }


}
