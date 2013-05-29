/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesine.demo.uisimple;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.*;

/**
 * @author julioa
 */
public class CanvasMidlet extends MIDlet {

    public void startApp() {
        Displayable canvas = new GraphCanvas();
        Display.getDisplay(this).setCurrent(canvas);        
    }
    
    public void pauseApp() {
    }
    
    public void destroyApp(boolean unconditional) {
    }
}
