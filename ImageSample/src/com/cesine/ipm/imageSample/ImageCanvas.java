/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.ipm.imageSample;

import com.cesine.ipm.imageSample.util.ImageUtil;
import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/**
 *
 * @author julioa
 */
public class ImageCanvas extends Canvas implements CommandListener {

    int x = 0;
    int y = 0;
    int oldX = 0;
    int oldY = 0;
    int pinX = 0;
    int pinY = 0;
    boolean created = false;
    ImageMidlet midlet = null;
    Command exitCommand = null;
    Font font = null;
    int fh = 0;

    public ImageCanvas(ImageMidlet midlet) {
        this.midlet = midlet;
        exitCommand = new Command("Salir", Command.EXIT, 1);
    }

    protected void paint(Graphics g) {

        if (created == false) {

            this.addCommand(exitCommand);
            this.setCommandListener(this);

            g.setColor(128, 128, 128);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            font = Font.getFont(Font.FACE_SYSTEM,
                    Font.STYLE_PLAIN, Font.SIZE_SMALL);
            fh = font.getHeight();



            Image image = null;
            try {
                image = Image.createImage("/cesine.jpg");
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }

            Image finalImage = ImageUtil.resizeImage3(image, this.getWidth(), this.getHeight());
            g.drawImage(finalImage, this.getWidth() / 2, this.getHeight() / 2, Graphics.HCENTER | Graphics.VCENTER);

            x = this.getWidth() / 2;
            y = this.getHeight() / 2;
            oldX = x;
            oldY = y;
            pinX = x;
            pinY = y;

            g.setColor(255, 0, 0);
            g.fillArc(pinX - 3, pinY - 3, 6, 6, 0, 360);

            created = true;
        } else {
            g.setColor(0, 255, 0);
            g.drawLine(oldX, oldY, x, y);
            oldX = x;
            oldY = y;

            double d = Math.sqrt(((x - pinX) * (x - pinX)) + ((y - pinY) * (y - pinY)));

            g.setColor(255, 255, 255);
            g.fillRect(0, 0, this.getWidth(), 12);

            g.setFont(font);
            g.setColor(0, 0, 0);
            g.drawString("x : " + x + " y : " + y + " d : " + d, 0, 0, g.TOP | g.LEFT);

        }
    }

    protected void keyRepeated(int key) {
        handleActions(key);
    }

    protected void keyPressed(int key) {
        handleActions(key);
    }

    void handleActions(int keyCode) {

        oldX = x;
        oldY = y;

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


        repaint();
    }

    public void commandAction(Command c, Displayable d) {
        if (c == exitCommand) {
            midlet.salir();
        }
    }
}
