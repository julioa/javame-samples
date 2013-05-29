/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cesine.ipm.cabarceno.roberto;

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
 * @author Roberto
 */
public class ImageCanvas extends Canvas implements CommandListener{

    int x=0;
    int y=0;
    int oldX = 0;
    int oldY = 0;
    int pinX = 0;
    int pinY = 0;
    int nivelzoom = 0;
    boolean created = false;
    Font font = null;
    Command zoomMas = null;
    int fh = 0;


    protected void paint(Graphics g) {
        


        if (created == false) {
        
            zoomMas=new Command("zoomMas", Command.OK, 1);
            this.addCommand(zoomMas);
            this.setCommandListener(this);

        Image image = null;
        try {
            //image = Image.createImage("/com/cesine/ipm/cabarceno/roberto/text.jpg");
            image = Image.createImage("/com/cesine/ipm/cabarceno/roberto/jupiter.png");
            g.drawImage(image, (this.getWidth()/2), (this.getHeight()/2), Graphics.HCENTER |Graphics.VCENTER);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

            font = Font.getFont(Font.FACE_SYSTEM,Font.STYLE_PLAIN, Font.SIZE_SMALL);
            fh = font.getHeight();


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
            g.setColor(0, 0, 255);
            g.drawLine(oldX, oldY, x, y);
            oldX = x;
            oldY = y;

            double d = Math.sqrt(((x - pinX) * (x - pinX)) + ((y - pinY) * (y - pinY)));

            g.setColor(255, 255, 255);
            g.fillRect(0, 0, this.getWidth(), 12);

            g.setFont(font);
            g.setColor(0, 0, 0);
            g.drawString("Nivel de zoom : " + x + " y : " + y + " d : " + d, 0, 0, g.TOP | g.LEFT);

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
            if (c == zoomMas) {
                nivelzoom=nivelzoom+1;
            }
        }



}
