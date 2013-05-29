package com.cesine.ipm.imageSample;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class ImageMidlet extends MIDlet {

    public void startApp() {
        Canvas canvas = new ImageCanvas(this);
        Display.getDisplay(this).setCurrent(canvas);
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean unconditional) {
    }

    void salir() {
        this.notifyDestroyed();
    }
}
